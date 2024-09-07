package fr.esic.controllerOuf;

import java.util.ArrayList;
import java.util.List;

import fr.esic.modelOuf.ProduitMarketOuf;

public class OperationMarketOuf {

	// création d'une liste de produit
	public static List<ProduitMarketOuf> produits = new ArrayList<>();

	public static List<ProduitMarketOuf> panierProduits = new ArrayList<>();

// --------------------------------------------------------------------------------------- Panier
	// Afficher les produits du panier

	public static String allProduitPanier(int indexPerson) {

		String dataProduitPanier = "";

		for (ProduitMarketOuf produit : panierProduits) {

			if (indexPerson == produit.getIndexPersonPanier()) {

				dataProduitPanier += panierProduits.indexOf(produit) + " - " + produit.infoProduitPanier() + "\n\n";
			}
		}

		return dataProduitPanier;
	}

	// Ajout de produit au panier

	public static void ajoutProduitPanier(int indexPerson, String msg, String affichage) {

		MyLibraryOuf.afficher(affichage + "\n" + allProduitPanier(indexPerson));

		String nomProduit;
		Double prixProduit;
		String categorieProduit;
		int promoProduit;
		int nombreProduitPanier;

		Double totalProduitPanier;

		int idProduit = MyLibraryOuf.repeterInt(msg + "\nSaisir l'identifiant du produit à ajouter...");

		// Vérifiaction de l'identifiant
		while (idProduit > produits.size() - 1) {

			idProduit = MyLibraryOuf.repeterInt(
					"Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du produit à ajouter...");
		}

		int nbre = MyLibraryOuf.repeterInt("Saisir la quantité...");

		// Vérifiaction de l'identifiant
		while ((nbre > produits.get(idProduit).getQuantiteProduit()) && (nbre != 0)) {

			nbre = MyLibraryOuf.repeterInt("Quantité supérieur au stock ou égale à 0 !\n"
					+ "Veuillez ressaisir une quantité dans la limite des stock");
		}

		nomProduit = produits.get(idProduit).getNomProduit();
		prixProduit = produits.get(idProduit).getPrixProduit();
		categorieProduit = produits.get(idProduit).getCategorieProduit();
		promoProduit = produits.get(idProduit).getPromoProduit();
		nombreProduitPanier = nbre;

		totalProduitPanier = ((prixProduit - (prixProduit * (promoProduit / 100))) * nombreProduitPanier);

		ProduitMarketOuf produitPanier = new ProduitMarketOuf(indexPerson, nomProduit, prixProduit, categorieProduit,
				promoProduit, nombreProduitPanier, totalProduitPanier);

		panierProduits.add(produitPanier);

		MyLibraryOuf.afficher("Ajout au panier réussi !" + "\n" + produitPanier.infoProduitPanier());

	}

	// Payer tous les produits du panier

	public static void achatProduitsPanier(int indexPerson, String affichage) {

		MyLibraryOuf.afficher(affichage + "\n" + allProduitPanier(indexPerson));

		Double sommeProduitPanier = 0.0;
		String dataProduitPanier = "";

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

			// Constituer la somme total du panier
			for (ProduitMarketOuf produit : panierProduits) {

				if (indexPerson == produit.getIndexPersonPanier()) {

					sommeProduitPanier += produit.getTotalProduitPanier();

					dataProduitPanier += produit.infoProduitPanier();
				}
			}

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

					if (solde >= sommeProduitPanier) {

						OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson))
								.setSoldeCarte(solde - sommeProduitPanier);

