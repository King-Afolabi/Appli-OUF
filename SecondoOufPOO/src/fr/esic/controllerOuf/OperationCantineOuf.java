package fr.esic.controllerOuf;

import java.util.ArrayList;
import java.util.List;

import fr.esic.modelOuf.MetsCantineOuf;
import fr.esic.modelOuf.PlatCantineOuf;

public class OperationCantineOuf {

	public static List<PlatCantineOuf> entrees = new ArrayList<>();

	public static List<PlatCantineOuf> platPrincipaux = new ArrayList<>();

	public static List<PlatCantineOuf> desserts = new ArrayList<>();

	public static List<MetsCantineOuf> menus = new ArrayList<>();

	
	
	
	public static void achatEntree(int indexPerson, String msg, String affichage) {

		MyLibraryOuf.afficher(affichage);

		Double prixEntree = 0.0;
		String dataEntree = "";
		int idEntree, nbreEntree;

		int mdp;
		int code;
		int i = 1;

		Double solde;

		if (OperationCarteOuf.getIndexByIndex(indexPerson) == -1) {
			MyLibraryOuf
					.afficher(" Carte inexistante !" + "\nVeuillez faire la demande carte auprès des Administrateurs");
		} else {

			mdp = OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getMdpCarte();
			solde = OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getSoldeCarte();

			// Vérifier si la carte n'est pas bloquée

			if (OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getStatutCarte()) {

				// Saisir code secret de la carte
				code = MyLibraryOuf.repeterInt("Saisir le Code secret de votre Carte");

				// Vérifiaction de code
				while ((code != mdp) && (i < 3)) {
					code = MyLibraryOuf
							.repeterInt("Code incorret !\n" + "Veuillez saisir à nouveau le Code secret de votre Carte"
									+ "(\"" + (3 - i) + " essai\")");
					i++;
				}

				if ((code == mdp) && (i <= 3)) { // SI le code est bon

					// Demander l'index de l'entrée
					idEntree = MyLibraryOuf.repeterInt(msg + "\nSaisir l'identifiant de l'Entrée...");

					// Vérifiaction de l'identifiant
					while (idEntree > entrees.size() - 1) {

						idEntree = MyLibraryOuf.repeterInt("Identifiant inexistant !\n" + msg
								+ "Veuillez saisir à nouveau l'identifiant de l'Entrée...");
					}

					// Demander le nombre d'entrée
					nbreEntree = MyLibraryOuf.repeterInt(msg + "\nSaisir le nombre d'Entrée...");

					// Vérifiaction du nombre
					while (nbreEntree > entrees.get(idEntree).getNombrePlat()) {

						nbreEntree = MyLibraryOuf.repeterInt("Nombre supérieur au total de plat disponoble  !\n" + msg
								+ "Veuillez saisir à nouveau le nombre d'Entrée...");
					}

					prixEntree = (entrees.get(idEntree).getPrixPlat()) * nbreEntree;

					if (solde >= prixEntree) {

						// enregistre la transaction
						dataEntree = entrees.get(idEntree).infoPlatCantineUser();

						// Modifie le prix sur la carte de l'users
						OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson))
								.setSoldeCarte(solde - prixEntree);

						MyLibraryOuf.afficher("Achat effectué avec success !\n" + "Merci !");

						// Ajoute la transaction à l'historique
						OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
								"Transaction Cantine : \n" + dataEntree + "\n Total : " + prixEntree);

					} else {
						MyLibraryOuf
								.afficher("Votre solde est insuffisant !\n" + "Désolé veuillez recharger votre Carte.");
						OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
								"Transaction Cantine : \nVotre solde est insuffisant !");
					}

				} else { // Si le code n'est pas bon

					MyLibraryOuf.afficher("Code incorret !\n" + "Carte bloquée après plusieurs tentatives !");

					// On bloque le code en changeant son statut
					OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson))
							.setStatutCarte(!OperationCarteOuf.cartes
									.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getStatutCarte());

					// Envoie un message de bloquage dans l'historique
					OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
							"Votre carte a été bloqué " + "\n\nNous avons détecté une activité irrégulière !");

				}

			} else {

				MyLibraryOuf.afficher("Votre Carte est bloquée\n" + "Veuillez SVP contacter un Admin");

			}

		}

	}

	public static void achatPlatPrincipal(int indexPerson, String msg, String affichage) {

		MyLibraryOuf.afficher(affichage);

		Double prixPlatPrincipal = 0.0;
		String dataPlatPrincipal = "";
		int idPlatPrincipal, nbrePlatPrincipal;

		int mdp;
		int code;
		int i = 1;

		Double solde;

		if (OperationCarteOuf.getIndexByIndex(indexPerson) == -1) {
			MyLibraryOuf
					.afficher(" Carte inexistante !" + "\nVeuillez faire la demande carte auprès des Administrateurs");
		} else {

			mdp = OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getMdpCarte();
			solde = OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getSoldeCarte();

			// Vérifier si la carte n'est pas bloquée

			if (OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getStatutCarte()) {

				// Saisir code secret de la carte
				code = MyLibraryOuf.repeterInt("Saisir le Code secret de votre Carte");

				// Vérifiaction de code
				while ((code != mdp) && (i < 3)) {
					code = MyLibraryOuf
							.repeterInt("Code incorret !\n" + "Veuillez saisir à nouveau le Code secret de votre Carte"
									+ "(\"" + (3 - i) + " essai\")");
					i++;
				}

				if ((code == mdp) && (i <= 3)) { // SI le code est bon

					// Demander l'index de l'entrée
					idPlatPrincipal = MyLibraryOuf.repeterInt(msg + "\nSaisir l'identifiant du Plat Principal...");

					// Vérifiaction de l'identifiant
					while (idPlatPrincipal > platPrincipaux.size() - 1) {

						idPlatPrincipal = MyLibraryOuf.repeterInt("Identifiant inexistant !\n" + msg
								+ "Veuillez saisir à nouveau l'identifiant du Plat Principal...");
					}

					// Demander le nombre d'entrée
					nbrePlatPrincipal = MyLibraryOuf.repeterInt(msg + "\nSaisir le nombre de Plat Principal...");

					// Vérifiaction du nombre
					while (nbrePlatPrincipal > platPrincipaux.get(idPlatPrincipal).getNombrePlat()) {

						nbrePlatPrincipal = MyLibraryOuf.repeterInt("Nombre supérieur au total de plat disponoble  !\n"
								+ msg + "Veuillez saisir à nouveau le nombre de Plat Principal...");
					}

					prixPlatPrincipal = (platPrincipaux.get(idPlatPrincipal).getPrixPlat()) * nbrePlatPrincipal;

					if (solde >= prixPlatPrincipal) {

						// enregistre la transaction
						dataPlatPrincipal = platPrincipaux.get(idPlatPrincipal).infoPlatCantineUser();

						// Modifie le prix sur la carte de l'users
						OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson))
								.setSoldeCarte(solde - prixPlatPrincipal);

						MyLibraryOuf.afficher("Achat effectué avec success !\n" + "Merci !");

						// Ajoute la transaction à l'historique
						OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
								"Transaction Cantine : \n" + dataPlatPrincipal + "\n Total : " + prixPlatPrincipal);

					} else {
						MyLibraryOuf
								.afficher("Votre solde est insuffisant !\n" + "Désolé veuillez recharger votre Carte.");
						OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
								"Transaction Cantine : \nVotre solde est insuffisant !");
					}

				} else { // Si le code n'est pas bon

					MyLibraryOuf.afficher("Code incorret !\n" + "Carte bloquée après plusieurs tentatives !");

					// On bloque le code en changeant son statut
					OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson))
							.setStatutCarte(!OperationCarteOuf.cartes
									.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getStatutCarte());

					// Envoie un message de bloquage dans l'historique
					OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
							"Votre carte a été bloqué " + "\n\nNous avons détecté une activité irrégulière !");

				}

			} else {

				MyLibraryOuf.afficher("Votre Carte est bloquée\n" + "Veuillez SVP contacter un Admin");
			}
		}

	}

	public static void achatDessert(int indexPerson, String msg, String affichage) {

		MyLibraryOuf.afficher(affichage);

		Double prixDessert = 0.0;
		String dataDessert = "";
		int idPlatDessert, nbreDessert;

		int mdp;
		int code;
		int i = 1;

		Double solde;

		mdp = OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getMdpCarte();
		solde = OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getSoldeCarte();

		// Vérifier si la carte n'est pas bloquée

		if (OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getStatutCarte()) {

			// Saisir code secret de la carte
			code = MyLibraryOuf.repeterInt("Saisir le Code secret de votre Carte");

			// Vérifiaction de code
			while ((code != mdp) && (i < 3)) {
				code = MyLibraryOuf.repeterInt("Code incorret !\n"
						+ "Veuillez saisir à nouveau le Code secret de votre Carte" + "(\"" + (3 - i) + " essai\")");
				i++;
			}

			if ((code == mdp) && (i <= 3)) { // SI le code est bon

				// Demander l'index de l'entrée
				idPlatDessert = MyLibraryOuf.repeterInt(msg + "\nSaisir l'identifiant du Dessert...");

				// Vérifiaction de l'identifiant
				while (idPlatDessert > desserts.size() - 1) {

					idPlatDessert = MyLibraryOuf.repeterInt("Identifiant inexistant !\n" + msg
							+ "Veuillez saisir à nouveau l'identifiant du Dessert...");
				}

				// Demander le nombre d'entrée
				nbreDessert = MyLibraryOuf.repeterInt(msg + "\nSaisir le nombre de Dessert...");

				// Vérifiaction du nombre
				while (nbreDessert > desserts.get(idPlatDessert).getNombrePlat()) {

					nbreDessert = MyLibraryOuf.repeterInt("Nombre supérieur au total de plat disponoble  !\n" + msg
							+ "Veuillez saisir à nouveau le nombre de Dessert...");
				}

				prixDessert = (desserts.get(idPlatDessert).getPrixPlat()) * nbreDessert;

				if (solde >= prixDessert) {

					// enregistre la transaction
					dataDessert = desserts.get(idPlatDessert).infoPlatCantineUser();

					// Modifie le prix sur la carte de l'users
					OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson))
							.setSoldeCarte(solde - prixDessert);

					MyLibraryOuf.afficher("Achat effectué avec success !\n" + "Merci !");

					// Ajoute la transaction à l'historique
					OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
							"Transaction Cantine : \n" + dataDessert + "\n Total : " + prixDessert);

				} else {
					MyLibraryOuf.afficher("Votre solde est insuffisant !\n" + "Désolé veuillez recharger votre Carte.");
					OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
							"Transaction Cantine : \nVotre solde est insuffisant !");
				}

			} else { // Si le code n'est pas bon

				MyLibraryOuf.afficher("Code incorret !\n" + "Carte bloquée après plusieurs tentatives !");

				// On bloque le code en changeant son statut
				OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson)).setStatutCarte(
						!OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getStatutCarte());

				// Envoie un message de bloquage dans l'historique
				OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
						"Votre carte a été bloqué " + "\n\nNous avons détecté une activité irrégulière !");

			}

		} else {

			MyLibraryOuf.afficher("Votre Carte est bloquée\n" + "Veuillez SVP contacter un Admin");

		}

	}

	public static void achatMenu(int indexPerson, String msg, String affichage) {

		MyLibraryOuf.afficher(affichage);

		Double prixMenu = 0.0;
		String dataMenu = "";
		int idPlatMenu, nbreMenu;

		int mdp;
		int code;
		int i = 1;

		Double solde;

		if (OperationCarteOuf.getIndexByIndex(indexPerson) == -1) {
			MyLibraryOuf
					.afficher(" Carte inexistante !" + "\nVeuillez faire la demande carte auprès des Administrateurs");
		} else {

			mdp = OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getMdpCarte();
			solde = OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getSoldeCarte();

			// Vérifier si la carte n'est pas bloquée

			if (OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getStatutCarte()) {

				// Saisir code secret de la carte
				code = MyLibraryOuf.repeterInt("Saisir le Code secret de votre Carte");

				// Vérifiaction de code
				while ((code != mdp) && (i < 3)) {
					code = MyLibraryOuf
							.repeterInt("Code incorret !\n" + "Veuillez saisir à nouveau le Code secret de votre Carte"
									+ "(\"" + (3 - i) + " essai\")");
					i++;
				}

				if ((code == mdp) && (i <= 3)) { // SI le code est bon

					// Demander l'index de l'entrée
					idPlatMenu = MyLibraryOuf.repeterInt(msg + "\nSaisir l'identifiant du Menu...");

					// Vérifiaction de l'identifiant
					while (idPlatMenu > menus.size() - 1) {

						idPlatMenu = MyLibraryOuf.repeterInt("Identifiant inexistant !\n" + msg
								+ "Veuillez saisir à nouveau l'identifiant du Menu...");
					}

					// Demander le nombre d'entrée
					nbreMenu = MyLibraryOuf.repeterInt(msg + "\nSaisir le nombre de Menu...");

					prixMenu = (menus.get(idPlatMenu).getPrixMenu()) * nbreMenu;

					if (solde >= prixMenu) {

						// enregistre la transaction
						dataMenu = menus.get(idPlatMenu).infoMenuUser();

						// Modifie le prix sur la carte de l'users
						OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson))
								.setSoldeCarte(solde - prixMenu);

						MyLibraryOuf.afficher("Achat effectué avec success !\n" + "Merci !");

						// Ajoute la transaction à l'historique
						OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
								"Transaction Cantine : \n" + dataMenu + "\n Total : " + prixMenu);

					} else {
						MyLibraryOuf
								.afficher("Votre solde est insuffisant !\n" + "Désolé veuillez recharger votre Carte.");
						OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
								"Transaction Cantine : \nVotre solde est insuffisant !");
					}

				} else { // Si le code n'est pas bon

					MyLibraryOuf.afficher("Code incorret !\n" + "Carte bloquée après plusieurs tentatives !");

					// On bloque le code en changeant son statut
					OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson))
							.setStatutCarte(!OperationCarteOuf.cartes
									.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getStatutCarte());

					// Envoie un message de bloquage dans l'historique
					OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
							"Votre carte a été bloqué " + "\n\nNous avons détecté une activité irrégulière !");

				}

			} else {

				MyLibraryOuf.afficher("Votre Carte est bloquée\n" + "Veuillez SVP contacter un Admin");

			}
		}
	}

	// Afficher toutes les entrées
	public static void allEntree(String affichage) { // ADMIN

		MyLibraryOuf.afficher(affichage);
		String dataEntree = "";

		for (PlatCantineOuf entree : entrees) {
			dataEntree += entrees.indexOf(entree) + "- " + entree.infoPlatCantineAdmin() + "\n";
		}

		MyLibraryOuf.afficher(dataEntree);
	}

	public static String allEntreeUser() { // USER

		String dataEntree = "";

		for (PlatCantineOuf entree : entrees) {
			dataEntree += entrees.indexOf(entree) + " - " + entree.infoPlatCantineUser() + "\n";
		}

		return dataEntree;
	}

	// Afficher tous les plats principaux
	public static void allPlatPrincipal(String affichage) { // ADMIN

		MyLibraryOuf.afficher(affichage);
		String dataPlatPrincipal = "";

		for (PlatCantineOuf platPrincipal : platPrincipaux) {
			dataPlatPrincipal += platPrincipaux.indexOf(platPrincipal) + "- " + platPrincipal.infoPlatCantineAdmin()
					+ "\n";
		}

		MyLibraryOuf.afficher(dataPlatPrincipal);
	}

	public static String allPlatPrincipalUser() { // USER

		String dataPlatPrincipal = "";

		for (PlatCantineOuf platPrincipal : platPrincipaux) {
			dataPlatPrincipal += platPrincipaux.indexOf(platPrincipal) + " - " + platPrincipal.infoPlatCantineUser()
					+ "\n";
		}

		return dataPlatPrincipal;
	}

	// Afficher tous les Desserts
	public static void allDessert(String affichage) { // ADMIN

		MyLibraryOuf.afficher(affichage);
		String dataDessert = "";

		for (PlatCantineOuf dessert : desserts) {
			dataDessert += desserts.indexOf(dessert) + "- " + dessert.infoPlatCantineAdmin() + "\n";
		}

		MyLibraryOuf.afficher(dataDessert);
	}

	public static String allDessertUser() { // USER

		String dataDessert = "";

		for (PlatCantineOuf dessert : desserts) {
			dataDessert += desserts.indexOf(dessert) + " - " + dessert.infoPlatCantineUser() + "\n";
		}

		return dataDessert;
	}

	// Afficher les menus
	public static void allMenu(String affichage) { // ADMIN

		MyLibraryOuf.afficher(affichage);

		String dataMenu = "";

		for (MetsCantineOuf menu : menus) {
			dataMenu += menus.indexOf(menu) + "- Menu" + menu.infoMenuAdmin() + "\n";
		}

		MyLibraryOuf.afficher(dataMenu);

	}

	public static String allMenuUser() { // USER

		String dataMenu = "";

		for (MetsCantineOuf menu : menus) {
			dataMenu += menus.indexOf(menu) + " - Menu" + menu.infoMenuUser() + "\n\n";
		}

		return dataMenu;

	}

	// Création de plat
	public static void createPlatCantine(String affichage) { // ADMIN

		MyLibraryOuf.afficher(affichage);

		String nomPlat;
		String categoriePlat;
		String descriptionPlat;
		Double prixPlat;
		int nombrePlat;
		Boolean disponiblePlat;

		do { // Boucle pour ne pas laisser un champ vide.

			MyLibraryOuf.afficher("Veuillez à ne pas laisser un champ vide !");

			nomPlat = MyLibraryOuf.saisie("Saisir le nom du plat");

			categoriePlat = MyLibraryOuf.saisie("Saisir la catégorie du plat").toLowerCase();

			descriptionPlat = MyLibraryOuf.saisie("Saisir une descrption du plat");

			prixPlat = MyLibraryOuf.repeterDouble("Saisir le prix du plat");

			nombrePlat = MyLibraryOuf.repeterInt("Saisir le nombre de plat");

			disponiblePlat = MyLibraryOuf.saisieBoolean("Mettre le plat au Menu ? (true / false)");

		} while ((nomPlat.isEmpty()) || (categoriePlat.isEmpty())

				|| (descriptionPlat.isEmpty()) || (descriptionPlat.isEmpty()));

		PlatCantineOuf platCantine = new PlatCantineOuf(nomPlat, categoriePlat, descriptionPlat, prixPlat, nombrePlat,
				disponiblePlat);

		if ((categoriePlat == "entrée") || (categoriePlat == "entree")) {

			entrees.add(platCantine);

			MyLibraryOuf.afficher("Ajout reussi !\n\n" + "Identifiant : " + entrees.indexOf(platCantine) + "\nNom : "
					+ platCantine.getNomPlat() + "\nPrix : " + platCantine.getPrixPlat() + " €\nCatégorie : "
					+ platCantine.getCategoriePlat() + "\nDescription : " + platCantine.getDescriptionPlat()
					+ "\nNombre : " + platCantine.getNombrePlat() + "\nDisponibilité : "
					+ platCantine.getDisponiblePlat());

		}

		else if ((categoriePlat == "dessert") || (categoriePlat == "déssert")) {

			desserts.add(platCantine);

			MyLibraryOuf.afficher("Ajout reussi !\n\n" + "Identifiant : " + desserts.indexOf(platCantine) + "\nNom : "
					+ platCantine.getNomPlat() + "\nPrix : " + platCantine.getPrixPlat() + " €\nCatégorie : "
					+ platCantine.getCategoriePlat() + "\nDescription : " + platCantine.getDescriptionPlat()
					+ "\nNombre : " + platCantine.getNombrePlat() + "\nDisponibilité : "
					+ platCantine.getDisponiblePlat());

		}

		else {
			platPrincipaux.add(platCantine);

			MyLibraryOuf.afficher("Ajout reussi !\n\n" + "Identifiant : " + platPrincipaux.indexOf(platCantine)
					+ "\nNom : " + platCantine.getNomPlat() + "\nPrix : " + platCantine.getPrixPlat()
					+ " €\nCatégorie : " + platCantine.getCategoriePlat() + "\nDescription : "
					+ platCantine.getDescriptionPlat() + "\nNombre : " + platCantine.getNombrePlat()
					+ "\nDisponibilité : " + platCantine.getDisponiblePlat());
		}
	}

	// Création d'un Menu
	public static void createMenuCantine(String affichage) {

		MyLibraryOuf.afficher(affichage); // ADMIN

		int idEntree, idPlatPrincipal, idDessert;

		Double prixMenu;

		do { // Boucle pour ne pas laisser un champ vide.

			MyLibraryOuf.afficher("Veuillez à ne pas laisser un champ vide !");

			idEntree = MyLibraryOuf.saisieInt("Saisir l'identifiant de l'Entrée du Menu");

			idPlatPrincipal = MyLibraryOuf.saisieInt("Saisir l'identifiant du Plat principal du Menu");

			idDessert = MyLibraryOuf.saisieInt("Saisir l'identifiant du Dessert du Menu");

		} while ((idEntree > entrees.size() - 1) || (idDessert > desserts.size() - 1)

				|| (idPlatPrincipal > platPrincipaux.size() - 1));

		prixMenu = entrees.get(idEntree).getPrixPlat() + platPrincipaux.get(idPlatPrincipal).getPrixPlat()
				+ desserts.get(idDessert).getPrixPlat();

		MetsCantineOuf menuCantine = new MetsCantineOuf(entrees.get(idEntree), platPrincipaux.get(idPlatPrincipal),
				desserts.get(idDessert), prixMenu);

		menus.add(menuCantine);

		MyLibraryOuf.afficher("Ajout reussi !\n\n" + "Identifiant : " + menus.indexOf(menuCantine) + "\n"
				+ menuCantine.infoMenuAdmin());

	}

	// Mettre à jour le nombre d'entrée admin
	public static void miseAjourNombreEntree(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idEntree = MyLibraryOuf.repeterInt("Saisir l'identifiant de l'Entrée");

		// Vérifiaction de l'identifiant
		while (idEntree > entrees.size() - 1) {

			idEntree = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant de l'Entrée");
		}

		int quantiteInitial = entrees.get(idEntree).getNombrePlat();
		int quantite;

		String aux = MyLibraryOuf
				.saisie(entrees.get(idEntree).infoPlatCantineAdmin() + "\n\nS'agit-il de cet Entrée ? (oui / non)");

		if (aux.equals("oui")) {

			quantite = MyLibraryOuf.repeterInt("Combien souhaitez-vous y ajouter ?");

			entrees.get(idEntree).setNombrePlat((quantite + quantiteInitial));

			MyLibraryOuf.afficher(entrees.get(idEntree).infoPlatCantineAdmin() + "\n\nMise à jour réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise à jour !");
		}
	}

	// Mettre à jour le nombre de dessert admin
	public static void miseAjourNombreDessert(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idDessert = MyLibraryOuf.repeterInt("Saisir l'identifiant du Dessert");

		// Vérifiaction de l'identifiant
		while (idDessert > desserts.size() - 1) {

			idDessert = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du Dessert");
		}

		int quantiteInitial = desserts.get(idDessert).getNombrePlat();
		int quantite;

		String aux = MyLibraryOuf
				.saisie(desserts.get(idDessert).infoPlatCantineAdmin() + "\n\nS'agit-il de ce Dessert ? (oui / non)");

		if (aux.equals("oui")) {

			quantite = MyLibraryOuf.repeterInt("Combien souhaitez-vous y ajouter ?");

			desserts.get(idDessert).setNombrePlat((quantite + quantiteInitial));

			MyLibraryOuf.afficher(desserts.get(idDessert).infoPlatCantineAdmin() + "\n\nMise à jour réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise à jour !");
		}
	}

	// Mettre à jour le nombre de plat principal admin
	public static void miseAjourNombrePlatPrincipal(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idPlatPrincipal = MyLibraryOuf.repeterInt("Saisir l'identifiant du Plat principal");

		// Vérifiaction de l'identifiant
		while (idPlatPrincipal > platPrincipaux.size() - 1) {

			idPlatPrincipal = MyLibraryOuf.repeterInt(
					"Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du Plat principal");
		}

		int quantiteInitial = platPrincipaux.get(idPlatPrincipal).getNombrePlat();
		int quantite;

		String aux = MyLibraryOuf.saisie(platPrincipaux.get(idPlatPrincipal).infoPlatCantineAdmin()
				+ "\n\nS'agit-il de ce Plat principal ? (oui / non)");

		if (aux.equals("oui")) {

			quantite = MyLibraryOuf.repeterInt("Combien souhaitez-vous y ajouter ?");

			platPrincipaux.get(idPlatPrincipal).setNombrePlat((quantite + quantiteInitial));

			MyLibraryOuf
					.afficher(platPrincipaux.get(idPlatPrincipal).infoPlatCantineAdmin() + "\n\nMise à jour réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise à jour !");
		}
	}

	// Mettre à jour le prix de l'Entrée
	public static void miseAjourPrixEntree(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idEntree = MyLibraryOuf.repeterInt("Saisir l'identifiant de l'Entrée");

		// Vérifiaction de l'identifiant
		while (idEntree > entrees.size() - 1) {

			idEntree = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant de l'Entrée");
		}

		Double prix;

		String aux = MyLibraryOuf
				.saisie(entrees.get(idEntree).infoPlatCantineAdmin() + "\n\nS'agit-il de cet Entrée ? (oui / non)");

		if (aux.equals("oui")) {

			prix = MyLibraryOuf.repeterDouble("Saisir le nouveau prix !");

			entrees.get(idEntree).setPrixPlat(prix);

			MyLibraryOuf.afficher(entrees.get(idEntree).infoPlatCantineAdmin() + "\n\nMise à jour réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise à jour du prix !");
		}
	}

	// Mettre à jour le prix du Dessert
	public static void miseAjourPrixDessert(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idDessert = MyLibraryOuf.repeterInt("Saisir l'identifiant du Dessert");

		// Vérifiaction de l'identifiant
		while (idDessert > desserts.size() - 1) {

			idDessert = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du Dessert");
		}

		Double prix;

		String aux = MyLibraryOuf
				.saisie(desserts.get(idDessert).infoPlatCantineAdmin() + "\n\nS'agit-il de ce Dessert ? (oui / non)");

		if (aux.equals("oui")) {

			prix = MyLibraryOuf.repeterDouble("Saisir le nouveau prix !");

			desserts.get(idDessert).setPrixPlat(prix);

			MyLibraryOuf.afficher(desserts.get(idDessert).infoPlatCantineAdmin() + "\n\nMise à jour réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise à jour du prix !");
		}
	}

	// Mettre à jour le prix du plat principal
	public static void miseAjourPrixPlatPrincipal(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idPlatPrincipal = MyLibraryOuf.repeterInt("Saisir l'identifiant du Plat principal");

		// Vérifiaction de l'identifiant
		while (idPlatPrincipal > platPrincipaux.size() - 1) {

			idPlatPrincipal = MyLibraryOuf.repeterInt(
					"Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du Plat principal");
		}

		Double prix;

		String aux = MyLibraryOuf.saisie(platPrincipaux.get(idPlatPrincipal).infoPlatCantineAdmin()
				+ "\n\nS'agit-il de ce plat principal ? (oui / non)");

		if (aux.equals("oui")) {

			prix = MyLibraryOuf.repeterDouble("Saisir le nouveau prix !");

			platPrincipaux.get(idPlatPrincipal).setPrixPlat(prix);

			MyLibraryOuf
					.afficher(platPrincipaux.get(idPlatPrincipal).infoPlatCantineAdmin() + "\n\nMise à jour réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise à jour du prix !");
		}
	}

	// Mettre à jour Menu
	public static void miseAjourMenu(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idMenu = MyLibraryOuf.repeterInt("Saisir l'identifiant du Menu");

		// Vérifiaction de l'identifiant
		while (idMenu > menus.size() - 1) {

			idMenu = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du Menu");
		}

		String categorieMenu = MyLibraryOuf
				.saisie(menus.get(idMenu).infoMenuAdmin() + "Saisir la catégorie du plat que vous souhaitez modifier")
				.toLowerCase();

		if ((categorieMenu.equals("entrée")) || (categorieMenu.equals("entree"))) {

			int idEntreeNew = MyLibraryOuf.repeterInt("Saisir l'identifiant de la NOUVELLE Entrée");

			// Vérifiaction de l'identifiant
			while (idEntreeNew > entrees.size() - 1) {

				idEntreeNew = MyLibraryOuf.repeterInt(
						"Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant de la NOUVELLE Entrée");
			}

			MyLibraryOuf.afficher("NOUVELLE Entrée \n\n" + "Identifiant : " + idEntreeNew + "\n"
					+ entrees.get(idEntreeNew).infoPlatCantineAdmin());

			menus.get(idMenu).setEntree(entrees.get(idEntreeNew));
			MyLibraryOuf.afficher("Mise à jour reussie !");
		}

		else if ((categorieMenu.equals("plat principal")) || (categorieMenu.equals("plat principale"))) {

			int idPlatPrincipalNew = MyLibraryOuf.repeterInt("Saisir l'identifiant du NOUVEAU Plat principal");

			// Vérifiaction de l'identifiant
			while (idPlatPrincipalNew > entrees.size() - 1) {

				idPlatPrincipalNew = MyLibraryOuf.repeterInt("Identifiant inexistant !\n"
						+ "Veuillez saisir à nouveau l'identifiant du NOUVEAU Plat principal");
			}

			MyLibraryOuf.afficher("NOUVEAU Plat principal \n\n" + "Identifiant : " + idPlatPrincipalNew + "\n"
					+ platPrincipaux.get(idPlatPrincipalNew).infoPlatCantineAdmin());

			menus.get(idMenu).setEntree(entrees.get(idPlatPrincipalNew));
			MyLibraryOuf.afficher("Mise à jour reussie !");

		}

		else if ((categorieMenu.equals("dessert")) || (categorieMenu.equals("déssert"))) {

			int idDessertNew = MyLibraryOuf.repeterInt("Saisir l'identifiant du NOUVEAU Dessert");

			// Vérifiaction de l'identifiant
			while (idDessertNew > entrees.size() - 1) {

				idDessertNew = MyLibraryOuf.repeterInt(
						"Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du NOUVEAU Dessert");
			}

			MyLibraryOuf.afficher("NOUVEAU Dessert \n\n" + "Identifiant : " + idDessertNew + "\n"
					+ desserts.get(idDessertNew).infoPlatCantineAdmin());

			menus.get(idMenu).setEntree(entrees.get(idDessertNew));
			MyLibraryOuf.afficher("Mise à jour reussie !");

		}

		else {
			MyLibraryOuf.afficher("Aucune catégorie ne correspond à votre saisie"
					+ "\nVeuillez SVP reprendre la mise à jour du Menu !");
		}

	}

	// Activer et désactiver Entrée
	public static void dispoIndispoEntree(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idEntree = MyLibraryOuf.repeterInt("Saisir l'identifiant de l'Entrée");

		// Vérifiaction de l'identifiant
		while (idEntree > entrees.size() - 1) {

			idEntree = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant de l'Entrée");
		}

		String aux = MyLibraryOuf
				.saisie(entrees.get(idEntree).infoPlatCantineAdmin() + "\n\nS'agit-il de cet Entrée ? (oui / non)");

		if (aux.equals("oui")) {

			entrees.get(idEntree).setDisponiblePlat(!entrees.get(idEntree).getDisponiblePlat());

			MyLibraryOuf.afficher(entrees.get(idEntree).infoPlatCantineAdmin() + "\n\nMise à jour réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise en disponibilité ou non du Mets");
		}

	}

	// Activer et désactiver Dessert
	public static void dispoIndispoDessert(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idDessert = MyLibraryOuf.repeterInt("Saisir l'identifiant du Dessert");

		// Vérifiaction de l'identifiant
		while (idDessert > desserts.size() - 1) {

			idDessert = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du Dessert");
		}

		String aux = MyLibraryOuf
				.saisie(desserts.get(idDessert).infoPlatCantineAdmin() + "\n\nS'agit-il de ce Dessert ? (oui / non)");

		if (aux.equals("oui")) {

			desserts.get(idDessert).setDisponiblePlat(!desserts.get(idDessert).getDisponiblePlat());

			MyLibraryOuf.afficher(desserts.get(idDessert).infoPlatCantineAdmin() + "\n\nMise à jour réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise en disponibilité ou non du Mets");
		}

	}

	// Activer et désactiver Plat principal
	public static void dispoIndispoPlatPrincipal(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idPlatPrincipal = MyLibraryOuf.repeterInt("Saisir l'identifiant du Plat principal");

		// Vérifiaction de l'identifiant
		while (idPlatPrincipal > platPrincipaux.size() - 1) {

			idPlatPrincipal = MyLibraryOuf.repeterInt(
					"Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du Plat principal");
		}

		String aux = MyLibraryOuf.saisie(platPrincipaux.get(idPlatPrincipal).infoPlatCantineAdmin()
				+ "\n\nS'agit-il de ce Plat principal ? (oui / non)");

		if (aux.equals("oui")) {

			platPrincipaux.get(idPlatPrincipal)
					.setDisponiblePlat(!platPrincipaux.get(idPlatPrincipal).getDisponiblePlat());

			MyLibraryOuf
					.afficher(platPrincipaux.get(idPlatPrincipal).infoPlatCantineAdmin() + "\n\nMise à jour réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise en disponibilité ou non du Mets");
		}

	}

	// Supprimer Entrée
	public static void deletedEntree(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idEntree = MyLibraryOuf.repeterInt("Saisir l'identifiant de l'Entrée");

		// Vérifiaction de l'identifiant
		while (idEntree > entrees.size() - 1) {

			idEntree = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant de l'Entrée");
		}

		String aux = MyLibraryOuf
				.saisie(entrees.get(idEntree).infoPlatCantineAdmin() + "\n\nS'agit-il de cet Entrée ? (oui / non)");

		if (aux.equals("oui")) {

			entrees.remove(idEntree);

			MyLibraryOuf.afficher("Suppression réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la suppression");
		}

	}

	// Supprimer Dessert
	public static void deletedDessert(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idDessert = MyLibraryOuf.repeterInt("Saisir l'identifiant du Dessert");

		// Vérifiaction de l'identifiant
		while (idDessert > desserts.size() - 1) {

			idDessert = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du Dessert");
		}

		String aux = MyLibraryOuf
				.saisie(desserts.get(idDessert).infoPlatCantineAdmin() + "\n\nS'agit-il de ce Dessert ? (oui / non)");

		if (aux.equals("oui")) {

			desserts.remove(idDessert);

			MyLibraryOuf.afficher("Suppression réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la suppression");
		}

	}

	// Supprimer Plat principal
	public static void deletedPlatPrincipal(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idPlatPrincipal = MyLibraryOuf.repeterInt("Saisir l'identifiant du Plat principal");

		// Vérifiaction de l'identifiant
		while (idPlatPrincipal > platPrincipaux.size() - 1) {

			idPlatPrincipal = MyLibraryOuf.repeterInt(
					"Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du Plat principal");
		}

		String aux = MyLibraryOuf.saisie(platPrincipaux.get(idPlatPrincipal).infoPlatCantineAdmin()
				+ "\n\nS'agit-il de ce Plat principal ? (oui / non)");

		if (aux.equals("oui")) {

			platPrincipaux.remove(idPlatPrincipal);

			MyLibraryOuf.afficher("Suppression réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la suppression");
		}

	}

	// Supprimer Menu
	public static void deletedMenu(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idMenu = MyLibraryOuf.repeterInt("Saisir l'identifiant du Menu");

		// Vérifiaction de l'identifiant
		while (idMenu > menus.size() - 1) {

			idMenu = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du Menu");
		}

		String aux = MyLibraryOuf.saisie(menus.get(idMenu).infoMenuAdmin() + "\n\nS'agit-il de ce Menu ? (oui / non)");

		if (aux.equals("oui")) {

			menus.remove(idMenu);

			MyLibraryOuf.afficher("Suppression réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la suppression");
		}

	}

}
