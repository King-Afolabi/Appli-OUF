package fr.esic.controllerOuf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.esic.modelOuf.CarteOuf;

public class OperationCarteOuf {

	// liste Carte de crédit
	public static List<CarteOuf> cartes = new ArrayList<>();

	public static List<CarteOuf> notificationCarte = new ArrayList<>();

	// sortir l'index d'une carte grâce à l'identifiant de l'utilisateur
	public static int getIndexByIndex(int indexUser) {

		for (int i = 0; i < cartes.size(); i++) {
			if (cartes.get(i).getIndexPerson() == indexUser) {
				return i; // Retourne l'index si l'index user correspond
			}
		}
		return -1; // Retourne -1 si l'email n'est pas trouvé dans la liste
	}

	// Afficher toutes les cartes ----ADMIN
	public static void allCartesAdmin(String affichage) {

		MyLibraryOuf.afficher(affichage);
		String dataCarteAdmin = "";

		for (CarteOuf carte : cartes) {
			dataCarteAdmin += cartes.indexOf(carte) + "- " + carte.infoCarteAdmin() + "\n\n";

		}
		MyLibraryOuf.afficher(dataCarteAdmin);
	}

	public static String allNotificationCartesAdmin() {
		String dataNotifCarteAdmin = "";

		for (CarteOuf notif : notificationCarte) {
			dataNotifCarteAdmin += notificationCarte.indexOf(notif) + "- " + notif.infoNotification() + "\n\n";

		}
		return dataNotifCarteAdmin;
	}

	// Afficher toutes les infos d'une cartes USER
	public static String allInfoCartesUser(int indexUser) {

		if (getIndexByIndex(indexUser) == -1) {
			return "Carte inexistante !" + "\nVeuillez faire la demande carte auprès des Administrateurs";
		}

		int idUserCarte = getIndexByIndex(indexUser);

		return cartes.get(idUserCarte).infoCarteUser();
	}

	// Afficher solde d'une cartes USER
	public static String allSoldeCartesUser(int indexUser) {

		if (getIndexByIndex(indexUser) == -1) {
			return "Carte inexistante !" + "\nVeuillez faire la demande carte auprès des Administrateurs";
		}

		int idUserCarte = getIndexByIndex(indexUser);

		return cartes.get(idUserCarte).infoSoldeUser();
	}

	// ADMIN
	// Création d'une carte ------ADMIN
	public static void createCarte(String affichage) {

		MyLibraryOuf.afficher(affichage);

		String nomCarte;
		String prenomCarte;
		int mdpCarte;
		String categorieCarte;
		Double soldeCarte;
		String validiteCarte;
		Boolean statutCarte;

		Random random = new Random();
		int min = 1011;
		int max = 9999;

		int idUser = MyLibraryOuf.repeterInt("Saisir l'identifiant de l'utilisateur");

		// Vérifiaction de l'identifiant
		while (idUser > OperationPersonOuf.users.size() - 1) {

			idUser = MyLibraryOuf.repeterInt(
					"Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant de l'utilisateur");
		}

		nomCarte = OperationPersonOuf.users.get(idUser).getNomUser();

		prenomCarte = OperationPersonOuf.users.get(idUser).getPrenomUser();

		mdpCarte = random.nextInt((max - min) + 1) + min;

		soldeCarte = 10.0; // Crédit initial de 10 euros

		statutCarte = true;

		do {
			MyLibraryOuf.afficher("Veuillez à ne pas laisser de champs vide !");

			categorieCarte = MyLibraryOuf.saisie("Saisir la catégorie de la carte");

			validiteCarte = MyLibraryOuf.saisie("Saisir la validité de la carte");

		} while ((categorieCarte.isEmpty()) || (validiteCarte.isEmpty()));

		CarteOuf carte = new CarteOuf(idUser, nomCarte, prenomCarte, mdpCarte, categorieCarte, soldeCarte,
				validiteCarte, statutCarte, "Bienvenue " + nomCarte + " " + prenomCarte,
				"- Votre carte a été approvisionné de 10 €");

		cartes.add(carte);

		MyLibraryOuf.afficher("Ajout reussi !\n\n" + "Identifiant : " + cartes.indexOf(carte) + "\nNom : "
				+ carte.getNomCarte() + "\nPrénom : " + carte.getPrenomCarte() + "\nMot de Passe : "
				+ carte.getMdpCarte() + "\nCatégorie : " + carte.getCategorieCarte() + "\nSolde : "
				+ carte.getSoldeCarte() + " €" + "\nValidité : " + carte.getValiditeCarte() + "\nStatut : "
				+ carte.getStatutCarte() + "\nNotification : " + carte.getNotificationCarte() + "\nHistorique : "
				+ carte.getHistoriqueCarte());
	}