						MyLibraryOuf.afficher("Achat effectué avec success !\n" + "Merci !");
						OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
								"Transaction Mini Market : \n" + dataProduitPanier + "\n Total : "
										+ sommeProduitPanier);

						// Vider le panier après achat
						for (ProduitMarketOuf produit : panierProduits) {

							if (indexPerson == produit.getIndexPersonPanier()) { // produit.getIndexPersonPanier filtre
																					// dans le panier tous ceux qui ont
																					// l'ndex de l'user

								panierProduits.remove(produit);

							}
						}

					} else {
						MyLibraryOuf
								.afficher("Votre solde est insuffisant !\n" + "Désolé veuillez recharger votre Carte.");
						OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
								"Transaction Mini Market : \nVotre solde est insuffisant !");
					}

				} else { // Si le code n'est pas bon

					MyLibraryOuf.afficher("Code incorret !\n" + "Carte bloquée après plusieurs tentatives !");

					// On bloque le code en changeant son statut
					OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson))
							.setStatutCarte(!OperationCarteOuf.cartes
									.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getStatutCarte());

					// Envoie un message de bloquage dans l'historique
					OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
							"Votre carte a été bloqué");

				}

			} else {

				MyLibraryOuf.afficher("Votre Carte est bloquée\n" + "Veuillez SVP contacter un Admin");

			}
		}
	}

	// PAyer un seul produit du panier
	public static void achatProduitPanier(int indexPerson, String msg, String affichage) {

		MyLibraryOuf.afficher(affichage);
		Double prixProduitPanier = 0.0;
		String dataProduitPanier = "";
		int idProduitPanier;

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

					// Demander l'index du produit dans le panier
					idProduitPanier = MyLibraryOuf
							.repeterInt(msg + "\nSaisir l'identifiant de l'article dans le panier...");

					// Vérifiaction de l'identifiant
					while (idProduitPanier > panierProduits.size() - 1) {

						idProduitPanier = MyLibraryOuf.repeterInt("Identifiant inexistant !\n" + msg
								+ "Veuillez saisir à nouveau l'identifiant de l'article dans le panier...");
					}

					Double prixProduit = panierProduits.get(idProduitPanier).getPrixProduit();
					int promoProduit = panierProduits.get(idProduitPanier).getPromoProduit();
					int nombreProduitPanier = panierProduits.get(idProduitPanier).getNombreProduitPanier();

					prixProduitPanier = (prixProduit - (prixProduit * (promoProduit / 100))) * nombreProduitPanier;

					if (solde >= prixProduitPanier) {

						// enregistre la transaction
						dataProduitPanier = panierProduits.get(idProduitPanier).infoProduitPanier();

						// Modifie le prix sur la carte de l'users
						OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson))
								.setSoldeCarte(solde - prixProduitPanier);

						MyLibraryOuf.afficher("Achat effectué avec success !\n" + "Merci !");

						// Ajoute la transaction à l'historique
						OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
								"Transaction Mini Market : \n" + dataProduitPanier + "\n Total : " + prixProduitPanier);

						// Vider le panier après achat
						for (ProduitMarketOuf produit : panierProduits) {

							if (indexPerson == produit.getIndexPersonPanier()) { // produit.getIndexPersonPanier filtre
																					// dans
																					// le panier tous ceux qui ont
																					// l'ndex de
																					// l'user

								panierProduits.remove(produit);

							}
						}

					} else {
						MyLibraryOuf
								.afficher("Votre solde est insuffisant !\n" + "Désolé veuillez recharger votre Carte.");
						OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
								"Transaction Mini Market : \nVotre solde est insuffisant !");
					}

				} else { // Si le code n'est pas bon

					MyLibraryOuf.afficher("Code incorret !\n" + "Carte bloquée après plusieurs tentatives !");

					// On bloque le code en changeant son statut
					OperationCarteOuf.cartes.get(OperationCarteOuf.getIndexByIndex(indexPerson))
							.setStatutCarte(!OperationCarteOuf.cartes
									.get(OperationCarteOuf.getIndexByIndex(indexPerson)).getStatutCarte());

					// Envoie un message de bloquage dans l'historique
					OperationCarteOuf.ajoutHistoriqueCarte(OperationCarteOuf.getIndexByIndex(indexPerson),
							"Votre carte a été bloqué");

				}

			} else {

				MyLibraryOuf.afficher("Votre Carte est bloquée\n" + "Veuillez SVP contacter un Admin");

			}
		}
	}

	public static void deletedProduitPanier(int indexPerson, String affichage) {

		MyLibraryOuf.afficher(affichage + "\n" + allProduitPanier(indexPerson));

		int idProduitPanier = MyLibraryOuf
				.repeterInt(allProduitPanier(indexPerson) + "\n\nSaisir le numéro de l'article");

		// Vérifiaction de l'identifiant
		while (idProduitPanier > panierProduits.size() - 1) {

			idProduitPanier = MyLibraryOuf
					.repeterInt("Numéro inexistant !\n" + "Veuillez saisir à nouveau le numéro de l'article");
		}

		String aux = MyLibraryOuf.saisie(
				panierProduits.get(idProduitPanier).infoProduitPanier() + "\n\nS'agit-il de ce produit ? (oui / non)");

		if (aux.equals("oui")) {

			panierProduits.remove(idProduitPanier);

			MyLibraryOuf.afficher("Suppression effectuée !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la suppression");
		}

	}

