package fr.esic.modelOuf;

public class CarteOuf {
	
	
	private String nomCarte;
	
	private String prenomCarte;
	
	private int mdpCarte;
	
	private String categorieCarte;
	
	private Double soldeCarte;
	
	private String validiteCarte;
	
	private Boolean statutCarte;
	
	private String notificationCarte;
	
	private String historiqueCarte;
	
	private int indexPerson;
	
	
	public CarteOuf(int indexPerson,String notificationCarte) {
		this.indexPerson = indexPerson;
		this.notificationCarte = notificationCarte;
	}
	
	
	public CarteOuf(int indexPerson, String nomCarte, String prenomCarte, int mdpCarte, String categorieCarte, Double soldeCarte, 
			String validiteCarte, Boolean statutCarte, String notificationCarte, String historiqueCarte) {
		
		this.indexPerson = indexPerson;
		this.nomCarte = nomCarte;
		this.prenomCarte = prenomCarte;
		this.mdpCarte = mdpCarte;
		this.categorieCarte = categorieCarte;
		this.soldeCarte = soldeCarte;
		this.validiteCarte = validiteCarte;
		this.statutCarte = statutCarte;
		this.notificationCarte = notificationCarte;
		this.historiqueCarte = historiqueCarte;
	}

	

	public int getIndexPerson() {
		return indexPerson;
	}


	public void setIndexPerson(int indexPerson) {
		this.indexPerson = indexPerson;
	}


	public String getHistoriqueCarte() {
		return historiqueCarte;
	}


	public void setHistoriqueCarte(String historiqueCarte) {
		this.historiqueCarte = historiqueCarte;
	}



	public String getNomCarte() {
		return nomCarte;
	}


	public void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}


	public String getPrenomCarte() {
		return prenomCarte;
	}


	public void setPrenomCarte(String prenomCarte) {
		this.prenomCarte = prenomCarte;
	}
	

	public int getMdpCarte() {
		return mdpCarte;
	}


	public void setMdpCarte(int mdpCarte) {
		this.mdpCarte = mdpCarte;
	}


	public String getCategorieCarte() {
		return categorieCarte;
	}


	public void setCategorieCarte(String categorieCarte) {
		this.categorieCarte = categorieCarte;
	}


	

	public String getValiditeCarte() {
		return validiteCarte;
	}


	public void setValiditeCarte(String validiteCarte) {
		this.validiteCarte = validiteCarte;
	}


	public Boolean getStatutCarte() {
		return statutCarte;
	}


	public void setStatutCarte(Boolean statutCarte) {
		this.statutCarte = statutCarte;
	}


	public String getNotificationCarte() {
		return notificationCarte;
	}


	public void setNotificationCarte(String notificationCarte) {
		this.notificationCarte = notificationCarte;
	}
	
	public Double getSoldeCarte() {
		return soldeCarte;
	}
	
	
	public void setSoldeCarte(Double soldeCarte) {
		this.soldeCarte = soldeCarte;
	}
	
	
	
	public String infoCarteAdmin() {
		return "Nom : " + nomCarte 
				+ "\nPrénom : " + prenomCarte
				+ "\nMot de passe : ****"
				+ "\nCatégorie carte : " + categorieCarte
				+ "\nSolde carte : " + soldeCarte + " €"
				+ "\nValidité carte : " + validiteCarte
				+ "\nStatut carte : " + statutCarte
				+ "\nNotification carte : " + notificationCarte;
		
		
	}
	
	
	
	public String infoCarteUser() {
		return "Nom : " + nomCarte 
				+ "\nPrénom : " + prenomCarte
				+ "\nMot de passe : " + mdpCarte
				+ "\nCatégorie carte : " + categorieCarte
				+ "\nSolde carte : " + soldeCarte + " €"
				+ "\nValidité carte : " + validiteCarte
				+ "\nNotification carte : " + notificationCarte;
		
	}
	
	public String infoSoldeUser() {
		return 	"\nSolde carte : " + soldeCarte + " €";
				
	}


	public String infoNotification() {
		
		return "Identifiant User : " + indexPerson
				+ "\n" + notificationCarte;
	}
	
	

}

