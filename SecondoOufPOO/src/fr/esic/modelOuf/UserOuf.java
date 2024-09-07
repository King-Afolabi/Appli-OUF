package fr.esic.modelOuf;

public class UserOuf {
	

	private String nomUser;
	
	private String prenomUser;
	
	private String emailUser;
	
	private String mdpUser;
	
	
	
	public UserOuf() {
		
	}
	
	
	public UserOuf( String nomUser, String prenomUser, String emailUser, String mdpUser) {
		

		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.emailUser = emailUser;
		this.mdpUser = mdpUser;

	}


	public String getMdpUser() {
		return mdpUser;
	}


	public void setMdpUser(String mdpUser) {
		this.mdpUser = mdpUser;
	}


	public String getNomUser() {
		return nomUser;
	}


	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}


	public String getPrenomUser() {
		return prenomUser;
	}


	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}


	public String getEmailUser() {
		return emailUser;
	}


	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	
	
	public String infoUser() {
		return "\nNom : " + 
				 nomUser + ""
				 		+ "\nPrénom : " + prenomUser + ""
				 				+ "\nMail : " + emailUser + "\nMot de passe : **..**\n" ;
	}
	
}
