package fr.esic.modelOuf;

public class AdminOuf {

	private String nomAdmin;

	private String prenomAdmin;

	private String emailAdmin;

	private String mdpAdmin;

	public AdminOuf() {

	}

	public AdminOuf(String nomAdmin, String prenomAdmin, String emailAdmin, String mdpAdmin) {

		this.nomAdmin = nomAdmin;
		this.prenomAdmin = prenomAdmin;
		this.emailAdmin = emailAdmin;
		this.mdpAdmin = mdpAdmin;

	}

	public String getNomAdmin() {
		return nomAdmin;
	}

	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}

	public String getPrenomAdmin() {
		return prenomAdmin;
	}

	public void setPrenomAdmin(String prenomAdmin) {
		this.prenomAdmin = prenomAdmin;
	}

	public String getEmailAdmin() {
		return emailAdmin;
	}

	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}

	public String getMdpAdmin() {
		return mdpAdmin;
	}

	public void setMdpAdmin(String mdpAdmin) {
		this.mdpAdmin = mdpAdmin;
	}

	public String infoAdmin() {
		return	"\nNom : " + nomAdmin + "" + "\nPrénom : " + prenomAdmin + "" + "\nMail : " + emailAdmin
				+ "\nMot de passe : **..**\n";
	}

}