package fr.esic.modelOuf;

public class SaveConnectOuf {
	
	
	private int choix;
	
	private int idPerson;
	
	
	
	public SaveConnectOuf() {
		
	}
	
	public SaveConnectOuf(int choix,  int idPerson) {
		
		this.choix = choix;
		this.idPerson = idPerson;
		
	}


	public int getChoix() {
		return choix;
	}


	public int getIdPerson() {
		return idPerson;
	}
	
	
	
	

}
