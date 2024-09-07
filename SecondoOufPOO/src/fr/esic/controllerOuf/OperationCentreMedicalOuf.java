package fr.esic.controllerOuf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.esic.modelOuf.RdvMedicalOuf;

public class OperationCentreMedicalOuf {

	// liste Carte de crédit
	public static List<RdvMedicalOuf> rdvMedicals = new ArrayList<>();

	public static List<RdvMedicalOuf> generalisteMedicals = new ArrayList<>();

	public static List<RdvMedicalOuf> ophtalmoMedicals = new ArrayList<>();

	public static List<RdvMedicalOuf> dermatoMedicals = new ArrayList<>();

	// Afficher tous les RDV ADMIN
	public static void allRdvAdmin(String affichage) {

		MyLibraryOuf.afficher(affichage);
		String dataRdvAdmin = "";

		for (RdvMedicalOuf rdv : rdvMedicals) {
			dataRdvAdmin += rdvMedicals.indexOf(rdv) + "- " + rdv.infoRdvMedicalAdmin() + "\n";

		}
		MyLibraryOuf.afficher(dataRdvAdmin);
	}

	// Afficher tous les Généralistes ADMIN
	public static void allGeneralisteAdmin(String affichage) {

		MyLibraryOuf.afficher(affichage);
		String dataGeneralisteAdmin = "";

		for (RdvMedicalOuf praticien : generalisteMedicals) {
			dataGeneralisteAdmin += generalisteMedicals.indexOf(praticien) + "- " + praticien.infoPraticienAdmin()
					+ "\n";

		}
		MyLibraryOuf.afficher(dataGeneralisteAdmin);
	}

	// Afficher tous les ophtalmologues ADMIN
	public static void allOphtalmoAdmin(String affichage) {

		MyLibraryOuf.afficher(affichage);
		String dataOphtalmoAdmin = "";

		for (RdvMedicalOuf praticien : ophtalmoMedicals) {
			dataOphtalmoAdmin += ophtalmoMedicals.indexOf(praticien) + "- " + praticien.infoPraticienAdmin() + "\n";

		}
		MyLibraryOuf.afficher(dataOphtalmoAdmin);
	}

	// Afficher tous les ophtalmologues ADMIN
	public static void allDermatoAdmin(String affichage) {

		MyLibraryOuf.afficher(affichage);
		String dataDermatoAdmin = "";

		for (RdvMedicalOuf praticien : ophtalmoMedicals) {
			dataDermatoAdmin += ophtalmoMedicals.indexOf(praticien) + "- " + praticien.infoPraticienAdmin() + "\n";

		}
		MyLibraryOuf.afficher(dataDermatoAdmin);
	}

	// Afficher RDV USER
	public static String onlyRdvUser(int idUser) {

		String dataRdvUser = "";

		for (RdvMedicalOuf rdv : rdvMedicals) {

			if ((rdv.getNomPatient().equals(OperationPersonOuf.users.get(idUser).getNomUser()))
					&& (rdv.getPrenomPatient().equals(OperationPersonOuf.users.get(idUser).getPrenomUser()))) {

				dataRdvUser += rdvMedicals.indexOf(rdv) + " - " + rdv.infoRdvMedicalUser() + "\n";
			}

		}
		return dataRdvUser;
	}

