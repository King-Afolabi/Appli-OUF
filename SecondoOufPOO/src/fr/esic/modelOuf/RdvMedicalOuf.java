package fr.esic.modelOuf;

public class RdvMedicalOuf {
	
	private String nomPatient;
	
	private String prenomPatient;
	
	private String dateRdv;
	
	private String heureRdv;
	
	
	
	private String specialiteMedical;
	
	private String medecinSpecialiste;
	
	private String gradeSpécialiste;
	
	private int indexPersonRdv;
	
	
	// Constructeur
	public RdvMedicalOuf(String medecinSpecialiste, String specialiteMedical, String gradeSpécialiste) {
		
		this.medecinSpecialiste = medecinSpecialiste;
		this.specialiteMedical = specialiteMedical;
		this.gradeSpécialiste = gradeSpécialiste;
		
	}
	

	public RdvMedicalOuf(int indexPersonRdv,String nomPatient, String prenomPatient, String dateRdv, String heureRdv
			, String specialiteMedical, String medecinSpecialiste, String gradeSpécialiste) {
		
		this.indexPersonRdv = indexPersonRdv;
		this.nomPatient = nomPatient;
		this.prenomPatient = prenomPatient;
		this.dateRdv = dateRdv;
		this.heureRdv = heureRdv;
		this.specialiteMedical = specialiteMedical;
		this.medecinSpecialiste = medecinSpecialiste;
		this.gradeSpécialiste = gradeSpécialiste;
	}

	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}

	public String getPrenomPatient() {
		return prenomPatient;
	}

	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
	}

	public String getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(String dateRdv) {
		this.dateRdv = dateRdv;
	}
	

	public String getHeureRdv() {
		return heureRdv;
	}

	public void setHeureRdv(String heureRdv) {
		this.heureRdv = heureRdv;
	}

	public String getSpecialiteMedical() {
		return specialiteMedical;
	}

	public void setSpecialiteMedical(String specialiteMedical) {
		this.specialiteMedical = specialiteMedical;
	}

	public String getMedecinSpecialiste() {
		return medecinSpecialiste;
	}

	public void setMedecinSpecialiste(String medecinSpecialiste) {
		this.medecinSpecialiste = medecinSpecialiste;
	}

	public String getGradeSpécialiste() {
		return gradeSpécialiste;
	}
	
	public void setGradeSpécialiste(String gradeSpécialiste) {
		this.gradeSpécialiste = gradeSpécialiste;
	}
	
	public String infoRdvMedicalAdmin() {
		
		return "Identifiant Patient : " + indexPersonRdv
				+"\nNom Patient : " + nomPatient
				+ "\nPrenom : " + prenomPatient
				+ "\nDate : " + dateRdv
				+ "\nHeure : " + heureRdv
				+ "\nSpécialité : " + specialiteMedical
				+ "\nMédecin : " + medecinSpecialiste;
		
	}
	
	public String infoRdvMedicalUser() {
		
		return "\nSpécialité : " + specialiteMedical
				+ "\nMédecin : " + medecinSpecialiste
				+"\nGrade : " + gradeSpécialiste
				+ "\nDate : " + dateRdv
				+ "\nHeure : " + heureRdv;
	}
	
	
	public String infoPraticienAdmin() {
		
		return "Nom et prenom : " + medecinSpecialiste
				+ "\nSpécialité : " + specialiteMedical
				+ "\nGrade : " + gradeSpécialiste;
	}
	
	
}