	// ADMIN ET USER
	// Ajout d'historique USER
	public static void ajoutHistoriqueCarte(int indexCarte, String histo) {

		String histoInitial = cartes.get(indexCarte).getHistoriqueCarte();

		cartes.get(indexCarte).setHistoriqueCarte("- " + histo + "\n" + histoInitial);
		MyLibraryOuf.afficher("Nouveau Message dans historique...");
	}

	// ADMIN
	// Afficher l'historique d'une carte USER et ADMIN
	public static void allHistoriqueCarte(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idCarte = MyLibraryOuf.repeterInt("Saisir l'identifiant de la Carte");

		// Vérifiaction de l'identifiant
		while (idCarte > cartes.size() - 1) {

			idCarte = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant de la Carte");
		}

		String aux = MyLibraryOuf
				.saisie(cartes.get(idCarte).infoCarteAdmin() + "\n\nS'agit-il de cette Carte ? (oui / non)");

		if (aux.equals("oui")) {

			MyLibraryOuf.afficher("Historique de la Carte \n" + "(De la plus recente à la plus ancienne) \n\n"
					+ cartes.get(idCarte).getHistoriqueCarte());

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise à jour !");
		}

	}

	// USER
	public static void allHistoriqueCarteUser(int indexUser, String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idCarte = getIndexByIndex(indexUser);

		if (idCarte != -1) {

			MyLibraryOuf.afficher("Historique de la Carte \n" + "(De la plus recente à la plus ancienne) \n\n"
					+ cartes.get(idCarte).getHistoriqueCarte());

		} else {
			MyLibraryOuf
					.afficher(" Carte inexistante !" + "\nVeuillez faire la demande carte auprès des Administrateurs");
		}

	}

	// ADMIN
	// Bloquer ou Débloquer une carte
	public static void bloqueDebloqueCarte(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idCarte = MyLibraryOuf.repeterInt("Saisir l'identifiant de la Carte");

		// Vérifiaction de l'identifiant
		while (idCarte > cartes.size() - 1) {

			idCarte = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant de la Carte");
		}

		String aux = MyLibraryOuf
				.saisie(cartes.get(idCarte).infoCarteAdmin() + "\n\nS'agit-il de cette Carte ? (oui / non)");

		if (aux.equals("oui")) {

			cartes.get(idCarte).setStatutCarte(!cartes.get(idCarte).getStatutCarte());

			MyLibraryOuf.afficher(cartes.get(idCarte).infoCarteAdmin() + "\n\nMise à jour réussie !");

			if (cartes.get(idCarte).getStatutCarte()) {
				ajoutHistoriqueCarte(idCarte, "Votre carte a été débloqué");
			} else {
				ajoutHistoriqueCarte(idCarte, "Votre carte a été bloqué");
			}

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise à jour !");
		}

	}

	// ADMIN
	// Recharger une carte
	public static void rechargerCarte(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idCarte = MyLibraryOuf.repeterInt("Saisir l'identifiant de la Carte");

		// Vérifiaction de l'identifiant
		while (idCarte > cartes.size() - 1) {

			idCarte = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant de la Carte");
		}

		String aux = MyLibraryOuf
				.saisie(cartes.get(idCarte).infoCarteAdmin() + "\n\nS'agit-il de cette Carte ? (oui / non)");

		Double soldeInitial = cartes.get(idCarte).getSoldeCarte();
		Double recharge;

		if (aux.equals("oui")) {

			recharge = MyLibraryOuf.repeterDouble("Combien souhaitez-vous recharger ?");

			cartes.get(idCarte).setSoldeCarte((recharge + soldeInitial));

			MyLibraryOuf.afficher(cartes.get(idCarte).infoCarteAdmin() + "\n\nMise à jour réussie !");

			ajoutHistoriqueCarte(idCarte, "Votre carte a été approvisionné de " + recharge + " €" + " | Solde : "
					+ recharge + soldeInitial + " €");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise à jour !");
		}
	}

