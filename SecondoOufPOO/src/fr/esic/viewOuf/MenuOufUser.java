package fr.esic.viewOuf;

import fr.esic.controllerOuf.MyLibraryOuf;
import fr.esic.controllerOuf.OperationCantineOuf;
import fr.esic.controllerOuf.OperationCarteOuf;
import fr.esic.controllerOuf.OperationCentreMedicalOuf;
import fr.esic.controllerOuf.OperationMarketOuf;

public class MenuOufUser {

	public static void menuUser(int indexPerson) {

		Boolean sortie = false;
		Boolean sortieCentre;
		Boolean sortieCantine;
		Boolean sortieCentreMedical;
		Boolean sortieGestionCarte;

		while (!sortie) {
			
			
			switch (MyLibraryOuf.repeterInt("         Application OUF " + 
							"\n\nBienvenue dans le Menu"
							
					+ "\n1- Mini Centre Commercial"
					+ "\n2- Cantine"
					+ "\n3- Centre médical"
					+ "\n4- Gestionnaire de Carte"
					
					+ "\n\n\n0- Quitter la section")) {
			
			
			
			
			case 1: // ------- Mini Centre Commercial" 
				
				Boolean sortiePanier;
				sortieCentre = false;
				
				
				while(!sortieCentre) {
					
					switch (MyLibraryOuf.repeterInt("         Application OUF "
		
							+ "\nMini Centre Commercial\n" 
							+ "\n1- Sélectionner des articles"
							+ "\n2- Mon panier" 
							
							+ "\n\n\n0- Précédent")) {
					
					case 1:
					
						OperationMarketOuf.ajoutProduitPanier(indexPerson, OperationMarketOuf.allProduitUser()
								,"         Application OUF "
										+ "\nMini Centre Commercial"
										+ "\n\nSelectionner des articles");
							
						break;
						
					case 2:
						
						sortiePanier = false ;
						while (!sortiePanier){
							
							
							switch (MyLibraryOuf.repeterInt("         Application OUF "
									+ "	\nMini Centre Commercial \nPANIER\n\n"
									+ "\n1- Afficher le panier" 
									+ "\n2- Acheter tous le panier"
									+ "\n3- Acheter un seul article"
									+ "\n4- Rétirer un article du panier"
									
									
									+ "\n\n\n0- Précédent")) {
							
							case 1:
								MyLibraryOuf.afficher("         Application OUF " 
										+ "\nMini Centre Commercial \nPANIER"
										+ "\n\nAfficher le panier\n"
										+ OperationMarketOuf.allProduitPanier(indexPerson));
																
								break;
							
							case 2:
								
								OperationMarketOuf.achatProduitsPanier(indexPerson
										,"         Application OUF "
												+ "\nMini Centre Commercial \nPANIER"
												+ "\n\nAcheter tous le panier");
								
								
								break;
								
								
							case 3:
								
								OperationMarketOuf.achatProduitPanier(indexPerson, OperationMarketOuf.allProduitPanier(indexPerson)
										, "         Application OUF " 
												+ "\nMini Centre Commercial \nPANIER"
												+ "\n\nAcheter un seul article");
								
								break;
								
								
							case 4:
								
								OperationMarketOuf.deletedProduitPanier(indexPerson
										, "         Application OUF " 
												+ "\nMini Centre Commercial \nPANIER"
												+ "\n\nRétirer un article du panier");
								
								break;
								
								
							case 0:
								
								sortiePanier = true;
								
								break;
			
							default:
								MyLibraryOuf.afficher("Quelque chose a mal tourné");
								break;
							
							}	
							
						}
						
						break;
		
						
					case 0:
						
						MyLibraryOuf.afficher("6 \nSortie Centre "
								+ sortieCentre
								);
						
						sortieCentre = true;
						break;
	
					default:
						MyLibraryOuf.afficher("Quelque chose a mal tourné");
						break;
					}
					
					
					
				}
				
				break;

			case 2: // ------- Cantine
				
				
				// Boolean sortiePlat;
				sortieCantine = false;
				
				while(!sortieCantine) {
					
					switch (MyLibraryOuf.repeterInt("         Application OUF "
							
							+ "\nCantine\n"
							+ "\n1- Entrées"
							+ "\n2- Plats Principaux"
							+ "\n3- Desserts" 
							+ "\n4- Menus"
							
							+ "\n\n\n0- Précédent")) {
					
					
					
					case 1: // Entrée User
						
						OperationCantineOuf.achatEntree(indexPerson, OperationCantineOuf.allEntreeUser()
								,"         Application OUF "
										+ "\nCantine"
										+ "\n\nEntrées");
						
						break;
					
					
					case 2: // Plat principal User
						
						OperationCantineOuf.achatPlatPrincipal(indexPerson, OperationCantineOuf.allPlatPrincipalUser()
								, "         Application OUF "
										+ "\nCantine"
										+ "\n\nPlats Principaux");
						//
						
						break;
						
					case 3: //  Dessert User
						
						OperationCantineOuf.achatDessert(indexPerson, OperationCantineOuf.allDessertUser()
								, "         Application OUF "
										+ "\nCantine"
										+ "\n\nDesserts");
						//
						
						break;
						
					case 4: // Menu User
						
						OperationCantineOuf.achatMenu(indexPerson, OperationCantineOuf.allMenuUser()
								, "         Application OUF "
										+ "\nCantine"
										+ "\n\nMenus");
						
						
						break;
						
					case 0:
						
						sortieCantine = true;
						break;
	
					default:
						break;
					}
				}
				
				
				break;
				
			case 3:// centre médical
				
				// Boolean sortiePraticien;
				
				sortieCentreMedical = false;
				
				while(!sortieCentreMedical) {
					
					switch (MyLibraryOuf.repeterInt("         Application OUF " 
		
							+ "\nCentre Médical\n" 
							+ "\n1- Prendre un RDV"
							+ "\n2- Afficher RDV" 
							+ "\n3- Supprimer RDV"
							
							
							+ "\n\n\n0- Précédent")) {
					
					case 1:
						// Pour un RDV on demande Spécialité puis (la date et l'heure), 
						// Pour date et heure on peut mettre des proposition.
						// Ou on ajoute un compteur puis on arrete 
						
						OperationCentreMedicalOuf.createRdvMedical(indexPerson
								, "         Application OUF " 
										+ "\nCentre Médical"
										+ "\n\nPrendre un RDV");
						break;
						
					case 2:
						MyLibraryOuf.afficher("         Application OUF " 
								+ "\nCentre Médical"
								+ "\n\nAfficher RDV\n\n"
								+ OperationCentreMedicalOuf.onlyRdvUser(indexPerson));
						break;
						
					case 3:
						OperationCentreMedicalOuf.deletedRdvMedical(indexPerson
								, "         Application OUF " 
										+ "\nCentre Médical"
										+ "\n\nSupprimer RDV");
						// 
						
						break;
							
						
					case 0:
						
						sortieCentreMedical = true;
						break;
	
					default:
						MyLibraryOuf.afficher("Quelque chose a mal tourné");
						break;
					}
				}
				
				
				
				break;

			case 4: // Gestionnaire de carte
				
				sortieGestionCarte = false;
				
				while(!sortieGestionCarte) {
					
					switch (MyLibraryOuf.repeterInt("         Application OUF "
		
							+ "\nGestionnaire Carte\n" 
							+ "\n1- Afficher le Solde"
							+ "\n2- Afficher Historique" 
							+ "\n3- Demande de rechargement"
							+ "\n4- Transférer de l'argent"
							
							
							+ "\n\n\n0- Précédent")) {
					
					case 1:
						MyLibraryOuf.afficher("         Application OUF " 
								+ "\nGestionnaire Carte"
								+ "\n\nAfficher le Solde"
								+ "\n" + OperationCarteOuf.allSoldeCartesUser(indexPerson));
		
						
						break;
						
					case 2:
						
						OperationCarteOuf.allHistoriqueCarteUser(indexPerson
								, "         Application OUF " 
										+ "\nGestionnaire Carte"
										+ "\n\nAfficher Historique");
						
						break;
						
					case 3:
						
						OperationCarteOuf.demandeRechargeCarteUser(indexPerson
								, "         Application OUF " 
										+ "\nGestionnaire Carte" 
										+ "\n\nDemande de rechargement");
						// 
						
						break;
						
					case 4:
						OperationCarteOuf.transfertArgentCarte(indexPerson
								, "         Application OUF " 
										+ "\nGestionnaire Carte" 
										+ "\n\nTransférer de l'argent");
						//
						
						break;
						
						
					case 0:
						
						sortieGestionCarte = true;
						break;
	
					default:
						MyLibraryOuf.afficher("Quelque chose a mal tourné");
						break;
					}
				}
				
				
				
				break;
			
				
			case 0:
				
				MyLibraryOuf.afficher("         Application OUF " + 
						 "\nA très bientôt Oufseur");
				sortie = true;
				break;
			
			default:
				
				break;
			}
			
		}
	
			
	}
	
	

}