	// Prendre un RDV USER
	public static void createRdvMedical(int idUser, String affichage) {

		MyLibraryOuf.afficher(affichage);

		String nomPatient;
		String prenomPatient;
		String dateRdv;
		String heureRdv;
		String specialiteMedical;
		String medecinSpecialiste;
		String gradeSpécialiste;

		nomPatient = OperationPersonOuf.users.get(idUser).getNomUser();

		prenomPatient = OperationPersonOuf.users.get(idUser).getPrenomUser();

		do { // Boucle pour ne pas laisser un champ vide.

			MyLibraryOuf.afficher("Veuillez à ne pas laisser un champ vide !");

			dateRdv = MyLibraryOuf.saisie("Saisir la Date de RDV\n" + "(format yyyy-mm-dd)");

			heureRdv = MyLibraryOuf.saisie("Saisir une Heure\n" + "(format hh:mm)");

			specialiteMedical = MyLibraryOuf.saisie(
					"Saisir la Spécialité..." + "\n(G : Généraliste" + "\n(O : Ophtalmologue" + "\n(D : Dermatologue")
					.toLowerCase();

		} while ((dateRdv.isEmpty()) || (heureRdv.isEmpty()) || (heureRdv.isEmpty()));

		if ((specialiteMedical.equals("g")) || (specialiteMedical.equals("généraliste"))
				|| (specialiteMedical.equals("generaliste"))) {

			specialiteMedical = "Généraliste";

			int idGeneraliste;

			Random random = new Random();
			int min = 0;
			int max = generalisteMedicals.size() - 1;

			idGeneraliste = random.nextInt((max - min) + 1) + min;

			medecinSpecialiste = generalisteMedicals.get(idGeneraliste).getMedecinSpecialiste();

			gradeSpécialiste = generalisteMedicals.get(idGeneraliste).getGradeSpécialiste();

			RdvMedicalOuf rdv = new RdvMedicalOuf(idUser, nomPatient, prenomPatient, dateRdv, heureRdv,
					specialiteMedical, medecinSpecialiste, gradeSpécialiste);

			rdvMedicals.add(rdv);

			if (OperationCarteOuf.getIndexByIndex(idUser) == -1) {
				MyLibraryOuf.afficher(
						" Carte inexistante !" + "\nVeuillez faire la demande carte auprès des Administrateurs");
			} else {

				OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(idUser),
						("Transaction Centre Médical : \n RDV : " + dateRdv + "    " + heureRdv + "\n"
								+ medecinSpecialiste + "\n" + specialiteMedical));

				MyLibraryOuf.afficher("Ajout reussi !\n\n" + "Identifiant : " + rdvMedicals.indexOf(rdv) + "\nNom : "
						+ rdv.getNomPatient() + "\nPrénom : " + rdv.getPrenomPatient() + "\nDate : " + rdv.getDateRdv()
						+ "\nHeure : " + rdv.getHeureRdv() + "\nSpécialité : " + rdv.getSpecialiteMedical()
						+ "\nMédecin : " + rdv.getMedecinSpecialiste()
						+ "\n\nRDV enregistré !\nNous serons ravi de vous recevoir.");

			}
		} else if ((specialiteMedical.equals("o")) || (specialiteMedical.equals("ophtalmologue"))
				|| (specialiteMedical.equals("ophtalmo"))) {

			specialiteMedical = "Ophtalmologue";

			int idOphtalmo;

			Random random = new Random();
			int min = 0;
			int max = ophtalmoMedicals.size() - 1;

			idOphtalmo = random.nextInt((max - min) + 1) + min;

			medecinSpecialiste = ophtalmoMedicals.get(idOphtalmo).getMedecinSpecialiste();
			gradeSpécialiste = ophtalmoMedicals.get(idOphtalmo).getGradeSpécialiste();

			RdvMedicalOuf rdv = new RdvMedicalOuf(idUser, nomPatient, prenomPatient, dateRdv, heureRdv,
					specialiteMedical, medecinSpecialiste, gradeSpécialiste);

			rdvMedicals.add(rdv);
			if (OperationCarteOuf.getIndexByIndex(idUser) == -1) {
				MyLibraryOuf.afficher(
						" Carte inexistante !" + "\nVeuillez faire la demande carte auprès des Administrateurs");
			} else {

				OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(idUser),
						("Transaction Centre Médical : \n RDV : " + dateRdv + "    " + heureRdv + "\n"
								+ medecinSpecialiste + "\n" + specialiteMedical));

				MyLibraryOuf.afficher("Ajout reussi !\n\n" + "Identifiant : " + rdvMedicals.indexOf(rdv) + "\nNom : "
						+ rdv.getNomPatient() + "\nPrénom : " + rdv.getPrenomPatient() + "\nDate : " + rdv.getDateRdv()
						+ "\nHeure : " + rdv.getHeureRdv() + "\nSpécialité : " + rdv.getSpecialiteMedical()
						+ "\nMédecin : " + rdv.getMedecinSpecialiste()
						+ "\n\nRDV enregistré !\nNous serons ravi de vous recevoir.");

			}

		} else if ((specialiteMedical.equals("d")) || (specialiteMedical.equals("dermatologue"))
				|| (specialiteMedical.equals("dermato"))) {

			specialiteMedical = "Dermatologue";

			int idDermato;

			Random random = new Random();
			int min = 0;
			int max = dermatoMedicals.size() - 1;

			idDermato = random.nextInt((max - min) + 1) + min;

			medecinSpecialiste = dermatoMedicals.get(idDermato).getMedecinSpecialiste();

			gradeSpécialiste = dermatoMedicals.get(idDermato).getGradeSpécialiste();

			RdvMedicalOuf rdv = new RdvMedicalOuf(idUser, nomPatient, prenomPatient, dateRdv, heureRdv,
					specialiteMedical, medecinSpecialiste, gradeSpécialiste);

			rdvMedicals.add(rdv);
			if (OperationCarteOuf.getIndexByIndex(idUser) == -1) {
				MyLibraryOuf.afficher(
						" Carte inexistante !" + "\nVeuillez faire la demande carte auprès des Administrateurs");
			} else {

				OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(idUser),
						("Transaction Centre Médical : \n RDV : " + dateRdv + "    " + heureRdv + "\n"
								+ medecinSpecialiste + "\n" + specialiteMedical));

				MyLibraryOuf.afficher("Ajout reussi !\n\n" + "Identifiant : " + rdvMedicals.indexOf(rdv) + "\nNom : "
						+ rdv.getNomPatient() + "\nPrénom : " + rdv.getPrenomPatient() + "\nDate : " + rdv.getDateRdv()
						+ "\nHeure : " + rdv.getHeureRdv() + "\nSpécialité : " + rdv.getSpecialiteMedical()
						+ "\nMédecin : " + rdv.getMedecinSpecialiste()
						+ "\n\nRDV enregistré !\nNous serons ravi de vous recevoir.");

			}

		}

		else {

			MyLibraryOuf.afficher("Nous n'avons pas cette Spécialité dans nos services"
					+ "\n Veuillez reprendre à nouveau le processus !");

		}

	}

	// Supprimer RDV USER
	public static void deletedRdvMedical(int idUser, String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idRdv = MyLibraryOuf.repeterInt(onlyRdvUser(idUser) + "\n\nSaisir l'identifiant du RDV");

		// Vérifiaction de l'identifiant
		while (idRdv > rdvMedicals.size() - 1) {

			idRdv = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du RDV");
		}

		String aux = MyLibraryOuf
				.saisie(rdvMedicals.get(idRdv).infoRdvMedicalUser() + "\n\nS'agit-il de ce produit ? (oui / non)");

		if (aux.equals("oui")) {

			rdvMedicals.remove(idRdv);

			if (OperationCarteOuf.getIndexByIndex(idUser) == -1) {
				MyLibraryOuf.afficher(
						" Carte inexistante !" + "\nVeuillez faire la demande carte auprès des Administrateurs");
			} else {

				// Ajoute la transaction à l'historique
				OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(idUser),
						"Transaction Centre Médical : \nRDV supprimé.");

				MyLibraryOuf.afficher("Suppression effectuée !");
			}
		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la suppression");
		}

	}

	// Enregistrer un nouveau medecin ADMIN
	public static void createSpecialisteMedical(String affichage) {

		MyLibraryOuf.afficher(affichage);

		String medecinSpecialiste; // nom et prenom du spécialiste
		String specialiteMedical;
		String gradeSpécialiste;

		do { // Boucle pour ne pas laisser un champ vide.

			MyLibraryOuf.afficher("Veuillez à ne pas laisser un champ vide !");

			medecinSpecialiste = MyLibraryOuf.saisie("Saisir le Nom et le Prenom du Praticien");

			specialiteMedical = MyLibraryOuf.saisie("Saisir la Spécialité du Praticien" + "\n(G : Généraliste"
					+ "\n(O : Ophtalmologue" + "\n(D : Dermatologue").toLowerCase();

			gradeSpécialiste = MyLibraryOuf.saisie("Saisir le Grade du Praticien");

		} while ((medecinSpecialiste.isEmpty()) || (specialiteMedical.isEmpty())

				|| (gradeSpécialiste.isEmpty()));

		if ((specialiteMedical.equals("g")) || (specialiteMedical.equals("généraliste"))
				|| (specialiteMedical.equals("generaliste"))) {

			RdvMedicalOuf praticienG = new RdvMedicalOuf(medecinSpecialiste, "Généraliste", gradeSpécialiste);

			generalisteMedicals.add(praticienG);

			MyLibraryOuf.afficher("Ajout réussi !\n" + praticienG.infoPraticienAdmin());
		} else if ((specialiteMedical.equals("o")) || (specialiteMedical.equals("ophtalmologue"))
				|| (specialiteMedical.equals("ophtalmo"))) {

			RdvMedicalOuf praticienO = new RdvMedicalOuf(medecinSpecialiste, "Ophtalmologue", gradeSpécialiste);

			ophtalmoMedicals.add(praticienO);

			MyLibraryOuf.afficher("Ajout réussi !\n" + praticienO.infoPraticienAdmin());

		} else if ((specialiteMedical.equals("d")) || (specialiteMedical.equals("dermatologue"))
				|| (specialiteMedical.equals("dermato"))) {

			RdvMedicalOuf praticienD = new RdvMedicalOuf(medecinSpecialiste, "Ophtalmologue", gradeSpécialiste);

			dermatoMedicals.add(praticienD);

			MyLibraryOuf.afficher("Ajout réussi !\n" + praticienD.infoPraticienAdmin());

		}

		else {

			MyLibraryOuf.afficher("Nous n'avons pas cette Spécialité dans nos services");

		}

	}

}