	// USER
	public static void transfertArgentCarte(int indexUser, String affichage) {

		MyLibraryOuf.afficher(affichage);

		int indexPersonTransfertCarte;
		Double montantTransfert;

		String email = MyLibraryOuf.saisie("Saisir l'adresse mail du bénéficiare...");

		indexPersonTransfertCarte = OperationPersonOuf.getIndexByEmailUser(OperationPersonOuf.users, email);

		if (indexPersonTransfertCarte != -1) {

			montantTransfert = MyLibraryOuf.saisieDouble("Saisir le montant à transférer");

			int mdp;
			int code;
			int i = 1;

			Double solde;

			if (getIndexByIndex(indexUser) == -1) {
				MyLibraryOuf.afficher(
						" Carte inexistante !" + "\nVeuillez faire la demande carte auprès des Administrateurs");
			} else {

				mdp = OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexUser)).getMdpCarte();
				solde = OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexUser)).getSoldeCarte();

				// Vérifier si la carte n'est pas bloquée

				if (OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexUser)).getStatutCarte()) {

					// Saisir code secret de la carte
					code = MyLibraryOuf.repeterInt("Saisir le Code secret de votre Carte");

					// Vérifiaction de code
					while ((code != mdp) && (i < 3)) {
						code = MyLibraryOuf.repeterInt(
								"Code incorret !\n" + "Veuillez saisir à nouveau le Code secret de votre Carte" + "(\""
										+ (3 - i) + " essai\")");
						i++;
					}

					if ((code == mdp) && (i <= 3)) { // SI le code est bon

						if (solde >= montantTransfert) {

							// Modifie le prix sur la carte de l'users
							OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexUser))
									.setSoldeCarte(solde - montantTransfert);

							MyLibraryOuf.afficher("Transfert effectué avec success !\n" + "Merci !");

							// Ajoute la transaction à l'historique
							OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexUser),
									"Transaction Gestionnaire de Carte : \n Vous avez transféré : " + montantTransfert
											+ " €" + "\nVers : "
											+ OperationPersonOuf.users.get(indexPersonTransfertCarte).getNomUser() + " "
											+ OperationPersonOuf.users.get(indexPersonTransfertCarte).getPrenomUser()
											+ "\n Votre Solde : " + (solde - montantTransfert));

						} else {
							MyLibraryOuf.afficher(
									"Votre solde est insuffisant !\n" + "Désolé veuillez recharger votre Carte.");
							OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexUser),
									"Transaction Gestionnaire de Carte : \nVotre solde est insuffisant !");
						}

					} else { // Si le code n'est pas bon

						MyLibraryOuf.afficher("Code incorret !\n" + "Carte bloquée après plusieurs tentatives !");

						// On bloque le code en changeant son statut
						OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexUser))
								.setStatutCarte(!OperationCarteOuf.cartes
										.get(OperationCarteOuf.getIndexByIndex(indexUser)).getStatutCarte());

						// Envoie un message de bloquage dans l'historique
						OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexUser),
								"Votre carte a été bloqué");

					}

				} else {

					MyLibraryOuf.afficher("Votre Carte est bloquée\n" + "Veuillez SVP contacter un Admin");

				}

			}

		} else {
			MyLibraryOuf.afficher("Adresse mail inexistant !");

		}

	}

	// USER
	public static void demandeRechargeCarteUser(int indexUser, String affichage) {

		MyLibraryOuf.afficher(affichage);

		
		if (getIndexByIndex(indexUser) == -1) {
			MyLibraryOuf
					.afficher(" Carte inexistante !" + "\nVeuillez faire la demande carte auprès des Administrateurs");
		} else {

			int idCarteDemandeurRecharge = OperationCarteOuf.getIndexByIndex(indexUser);

			String demandeRecharge = "Identifiant Carte : " + idCarteDemandeurRecharge + "\nNotification : - "
					+ MyLibraryOuf.saisie("Saisir la Demande...");

			CarteOuf notifCarteUser = new CarteOuf(indexUser, demandeRecharge);

			notificationCarte.add(notifCarteUser);

			cartes.get(idCarteDemandeurRecharge).setNotificationCarte(demandeRecharge);
			;

			MyLibraryOuf.afficher(
					"Notification envoyée !\n\n" + "Identifiant : " + notificationCarte.indexOf(notifCarteUser)
							+ "\nNotification : " + cartes.get(idCarteDemandeurRecharge).getNotificationCarte());
		}
	}
}
