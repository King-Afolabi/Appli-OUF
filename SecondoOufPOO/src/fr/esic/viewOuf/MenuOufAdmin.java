package fr.esic.viewOuf;

import fr.esic.controllerOuf.MyLibraryOuf;
import fr.esic.controllerOuf.OperationCantineOuf;
import fr.esic.controllerOuf.OperationCarteOuf;
import fr.esic.controllerOuf.OperationCentreMedicalOuf;
import fr.esic.controllerOuf.OperationMarketOuf;
import fr.esic.controllerOuf.OperationPersonOuf;

public class MenuOufAdmin {

	public static void menuAdmin(int indexPerson) {

		Boolean sortie = false;
		Boolean sortieCentre;
		Boolean sortieCantine;
		Boolean sortieCentreMedical;
		Boolean sortieGestionCarte;

		while (!sortie) {
			
			
			switch (MyLibraryOuf.repeterInt("         Application OUF " + 
							"\n\nBienvenue dans le Menu Administrateur"
							
					+ "\n1- Mini Centre Commercial"
					+ "\n2- Cantine"
					+ "\n3- Centre médical"
					+ "\n4- Gestionnaire de Carte"
					+ "\n5- Données"
					
					+ "\n\n\n0- Quitter la section administrateur")) {
			
			
			
			
			case 1: // ------- Mini Centre Commercial" 
				sortieCentre = false;
				
				while(!sortieCentre) {
					
					switch (MyLibraryOuf.repeterInt("         Application OUF " + 
							"\n            Administrateur"
		
							+ "\nMini Centre Commercial\n" 
							+ "\n1- Afficher la liste des produits"
							+ "\n2- Ajouter un nouveau produit" 
							+ "\n3- Mise à jour du stock boutique"
							+ "\n4- Mise à jour du prix"
							+ "\n5- Mise à jour de la réduction"
							+ "\n6- Activer / Désactiver un produit"
							+ "\n7- Supprimer un produit"
							// Mise à jour de la réduction
							
							+ "\n\n\n0- Précédent")) {
					
					case 1:
						
						OperationMarketOuf.allProduitAdmin(
								"         Application OUF " + 
										"\n          Administrateur"
										+ "\nMini Centre Commercial"
										+ "\n\nAfficher la liste des produits");
						
						break;
						
					case 2:
						
						OperationMarketOuf.createProduit(
								"         Application OUF " + 
										"\n          Administrateur"
										+ "\nMini Centre Commercial"
										+ "\n\nAjouter un nouveau produit");
						
						break;
						
					case 3:
						
						OperationMarketOuf.miseAjourStock(
								"         Application OUF " + 
										"\n          Administrateur"
										+ "\nMini Centre Commercial" 
										+ "\n\nMise à jour du stock boutique");
						
						break;
						
					case 4:
						
						OperationMarketOuf.miseAjourPrix(
								"         Application OUF " + 
										"\n          Administrateur"
										+ "\nMini Centre Commercial" 
										+ "\n\nMise à jour du prix");
						
						break;
						
					case 5:
						
						OperationMarketOuf.miseAjourPromo(
								"         Application OUF " + 
										"\n           Administrateur"
										+ "\nMini Centre Commercial" 
										+ "\n\nMise à jour de la réduction");
						
						break;
						
						
					case 6:
						
						OperationMarketOuf.activeDesactive(
								"         Application OUF " + 
										"\n           Administrateur"
										+ "\nMini Centre Commercial"
										+ "\n\nActiver / Désactiver un produit");
						
						break;
						
					case 7:
						
						OperationMarketOuf.deleted(
								"         Application OUF " + 
										"\n            Administrateur"
										+ "\nMini Centre Commercial"
										+ "\n\nRétirer un produit");
						
						break;
						
					case 0:
						
						sortieCentre = true;
						break;
	
					default:
						MyLibraryOuf.afficher("Quelque chose a mal tourné");
						break;
					}
				}
				
				
				break;

			case 2: // ------- Cantine
				
				
				Boolean sortiePlat;
				sortieCantine = false;
				
				while(!sortieCantine) {
					
					switch (MyLibraryOuf.repeterInt("         Application OUF " + 
							"\n           Administrateur"
		
							+ "\nCantine\n"
							+ "\n1- Ajouter un nouveau Mets"
							+ "\n2- Entrées"
							+ "\n3- Plats Principaux" 
							+ "\n4- Desserts"
							+ "\n5- Menus"
							
							+ "\n\n\n0- Précédent")) {
					
					
					
					case 1:
						
						OperationCantineOuf.createPlatCantine(
								"         Application OUF " + 
										"\n        Administrateur"
										+ "\nCantine"
										+ "\n\nAjouter un nouveau Mets");
						
						
						
						break;
					
					
					case 2: // Cantine 
						
						sortiePlat = false ;
						
						while (!sortiePlat){
							
							switch (MyLibraryOuf.repeterInt("         Application OUF "
									+ "\n     Administrateur\n"
									+ "	\nCantine Entrée\n\n"
									+ "\n1- Afficher la liste des Entrées" 
									+ "\n2- Mise à jour du nombre d'Entrées"
									+ "\n3- Mise à jour du prix des Entrées"
									+ "\n4- Modifier la disponibilité des Entrées"
									+ "\n5- Supprimer une Entrée"
									
									+ "\n\n\n0- Précédent")) 
							{
							case 1:
								
								OperationCantineOuf.allEntree(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Entrée"
												+ "\n\nAfficher la liste des Entrées");
								
								
								break;
								
							case 2:
								
								OperationCantineOuf.miseAjourNombreEntree(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Entrée"
												+ "\n\nMise à jour du nombre d'Entrées");
								
								break;
								
							case 3:
								
								OperationCantineOuf.miseAjourPrixEntree(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Entrée"
												+ "\n\nMise à jour du prix des Entrées");
								
								break;
								
							case 4:
								
								OperationCantineOuf.dispoIndispoEntree(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Entrée"
												+ "\n\nModifier la disponibilité des Entrées");
								
								break;
								
							case 5:
								
								OperationCantineOuf.deletedEntree(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Entrée"
												+ "\n\nSupprimer une Entrée");
								
								break;
								
								
								
							case 0:
								
								sortiePlat = true;
	
								break;
			
							default:
								MyLibraryOuf.afficher("Quelque chose a mal tourné");
								break;
							}
							
						}
						
						break;
						
						
					case 3:
						
						sortiePlat = false ;
						
						while (!sortiePlat){
							
							switch (MyLibraryOuf.repeterInt("         Application OUF "
									+ "\n            Administrateur\n"
									+ "	\nCantine Plats principaux\n\n"
									+ "\n1- Afficher la liste des Plats principaux" 
									+ "\n2- Mise à jour du nombre de Plat principal"
									+ "\n3- Mise à jour du prix des Plats principaux"
									+ "\n4- Modifier la disponibilité des Plats principaux"
									+ "\n5- Supprimer un Plat principal"
									
									+ "\n\n\n0- Précédent")) 
							{
							case 1:
								
								OperationCantineOuf.allPlatPrincipal(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Plats principaux"
												+ "\n\nAfficher la liste des Plats principaux");
								
								
								break;
								
							case 2:
								
								OperationCantineOuf.miseAjourNombrePlatPrincipal(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Plats principaux"
												+ "\n\nMise à jour du nombre de Plats principaux");
								
								break;
								
							case 3:
								
								OperationCantineOuf.miseAjourPrixPlatPrincipal(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Plats principaux"
												+ "\n\nMise à jour du prix des Plats principaux");
								
								break;
								
							case 4:
								
								OperationCantineOuf.dispoIndispoPlatPrincipal(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Plats principaux"
												+ "\n\nModifier la disponibilité des Plats principaux");
								
								break;
								
							case 5:
								
								OperationCantineOuf.deletedPlatPrincipal(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Plats principaux"
												+ "\n\nSupprimer un Plat principal");
								
								break;
								
								
								
							case 0:
								
								sortiePlat = true;
	
								break;
			
							default:
								MyLibraryOuf.afficher("Quelque chose a mal tourné");
								break;
							}
							
						}
	
						
						break;
						
					case 4:
						sortiePlat = false ;
						
						while (!sortiePlat){
							
							switch (MyLibraryOuf.repeterInt("         Application OUF "
									+ "\n              Administrateur\n"
									+ "	\nCantine Desserts\n\n"
									+ "\n1- Afficher la liste des Desserts" 
									+ "\n2- Mise à jour du nombre de Dessert"
									+ "\n3- Mise à jour du prix des Desserts"
									+ "\n4- Modifier la disponibilité des Desserts"
									+ "\n5- Supprimer un Dessert"
									
									+ "\n\n\n0- Précédent")) 
							{
							case 1:
								
								OperationCantineOuf.allDessert(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Desserts"
												+ "\n\nAfficher la liste des Desserts");
								
								
								break;
								
							case 2:
								
								OperationCantineOuf.miseAjourNombreDessert(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Desserts"
												+ "\n\nMise à jour du nombre de Desserts");
								
								break;
								
							case 3:
								
								OperationCantineOuf.miseAjourPrixDessert(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Desserts"
												+ "\n\nMise à jour du prix des Desserts");
								
								break;
								
							case 4:
								
								OperationCantineOuf.dispoIndispoDessert(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Desserts"
												+ "\n\nModifier la disponibilité des Desserts");
								
								break;
								
							case 5:
								
								OperationCantineOuf.deletedDessert(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Desserts"
												+ "\n\nSupprimer une Desserts");
								
								break;
								
								
								
							case 0:
								
								sortiePlat = true;
	
								break;
			
							default:
								MyLibraryOuf.afficher("Quelque chose a mal tourné");
								break;
							}
							
						}
						
						break;
						
						
					case 5:
						
						sortiePlat = false ;
						
						while (!sortiePlat){
							
							switch (MyLibraryOuf.repeterInt("         Application OUF "
									+ "\n       Administrateur\"\n"
									+ "	\nCantine Menu\n\n"
									+ "\n1- Afficher tous les Menus" 
									+ "\n2- Créer un Menu"
									+ "\n3- Mise à jour d'un Menu"
									+ "\n4- Supprimer un Menu"
									
									// + "\n5- Supprimer une Entrée"
									
									+ "\n\n\n0- Précédent")) 
							{
							case 1:
								
								OperationCantineOuf.allMenu(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Menu"
												+ "\n\nAfficher la liste des Menus");
								
								
								break;
								
							case 2:
								
								OperationCantineOuf.createMenuCantine(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Menu"
												+ "\n\nCréer un Menu");
								
								break;
								
							case 3:
								
								OperationCantineOuf.miseAjourMenu(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Menu"
												+ "\n\nMise à jour d'un Menu");
								
								break;
								
							case 4:
								
								OperationCantineOuf.deletedMenu(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCantine Entrée"
												+ "\n\nModifier la disponibilité des Entrées");
								
								break;
								
								
							case 0:
								
								sortiePlat = true;
	
								break;
			
							default:
								MyLibraryOuf.afficher("Quelque chose a mal tourné");
								break;
							}
							
						}
						
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
				
				Boolean sortiePraticien;
				
				sortieCentreMedical = false;
				
				while(!sortieCentreMedical) {
					
					switch (MyLibraryOuf.repeterInt("         Application OUF " + 
							"\n            Administrateur"
		
							+ "\nCentre Médical\n" 
							+ "\n1- Visionner tous les RDV"
							+ "\n2- Enregistrer un Nouveau Praticien" 
							+ "\n3- Afficher Praticien"
							
							
							+ "\n\n\n0- Précédent")) {
					
					case 1:
						
						OperationCentreMedicalOuf.allRdvAdmin(
								"         Application OUF " + 
										"\n          Administrateur"
										+ "\nCentre Médical"
										+ "\n\nVisionner tous les RDV");
						
						break;
						
					case 2:
						
						OperationCentreMedicalOuf.createSpecialisteMedical(
								"         Application OUF " + 
										"\n          Administrateur"
										+ "\nCentre Médical"
										+ "\n\nEnregistrer un Nouveau Praticien");
						
						break;
						
					case 3:
						
						sortiePraticien = false ;
						
						while (!sortiePraticien){
							
							switch (MyLibraryOuf.repeterInt("         Application OUF "
									+ "\n       Administrateur\"\n"
									+ "	\nCentre Médical\n\n"
									+ "\n1- Afficher les Généralistes" 
									+ "\n2- Afficher les Ophtalmologues"
									+ "\n3- Afficher les Dermatologues"
									
									
									+ "\n\n\n0- Précédent")) {
							
							
							case 1:
								
								OperationCentreMedicalOuf.allGeneralisteAdmin(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCentre Médical"
												+ "\n\nAfficher les Généralistes");
								
								
								break;
								
							case 2:
								
								OperationCentreMedicalOuf.allOphtalmoAdmin(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCentre Médical"
												+ "\n\nAfficher les Ophtalmologues");
								
								break;
								
							case 3:
								
								OperationCentreMedicalOuf.allDermatoAdmin(
										"         Application OUF " + 
												"\n               Administrateur"
												+ "\nCentre Médical"
												+ "\n\nAfficher les Dermatologues");
								
								break;
								
								
							case 0:
								
								sortiePraticien = true;
	
								break;
			
							default:
								MyLibraryOuf.afficher("Quelque chose a mal tourné");
								break;
							
							}
							
						}
						
						
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
					
					switch (MyLibraryOuf.repeterInt("         Application OUF " + 
							"\n            Administrateur"
		
							+ "\nGestionnaire Carte\n" 
							+ "\n1- Afficher la liste des Cartes"
							+ "\n2- Créer une nouvelle Carte" 
							+ "\n3- Recharger une Carte"
							+ "\n4- Visualiser l'Historique d'une Carte"
							+ "\n5- Visualiser les notifications"
							+ "\n6- Bloquer ou Débloquer une Carte"
						
							
							+ "\n\n\n0- Précédent")) {
					
					case 1:
						
						OperationCarteOuf.allCartesAdmin(
								"         Application OUF " + 
										"\n          Administrateur"
										+ "\nGestionnaire Carte"
										+ "\n\nAfficher la liste des Cartes");
						
						
						break;
						
					case 2:
						
						OperationCarteOuf.createCarte("         Application OUF " + 
								"\n          Administrateur"
								+ "\nGestionnaire Carte"
								+ "\n\nCréer une nouvelle Carte");
						
						break;
						
					case 3:
						
						OperationCarteOuf.rechargerCarte(
								"         Application OUF " + 
										"\n          Administrateur"
										+ "\nGestionnaire Carte" 
										+ "\n\nRecharger une Carte");
						
						break;
						
					case 4:
						
						OperationCarteOuf.allHistoriqueCarte(
								"         Application OUF " + 
										"\n          Administrateur"
										+ "\nGestionnaire Carte" 
										+ "\n\nVisualiser l'Historique d'une Carte");
						
						break;
						
					case 5:
						
						MyLibraryOuf.afficher("         Application OUF " + 
								"\n           Administrateur"
								+ "\nGestionnaire Carte" 
								+ "\n\nVisualiser les notifications"
								+ "\n\n" + OperationCarteOuf.allNotificationCartesAdmin());
						
						
						
						break;
						
						
					case 6:
						
						OperationCarteOuf.bloqueDebloqueCarte(
								"         Application OUF " + 
										"\n           Administrateur"
										+ "\nGestionnaire Carte" 
										+ "\n\nBloquer ou Débloquer une Carte");
						
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
			case 5:
				
				MyLibraryOuf.afficher("         Application OUF " + 
						"\n       Administrateur"
						+ "\nDonnées");
				
				OperationPersonOuf.allUser("Utilisateur\n");
				
				OperationPersonOuf.allAdmin("Administrateur\n");
				
				break;
				
			case 0:
				
				MyLibraryOuf.afficher("         Application OUF " + 
						"\n       Administrateur " + "\nA très bientôt Administrateur");
				sortie = true;
				break;
			
			default:
				
				break;
			}
			
		}
	}

}
