package fr.esic.modelOuf;


public class MetsCantineOuf {
	
	private PlatCantineOuf entreeMenu;
	
	private PlatCantineOuf platPrincipalMenu;
	
	private PlatCantineOuf dessertMenu;
	
	private Double prixMenu;
	

	
	
	
	public MetsCantineOuf () {
		
	}
	
	
	public MetsCantineOuf (PlatCantineOuf entreeMenu, PlatCantineOuf platPrincipalMenu, PlatCantineOuf dessertMenu, Double prixMenu) {
		
		this.entreeMenu = entreeMenu; 
		
		this.platPrincipalMenu = platPrincipalMenu;
		
		this.dessertMenu = dessertMenu;
		
		this.prixMenu = prixMenu;
		
	}




	public PlatCantineOuf getEntree() {
		return entreeMenu;
	}


	public void setEntree(PlatCantineOuf entree) {
		this.entreeMenu = entree;
	}


	public PlatCantineOuf getPlatPrincipal() {
		return platPrincipalMenu;
	}


	public void setPlatPrincipal(PlatCantineOuf platPrincipal) {
		this.platPrincipalMenu = platPrincipal;
	}


	public PlatCantineOuf getDessert() {
		return dessertMenu;
	}


	public void setDessert(PlatCantineOuf dessert) {
		this.dessertMenu = dessert;
	}
	
	
	public Double getPrixMenu() {
		return prixMenu;
	}


	public void setPrixMenu(Double prixMenu) {
		this.prixMenu = prixMenu;
	}


	public String infoMenuAdmin() {
		
		return "Entrée : " + entreeMenu.infoPlatMenuAdmin()
				+ "\nPlat principal : " + platPrincipalMenu.infoPlatMenuAdmin()
				+ "\nDessert : " + dessertMenu.infoPlatMenuAdmin()
				+ "\n\nPrix du Menu : " + prixMenu + " €\n";
	}
	
	
	public String infoMenuUser() {
		
		
		return "Entrée : " + entreeMenu.infoPlatMenuUser()
				+ "\nPlat principal : " + platPrincipalMenu.infoPlatMenuUser()
				+ "\nDessert : " + dessertMenu.infoPlatMenuUser()
				+ "\n\nPrix du Menu : " + prixMenu + " €\n";
	}
	
}


