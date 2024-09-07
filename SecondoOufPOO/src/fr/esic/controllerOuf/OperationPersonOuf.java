package fr.esic.controllerOuf;

import java.util.ArrayList;
import java.util.List;

import fr.esic.modelOuf.AdminOuf;
import fr.esic.modelOuf.SaveConnectOuf;
import fr.esic.modelOuf.UserOuf;

public class OperationPersonOuf {
	
	
//--- 1 Créations de liste array pour stocker les données admins et users

	// liste admins
	public static List<AdminOuf> admins = new ArrayList<>();

	// liste users
	public static List<UserOuf> users = new ArrayList<>();
	
	
	
	
//--- 2 Créations de fonctions et procédures (Méthodes)
	
	
	//----- Procédures (Méthodes) pour afficher l'ensemble des élements de chaque liste
	
	public static void allUser(String affichage) { // USERS
		
		MyLibraryOuf.afficher(affichage);
		String dataUser = "";
		
		
		int i =0;
		
		for (UserOuf user : users) {
			i++;
			dataUser += users.indexOf(user)+ " - " + user.infoUser() + "\n";
			
			if (i == 3) {
				MyLibraryOuf.afficher(dataUser);
				dataUser = "";
				i =0;
			}
		}
		
	}
	
	
	public static void allAdmin(String affichage) { // ADMINS
		
		MyLibraryOuf.afficher(affichage);
		String dataAdmin = "";
		
		int i =0;
		for (AdminOuf admin : admins) {
			dataAdmin += admins.indexOf(admin)+ "- " + admin.infoAdmin() + "\n";
			if (i == 3) {
				MyLibraryOuf.afficher(dataAdmin);
				dataAdmin = "";
				i =0;
			}
		}
		
	}
	
	
	
	//----- Méthode pour récupérer l'index d'un AdminOuf dans une liste à partir de l'email
    
	public static int getIndexByEmailAdmin(List<AdminOuf> admins2, String emailRecherche) {
        for (int i = 0; i < admins2.size(); i++) {
            if (admins2.get(i).getEmailAdmin().equals(emailRecherche)) {
                return i; // Retourne l'index si l'email correspond
            }
        }
        return -1; // Retourne -1 si l'email n'est pas trouvé dans la liste
    }
	
	
	//----- Méthode pour récupérer l'index d'un UserOuf dans une liste à partir de l'email
	
	public static int getIndexByEmailUser(List<UserOuf> users2, String emailRecherche) {
        for (int i = 0; i < users2.size(); i++) {
            if (users2.get(i).getEmailUser().equals(emailRecherche)) {
                return i; // Retourne l'index si l'email correspond
            }
        }
        return -1; // Retourne -1 si l'email n'est pas trouvé dans la liste
    }
	
	
	
	
	//----- Méthode pour Créer Users
	
	public static void createUser() {
		
		
		String nomUser;
		String prenomUser;
		String emailUser;
		String mdpUser;
		
		
		do { // Boucle pour ne pas laisser un champ vide.
			
			MyLibraryOuf.afficher("Veuillez à ne pas laisser un champ vide !");

			nomUser = MyLibraryOuf.saisie("Saisir votre nom").trim();
	
			prenomUser = MyLibraryOuf.saisie("Saisir votre prénom").trim();
	
			emailUser = MyLibraryOuf.saisie("Saisir votre adresse mail").trim();
	
			mdpUser = MyLibraryOuf.saisie("Saisir votre not de passe");

		} while ((nomUser.isEmpty()) || (prenomUser.isEmpty())
				|| (emailUser.isEmpty()) || (mdpUser.isEmpty()));
		
		
		UserOuf user = new UserOuf(nomUser, prenomUser, emailUser, mdpUser);

		users.add(user);

		
		MyLibraryOuf.afficher("Inscription reussie !\n" + "Identifiant : " + users.indexOf(user) + "\nNom : "
				+ user.getNomUser() + "\nPrenom : " + user.getPrenomUser() + "\nAdresse mail : " + user.getEmailUser()
				+ "\nMot de passe : **...**"
				+ "\n\nNB : L'identifiant est nécessaire à la connexion prière de le retenir... Merci et bienvenue");

	}
	
	
	//----- Méthode pour créer un Admin
	
	public static void createAdmin(String affichage) {
		
		MyLibraryOuf.afficher(affichage);
		
		String nomAdmin;
		String prenomAdmin;
		String emailAdmin;
		String mdpAdmin;
		
		
		do { // Boucle pour ne pas laisser un champ vide.
			
			MyLibraryOuf.afficher("Veuillez à ne pas laisser un champ vide SVP !");

			nomAdmin = MyLibraryOuf.saisie("Saisir votre nom").trim();
	
			prenomAdmin = MyLibraryOuf.saisie("Saisir votre prénom").trim();
	
			emailAdmin = MyLibraryOuf.saisie("Saisir votre adresse mail").trim();
	
			mdpAdmin = MyLibraryOuf.saisie("Saisir votre not de passe");

		} while ((nomAdmin.isEmpty()) || (prenomAdmin.isEmpty())
				|| (emailAdmin.isEmpty()) || (mdpAdmin.isEmpty()));
		
		
		AdminOuf admin = new AdminOuf(nomAdmin, prenomAdmin, emailAdmin, mdpAdmin);

		admins.add(admin);

		
		MyLibraryOuf.afficher("Création reussie !\n" + "Identifiant : " + admins.indexOf(admin) + "\nNom : "
				+ admin.getNomAdmin() + "\nPrenom : " + admin.getPrenomAdmin() + "\nAdresse mail : " + admin.getEmailAdmin()
				+ "\nMot de passe : **...**"
				+ "\n\nNB : L'identifiant est nécessaire à la connexion prière de le retenir... Merci et bienvenue");

	}


	
	
	
	// Fonction connexion qui retourne 0 si pas bon, 1 si user, 2 si admin.
	
	public static SaveConnectOuf connexion() {
	
			
		String email = MyLibraryOuf.saisie("Saisir votre adresse mail");

		String mdp = MyLibraryOuf.saisie("Saisir votre mot de passe");

		int indexAdmin = getIndexByEmailAdmin(admins, email);
		int indexUser = getIndexByEmailUser(users, email);
		
		
		
		
		if (indexAdmin != -1) {
			
			if (email.equals(admins.get(indexAdmin).getEmailAdmin()) && (mdp.equals(admins.get(indexAdmin).getMdpAdmin()))) {
				
			
				return new SaveConnectOuf(2, indexAdmin);
			}
		} else if (indexUser != -1) {
			
			if (email.equals(users.get(indexUser).getEmailUser()) && (mdp.equals(users.get(indexUser).getMdpUser()))) {
				
				return new SaveConnectOuf(1, indexUser);
			}
		}
		
			
		return new SaveConnectOuf(0, -1);

	}

}
