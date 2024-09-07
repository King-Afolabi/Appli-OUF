package fr.esic.viewOuf;

import fr.esic.controllerOuf.MyLibraryOuf;
import fr.esic.controllerOuf.OperationCantineOuf;
import fr.esic.controllerOuf.OperationCarteOuf;
import fr.esic.controllerOuf.OperationCentreMedicalOuf;
import fr.esic.controllerOuf.OperationMarketOuf;
import fr.esic.controllerOuf.OperationPersonOuf;
import fr.esic.modelOuf.AdminOuf;
import fr.esic.modelOuf.CarteOuf;
import fr.esic.modelOuf.MetsCantineOuf;
import fr.esic.modelOuf.PlatCantineOuf;
import fr.esic.modelOuf.UserOuf;
import fr.esic.modelOuf.ProduitMarketOuf;
import fr.esic.modelOuf.RdvMedicalOuf;

public class ProgramOuf {
	
	
	static {
		
		// Création de 7 users
		UserOuf user1 = new UserOuf("User1", "z", "z", "z");
		UserOuf user2 = new UserOuf("User2", "q", "q", "q");
		
		OperationPersonOuf.users.add(user1);
		OperationPersonOuf.users.add(user2);
		
		OperationPersonOuf.users.add(new UserOuf("Dupont", "Jean", "jean.dupont@example.com", "password1"));
		OperationPersonOuf.users.add(new UserOuf("Martin", "Marie", "marie.martin@example.com", "password2"));
		OperationPersonOuf.users.add(new UserOuf("Bernard", "Pierre", "pierre.bernard@example.com", "password3"));
		OperationPersonOuf.users.add(new UserOuf("Robert", "Paul", "paul.robert@example.com", "password4"));
		OperationPersonOuf.users.add(new UserOuf("Richard", "Lucie", "lucie.richard@example.com", "password5"));
		OperationPersonOuf.users.add(new UserOuf("Petit", "Julien", "julien.petit@example.com", "password6"));
		OperationPersonOuf.users.add(new UserOuf("Durand", "Sophie", "sophie.durand@example.com", "password7"));
		OperationPersonOuf.users.add(new UserOuf("Leroy", "Henri", "henri.leroy@example.com", "password8"));
		OperationPersonOuf.users.add(new UserOuf("Moreau", "Camille", "camille.moreau@example.com", "password9"));
		OperationPersonOuf.users.add(new UserOuf("Simon", "Antoine", "antoine.simon@example.com", "password10"));
		OperationPersonOuf.users.add(new UserOuf("Laurent", "Isabelle", "isabelle.laurent@example.com", "password11"));
		OperationPersonOuf.users.add(new UserOuf("Lefevre", "Thomas", "thomas.lefevre@example.com", "password12"));
		OperationPersonOuf.users.add(new UserOuf("Michel", "Sarah", "sarah.michel@example.com", "password13"));
		OperationPersonOuf.users.add(new UserOuf("Garcia", "Laura", "laura.garcia@example.com", "password14"));
		OperationPersonOuf.users.add(new UserOuf("David", "Hugo", "hugo.david@example.com", "password15"));
		OperationPersonOuf.users.add(new UserOuf("Bertrand", "Emma", "emma.bertrand@example.com", "password16"));
		OperationPersonOuf.users.add(new UserOuf("Roux", "Louis", "louis.roux@example.com", "password17"));
		OperationPersonOuf.users.add(new UserOuf("Vincent", "Julie", "julie.vincent@example.com", "password18"));
		OperationPersonOuf.users.add(new UserOuf("Fournier", "Lucas", "lucas.fournier@example.com", "password19"));
		OperationPersonOuf.users.add(new UserOuf("Morel", "Chloe", "chloe.morel@example.com", "password20"));

        
        
        // Création de praticien
        
        OperationCentreMedicalOuf.generalisteMedicals.add(new RdvMedicalOuf("Robert Paul", "Généraliste", "2"));
        OperationCentreMedicalOuf.generalisteMedicals.add(new RdvMedicalOuf("Martin Lucie", "Généraliste", "1"));
        
        OperationCentreMedicalOuf.ophtalmoMedicals.add(new RdvMedicalOuf("Moreau Jacques", "Ophtalmologue", "2"));
        OperationCentreMedicalOuf.ophtalmoMedicals.add(new RdvMedicalOuf("Laurent Emma", "Ophtalmologue", "1"));
        
        OperationCentreMedicalOuf.dermatoMedicals.add(new RdvMedicalOuf("Petit Camille", "Dermatologue", "2"));
        OperationCentreMedicalOuf.dermatoMedicals.add(new RdvMedicalOuf("Richard Isabelle", "Dermatologue", "1"));
        
        
        
        // Création de RDV
        
        OperationCentreMedicalOuf.rdvMedicals.add(new RdvMedicalOuf(0, OperationPersonOuf.users.get(0).getNomUser(),
        		OperationPersonOuf.users.get(0).getPrenomUser(), "2024-06-01", "10:00", "Généraliste", "Robert Paul", "2"));
        
        OperationCentreMedicalOuf.rdvMedicals.add(new RdvMedicalOuf(1, OperationPersonOuf.users.get(1).getNomUser(),
        		OperationPersonOuf.users.get(1).getPrenomUser(), "2024-06-02", "08:30", "Généraliste", "Martin Lucie", "1"));
        
        OperationCentreMedicalOuf.rdvMedicals.add(new RdvMedicalOuf(0, OperationPersonOuf.users.get(2).getNomUser(),
        		OperationPersonOuf.users.get(2).getPrenomUser(), "2024-06-03", "11:30", "Ophtalmologue", "Moreau Jacques", "2"));
        
        OperationCentreMedicalOuf.rdvMedicals.add(new RdvMedicalOuf(3, OperationPersonOuf.users.get(3).getNomUser(),
        		OperationPersonOuf.users.get(3).getPrenomUser(), "2024-06-04", "15:30", "Ophtalmologue", "Laurent Emma", "1"));
        
        OperationCentreMedicalOuf.rdvMedicals.add(new RdvMedicalOuf(0, OperationPersonOuf.users.get(4).getNomUser(),
        		OperationPersonOuf.users.get(4).getPrenomUser(), "2024-06-05", "08:30", "Dermatologue", "Petit Camille", "2"));
        
        OperationCentreMedicalOuf.rdvMedicals.add(new RdvMedicalOuf(5, OperationPersonOuf.users.get(5).getNomUser(),
        		OperationPersonOuf.users.get(5).getPrenomUser(), "2024-06-06", "09:45", "Dermatologue", "Richard Isabelle", "1"));        
       
        

		
		// ----- 2 Admins
		OperationPersonOuf.admins.add(new AdminOuf("admin1", "a", "a", "a"));
		OperationPersonOuf.admins.add(new AdminOuf("admin2", "b", "b", "b"));
		
		
		// ----- 5 produits

		OperationMarketOuf.produits.add(new ProduitMarketOuf("Lait", 1.20, "Alimentation", "Lait demi-écrémé", 100, "01/12/2024", 10, "Lactalis", false));
        OperationMarketOuf.produits.add(new ProduitMarketOuf("Pain", 0.90, "Boulangerie", "Pain complet", 50, "30/05/2024", 0, "Boulangerie du coin", true));
        OperationMarketOuf.produits.add(new ProduitMarketOuf("Savon", 2.50, "Hygiène", "Savon liquide", 200, "01/12/2025", 20, "Dove", true));
        OperationMarketOuf.produits.add(new ProduitMarketOuf("Pâtes", 1.00, "Alimentation", "Pâtes complètes", 150, "01/06/2025", 5, "Barilla", true));
        OperationMarketOuf.produits.add(new ProduitMarketOuf("Jus d'orange", 3.00, "Boissons", "Jus d'orange 100% pur jus", 80, "01/08/2024", 15, "Tropicana", true));
        
        
		
     // Entrées
        OperationCantineOuf.entrees.add(new PlatCantineOuf("Salade César", "Entrée", "Salade avec poulet, croutons et parmesan", 5.50, 30, true));
        OperationCantineOuf.entrees.add(new PlatCantineOuf("Soupe à l'oignon", "Entrée", "Soupe traditionnelle française avec des oignons caramélisés", 4.00, 20, true));
        OperationCantineOuf.entrees.add(new PlatCantineOuf("Bruschetta", "Entrée", "Tranches de pain grillé avec tomates, basilic et huile d'olive", 3.50, 25, true));
        OperationCantineOuf.entrees.add(new PlatCantineOuf("Carpaccio de boeuf", "Entrée", "Fines tranches de boeuf cru avec du parmesan et de la roquette", 6.00, 15, true));
        OperationCantineOuf.entrees.add(new PlatCantineOuf("Tapas", "Entrée", "Assortiment de petites bouchées espagnoles", 4.50, 20, true));

        // Plats principaux
        OperationCantineOuf.platPrincipaux.add(new PlatCantineOuf("Spaghetti Bolognaise", "Plat principal", "Spaghetti avec sauce bolognaise", 8.00, 50, true));
        OperationCantineOuf.platPrincipaux.add(new PlatCantineOuf("Poulet rôti", "Plat principal", "Poulet rôti avec des pommes de terre et des légumes", 10.00, 40, true));
        OperationCantineOuf.platPrincipaux.add(new PlatCantineOuf("Steak frites", "Plat principal", "Steak grillé avec des frites et une salade", 12.00, 35, true));
        OperationCantineOuf.platPrincipaux.add(new PlatCantineOuf("Lasagnes", "Plat principal", "Lasagnes à la viande avec une sauce béchamel", 9.50, 30, true));
        OperationCantineOuf.platPrincipaux.add(new PlatCantineOuf("Curry de légumes", "Plat principal", "Curry de légumes avec du riz basmati", 7.50, 25, true));

        // Desserts
        OperationCantineOuf.desserts.add(new PlatCantineOuf("Tarte aux pommes", "Dessert", "Tarte avec des pommes fraîches", 4.00, 20, true));
        OperationCantineOuf.desserts.add(new PlatCantineOuf("Mousse au chocolat", "Dessert", "Mousse au chocolat noir", 3.50, 25, true));
        OperationCantineOuf.desserts.add(new PlatCantineOuf("Crème brûlée", "Dessert", "Crème brûlée avec une croûte de sucre caramélisé", 4.50, 15, true));
        OperationCantineOuf.desserts.add(new PlatCantineOuf("Tiramisu", "Dessert", "Tiramisu italien avec des biscuits imbibés de café", 5.00, 10, true));
        OperationCantineOuf.desserts.add(new PlatCantineOuf("Glace à la vanille", "Dessert", "Glace à la vanille avec une sauce au chocolat", 3.00, 30, true));

        
        
        // Menus
        OperationCantineOuf.menus.add(new MetsCantineOuf(OperationCantineOuf.entrees.get(0),
        					OperationCantineOuf.platPrincipaux.get(0), OperationCantineOuf.desserts.get(0),
        					OperationCantineOuf.entrees.get(0).getPrixPlat() + OperationCantineOuf.platPrincipaux.get(0).getPrixPlat()+ OperationCantineOuf.desserts.get(0).getPrixPlat()));
	
        OperationCantineOuf.menus.add(new MetsCantineOuf(OperationCantineOuf.entrees.get(1),
				OperationCantineOuf.platPrincipaux.get(1), OperationCantineOuf.desserts.get(1),
				OperationCantineOuf.entrees.get(1).getPrixPlat() + OperationCantineOuf.platPrincipaux.get(1).getPrixPlat()+ OperationCantineOuf.desserts.get(1).getPrixPlat()));

        OperationCantineOuf.menus.add(new MetsCantineOuf(OperationCantineOuf.entrees.get(2),
				OperationCantineOuf.platPrincipaux.get(1), OperationCantineOuf.desserts.get(2),
				OperationCantineOuf.entrees.get(2).getPrixPlat() + OperationCantineOuf.platPrincipaux.get(2).getPrixPlat()+ OperationCantineOuf.desserts.get(2).getPrixPlat()));

        OperationCantineOuf.menus.add(new MetsCantineOuf(OperationCantineOuf.entrees.get(3),
				OperationCantineOuf.platPrincipaux.get(3), OperationCantineOuf.desserts.get(3),
				OperationCantineOuf.entrees.get(3).getPrixPlat() + OperationCantineOuf.platPrincipaux.get(3).getPrixPlat()+ OperationCantineOuf.desserts.get(3).getPrixPlat()));

        OperationCantineOuf.menus.add(new MetsCantineOuf(OperationCantineOuf.entrees.get(4),
				OperationCantineOuf.platPrincipaux.get(4), OperationCantineOuf.desserts.get(4),
				OperationCantineOuf.entrees.get(4).getPrixPlat() + OperationCantineOuf.platPrincipaux.get(4).getPrixPlat()+ OperationCantineOuf.desserts.get(4).getPrixPlat()));

        
        
        
        // Création Carte
        
        OperationCarteOuf.cartes.add(new CarteOuf(0, OperationPersonOuf.users.get(0).getNomUser(),
        		OperationPersonOuf.users.get(0).getPrenomUser(),
        		1234, "Gold", 100.0, "12/12/2028", true, "Bienvenue " + OperationPersonOuf.users.get(0).getNomUser() + " " 
        		+ OperationPersonOuf.users.get(0).getPrenomUser()
        		, "- Votre carte a été approvisionné de 100 €"));
        
        OperationCarteOuf.cartes.add(new CarteOuf(1, OperationPersonOuf.users.get(1).getNomUser(),
        		OperationPersonOuf.users.get(1).getPrenomUser(),
        		1234, "Classique", 10.0, "12/12/2028", true, "Bienvenue " + OperationPersonOuf.users.get(1).getNomUser() 
        		+ " " + OperationPersonOuf.users.get(1).getPrenomUser()
        		, "- Votre carte a été approvisionné de 10 €"));
        
        OperationCarteOuf.cartes.add(new CarteOuf(2, OperationPersonOuf.users.get(2).getNomUser(),
        		OperationPersonOuf.users.get(2).getPrenomUser(),
        		1234, "Gold", 100.0, "12/12/2028", true, "Bienvenue " + OperationPersonOuf.users.get(2).getNomUser() + " " 
        		+ OperationPersonOuf.users.get(2).getPrenomUser()
        		, "- Votre carte a été approvisionné de 100 €"));
        
        OperationCarteOuf.cartes.add(new CarteOuf(3, OperationPersonOuf.users.get(3).getNomUser(),
        		OperationPersonOuf.users.get(3).getPrenomUser(),
        		1234, "Classique", 10.0, "12/12/2028", true, "Bienvenue " + OperationPersonOuf.users.get(3).getNomUser() 
        		+ " " + OperationPersonOuf.users.get(1).getPrenomUser()
        		, "- Votre carte a été approvisionné de 10 €"));
        
        OperationCarteOuf.cartes.add(new CarteOuf(4, OperationPersonOuf.users.get(4).getNomUser(),
        		OperationPersonOuf.users.get(4).getPrenomUser(),
        		1234, "Gold", 100.0, "12/12/2028", true, "Bienvenue " + OperationPersonOuf.users.get(4).getNomUser() + " " 
        		+ OperationPersonOuf.users.get(4).getPrenomUser()
        		, "- Votre carte a été approvisionné de 100 €"));
        
        OperationCarteOuf.cartes.add(new CarteOuf(5, OperationPersonOuf.users.get(5).getNomUser(),
        		OperationPersonOuf.users.get(5).getPrenomUser(),
        		1234, "Classique", 10.0, "12/12/2028", true, "Bienvenue " + OperationPersonOuf.users.get(5).getNomUser() 
        		+ " " + OperationPersonOuf.users.get(5).getPrenomUser()
        		, "- Votre carte a été approvisionné de 10 €"));
        
        OperationCarteOuf.cartes.add(new CarteOuf(6, OperationPersonOuf.users.get(6).getNomUser(),
        		OperationPersonOuf.users.get(6).getPrenomUser(),
        		1234, "Gold", 100.0, "12/12/2028", true, "Bienvenue " + OperationPersonOuf.users.get(6).getNomUser() + " " 
        		+ OperationPersonOuf.users.get(6).getPrenomUser()
        		, "- Votre carte a été approvisionné de 100 €"));

        
        
        
        
        
	
	}
	
	public static void main(String[] args) {
		
		
		
		MyLibraryOuf.afficher("\n    Bienvenue à l'application OUF"
				+ "\n          Efficacité et Simplicité"
				+ "\n\n\n            Chargement en cours . . .");
		
		MenuOuf.menuLogin();
		
	}
	
	
}
