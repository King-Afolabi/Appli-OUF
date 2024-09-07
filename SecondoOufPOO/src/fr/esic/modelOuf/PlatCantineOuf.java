package fr.esic.modelOuf;

public class PlatCantineOuf {
	
	
	private String nomPlat;
    private String categoriePlat; // Exemple: Entrée, Plat principal, Dessert
    private String descriptionPlat;
    private Double prixPlat;
    private int		nombrePlat;
    private Boolean disponiblePlat; // Indique si le plat est actuellement disponible

    
    
    // Constructeur
    public PlatCantineOuf() {
    	
    }
    public PlatCantineOuf(String nomPlat, String categoriePlat, String descriptionPlat, Double prixPlat, int nombrePlat, Boolean disponiblePlat) {
    	
        this.nomPlat = nomPlat;
        this.categoriePlat = categoriePlat;
        this.descriptionPlat = descriptionPlat;
        this.prixPlat = prixPlat;
        this.nombrePlat = nombrePlat;
        this.disponiblePlat = disponiblePlat;
        }
    
    
	public String getNomPlat() {
		return nomPlat;
	}
	public void setNomPlat(String nomPlat) {
		this.nomPlat = nomPlat;
	}
	public String getCategoriePlat() {
		return categoriePlat;
	}
	public void setCategoriePlat(String categoriePlat) {
		this.categoriePlat = categoriePlat;
	}
	public String getDescriptionPlat() {
		return descriptionPlat;
	}
	public void setDescriptionPlat(String descriptionPlat) {
		this.descriptionPlat = descriptionPlat;
	}
	public Double getPrixPlat() {
		return prixPlat;
	}
	public void setPrixPlat(Double prixPlat) {
		this.prixPlat = prixPlat;
	}
	public int getNombrePlat() {
		return nombrePlat;
	}
	public void setNombrePlat(int nombrePlat) {
		this.nombrePlat = nombrePlat;
	}
	public Boolean getDisponiblePlat() {
		return disponiblePlat;
	}
	public void setDisponiblePlat(Boolean disponiblePlat) {
		this.disponiblePlat = disponiblePlat;
	}
	
	
	public String infoPlatCantineAdmin () {
		
		if (getNombrePlat() <= 0) {
			
			return nomPlat + " \n Prix : "
					+ prixPlat + " € | Catégorie : "
					+ categoriePlat + " | Description : "
					+ descriptionPlat + " \n Nombre : "
					+ nombrePlat + " | Activer : "
					+ disponiblePlat + " | "
					
					+ "Indisponible.";
			
			}
		return nomPlat + " \n Prix : "
		+ prixPlat + " € | Catégorie : "
		+ categoriePlat + " | Description : "
		+ descriptionPlat + " \nNombre : "
		+ nombrePlat + " | Activer : "
		+ disponiblePlat + " | "
		
		+ "Disponible.";
		
	}
	
	
	public String infoPlatCantineUser () {
		
		if (getNombrePlat() <= 0) {
			
			return nomPlat + " \n Prix : "
					+ prixPlat + " € | Catégorie : "
					+ categoriePlat + " | Description : "
					+ descriptionPlat + " \n"
					
					+ "Indisponible.";
			
			}
		return nomPlat + " \n Prix : "
		+ prixPlat + " € | Catégorie : "
		+ categoriePlat + " | Description : "
		+ descriptionPlat + " \n"
		
		+ "Disponible.";
		
	}
	
	
	public String infoPlatMenuAdmin () {
		
		if (getNombrePlat() <= 0) {
			
			return nomPlat + " \n Prix : "
					+ prixPlat + " € |"
					+ "\nNombre : "
					+ nombrePlat + " | Activer : "
					+ disponiblePlat + " | "
					
					+ "Indisponible.";
			
			}
		return nomPlat + " \n Prix : "
				+ prixPlat + " € |"
				+ "\nNombre : "
				+ nombrePlat + " | Activer : "
				+ disponiblePlat + " | "
		
		+ "Disponible.";
		
	}

	
	public String infoPlatMenuUser () {
		
		if (getNombrePlat() <= 0) {
			
			return nomPlat + " \n Prix : "
					+ prixPlat + " €"
					+ " | Description : "
					+ descriptionPlat + " \n"
					
					+ "Indisponible.";
			
			}
		return nomPlat + " \n Prix : "
				+ prixPlat + " €"
				+ " | Description : "
				+ descriptionPlat + " \n"
		
		+ "Disponible.";
		
	}
	
}