// ------------------------------------------------------------------------------------FIN PANIER

	// Affichage des produits pour les Admins et les Utilisateurs

	public static void allProduitAdmin(String affichage) { // ADMIN

		String dataProduitAdmin = "";

		for (ProduitMarketOuf produit : produits) {
			dataProduitAdmin += produits.indexOf(produit) + "- " + produit.infoProduitAdmin() + "\n";
		}

		MyLibraryOuf.afficher(affichage + dataProduitAdmin);
	}

	public static String allProduitUser() {// USER

		String dataProduitUser = "";

		for (ProduitMarketOuf produit : produits) {

			if (produit.getActiveProduit()) {

				dataProduitUser += produits.indexOf(produit) + "- " + produit.infoProduitUser() + "\n";
			}
		}

		return dataProduitUser;
	}

	// Ajouter des produits par les admins

	public static void createProduit(String affichage) {

		MyLibraryOuf.afficher(affichage);

		String nomProduit;
		Double prixProduit;
		String categorieProduit;
		String descriptionProduit;
		int quantiteProduit;
		String dlcProduit;
		int promoProduit;
		String fournisseurProduit;
		Boolean activeProduit;

		do { // Boucle pour ne pas laisser un champ vide.

			MyLibraryOuf.afficher("Veuillez à ne pas laisser un champ vide !");

			nomProduit = MyLibraryOuf.saisie("Saisir le nom du produit");

			prixProduit = MyLibraryOuf.repeterDouble("Saisir le prix du produit");

			categorieProduit = MyLibraryOuf.saisie("Saisir la catégorie du produit").trim();

			descriptionProduit = MyLibraryOuf.saisie("Saisir la description du produit");

			quantiteProduit = MyLibraryOuf.repeterInt("Saisir la quantité du produit");

			dlcProduit = MyLibraryOuf.saisie("Saisir la date limite de consommation du produit (dd/mm/yyyy)");

			promoProduit = MyLibraryOuf.repeterInt("Saisir le pourcentage de reduction du produit");

			fournisseurProduit = MyLibraryOuf.saisie("Saisir le fournisseur du produit");

			activeProduit = MyLibraryOuf.saisieBoolean("Activer le produit ? (true / false)");

		} while ((nomProduit.isEmpty()) || (prixProduit.isNaN()) || (categorieProduit.isEmpty())
				|| (descriptionProduit.isEmpty()) || (dlcProduit.isEmpty()) || (fournisseurProduit.isEmpty()));

		ProduitMarketOuf produit = new ProduitMarketOuf(nomProduit, prixProduit, categorieProduit, descriptionProduit,
				quantiteProduit, dlcProduit, promoProduit, fournisseurProduit, activeProduit);

		produits.add(produit);

		MyLibraryOuf.afficher("Ajout reussi !\n\n" + "Identifiant : " + produits.indexOf(produit) + "\nNom : "
				+ produit.getNomProduit() + "\nPrix : " + produit.getPrixProduit() + " €\nCatégorie : "
				+ produit.getCategorieProduit() + "\nDescription : " + produit.getDescriptionProduit() + "\nQuantité : "
				+ produit.getQuantiteProduit() + "\nDate limite conso : " + produit.getDlcProduit() + "\nPromo : "
				+ produit.getPromoProduit() + " %\nFournisseur : " + produit.getFournisseurProduit() + "\nActif : "
				+ produit.getActiveProduit());

	}

	// Mettre à jour le stock admin
	public static void miseAjourStock(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idProduit = MyLibraryOuf.repeterInt("Saisir l'identifiant du produit");

		// Vérifiaction de l'identifiant
		while (idProduit > produits.size() - 1) {

			idProduit = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du produit");
		}

		int quantiteInitial = produits.get(idProduit).getQuantiteProduit();
		int quantite;

		String aux = MyLibraryOuf
				.saisie(produits.get(idProduit).infoProduitAdmin() + "\n\nS'agit-il de ce produit ? (oui / non)");

		if (aux.equals("oui")) {

			quantite = MyLibraryOuf.repeterInt("Combien souhaitez-vous y ajouter ?");

			produits.get(idProduit).setQuantiteProduit(quantite + quantiteInitial);

			MyLibraryOuf.afficher(produits.get(idProduit).infoProduitAdmin() + "\n\nMise à jour réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise à jour du stock !");
		}
	}

	// Mettre à jour le prix admin

	public static void miseAjourPrix(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idProduit = MyLibraryOuf.repeterInt("Saisir l'identifiant du produit");

		// Vérifiaction de l'identifiant
		while (idProduit > produits.size() - 1) {

			idProduit = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du produit");
		}

		Double prix;

		String aux = MyLibraryOuf
				.saisie(produits.get(idProduit).infoProduitAdmin() + "\n\nS'agit-il de ce produit ? (oui / non)");

		if (aux.equals("oui")) {

			prix = MyLibraryOuf.repeterDouble("Saisir le nouveau prix !");

			produits.get(idProduit).setPrixProduit(prix);

			MyLibraryOuf.afficher(produits.get(idProduit).infoProduitAdmin() + "\n\nMise à jour réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise à jour du prix !");
		}
	}

	// Mettre à jour la réduction admin

	public static void miseAjourPromo(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idProduit = MyLibraryOuf.repeterInt("Saisir l'identifiant du produit");

		// Vérifiaction de l'identifiant
		while (idProduit > produits.size() - 1) {

			idProduit = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du produit");
		}

		int promo;

		String aux = MyLibraryOuf
				.saisie(produits.get(idProduit).infoProduitAdmin() + "\n\nS'agit-il de ce produit ? (oui / non)");

		if (aux.equals("oui")) {

			promo = MyLibraryOuf.repeterInt("Saisir la nouvelle réduction en % !");

			produits.get(idProduit).setPromoProduit(promo);

			MyLibraryOuf.afficher(produits.get(idProduit).infoProduitAdmin() + "\n\nMise à jour réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la mise à jour de la promo !");
		}
	}

	// Activer ou désactiver un produit

	public static void activeDesactive(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idProduit = MyLibraryOuf.repeterInt("Saisir l'identifiant du produit");

		// Vérifiaction de l'identifiant
		while (idProduit > produits.size() - 1) {

			idProduit = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du produit");
		}

		String aux = MyLibraryOuf
				.saisie(produits.get(idProduit).infoProduitAdmin() + "\n\nS'agit-il de ce produit ? (oui / non)");

		if (aux.equals("oui")) {

			produits.get(idProduit).setActiveProduit(!produits.get(idProduit).getActiveProduit());

			MyLibraryOuf.afficher(produits.get(idProduit).infoProduitAdmin() + "\n\nMise à jour réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre l'activation ou la désactivation");
		}

	}

	// Supprimer un produit

	public static void deleted(String affichage) {

		MyLibraryOuf.afficher(affichage);

		int idProduit = MyLibraryOuf.repeterInt("Saisir l'identifiant du produit");

		// Vérifiaction de l'identifiant
		while (idProduit > produits.size() - 1) {

			idProduit = MyLibraryOuf
					.repeterInt("Identifiant inexistant !\n" + "Veuillez saisir à nouveau l'identifiant du produit");
		}

		String aux = MyLibraryOuf
				.saisie(produits.get(idProduit).infoProduitAdmin() + "\n\nS'agit-il de ce produit ? (oui / non)");

		if (aux.equals("oui")) {

			produits.remove(idProduit);

			MyLibraryOuf.afficher("Suppression réussie !");

		} else {
			MyLibraryOuf.afficher("Veuillez reprendre la suppression");
		}

	}

}
