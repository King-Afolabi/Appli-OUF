package fr.esic.viewOuf;

import fr.esic.controllerOuf.MyLibraryOuf;
import fr.esic.controllerOuf.OperationPersonOuf;
import fr.esic.modelOuf.SaveConnectOuf;

public class MenuOuf {

	public static void menuLogin() {

		// Variable pour mettre fin au code
		boolean sortie = false;
		int i = 0;
		int choix;
		int idPerson;
		
		
		

		String msg;
		
		while (!sortie) {
			do {
			
		msg = MyLibraryOuf.saisie("        Application OUF \n\n1- Connexion \n2- Inscription \n3- Mot de passe oublié "
				+ "\n\n\n0- Quitter l'application");
		} while (MyLibraryOuf.checkIntDouble(msg) != "oui");

			
	
			
			//------------------ Connexion au menu admin ou user	-------------------------------------------------	
		
		


			switch (MyLibraryOuf.convertirInt(msg)) {
			
			case 1:
				
				SaveConnectOuf saveConnect = OperationPersonOuf.connexion();
				
				choix = saveConnect.getChoix();
				idPerson = saveConnect.getIdPerson();
				
				Boolean deconnect = false;

				while (!deconnect) {

					switch (choix) {
					
					

					case 1:

						
						MenuOufUser.menuUser(idPerson);

						break;

					case 2:

						MenuOufAdmin.menuAdmin(idPerson);

						break;

					case 0:

						MyLibraryOuf.afficher("Email ou Mot de passe incorrect !");
						
						deconnect = true;

						break;

					default:
						break;
					}
					deconnect = true;
				}

//-------------------Fin connexion admin				

				break;

			case 2:

				OperationPersonOuf.createUser();

				break;

			case 3:
				MyLibraryOuf.afficher("Pas encore disponible");

				
				/*
				 * OperationPersonOuf.allUser();
				 *OperationPersonOuf.allAdmin();
				*/
				
				break;

			case 0:
				
				sortie = true;
				break;

			default:
				MyLibraryOuf.afficher("Mauvaise saisie !");

				i++;
				if (i > 2) {
					sortie = true;
				}

				break;
			}
		}

		MyLibraryOuf.afficher("Merci et à très bientôt !");
	}

}
