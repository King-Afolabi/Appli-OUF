package fr.esic.modelOuf;


public class ProduitMarketOuf {

	private String nomProduit;

	private String categorieProduit;

	private String descriptionProduit;

	private Double prixProduit;

	private int quantiteProduit;

	private String dlcProduit; // Date Limite de Consommation

	private String fournisseurProduit;

	private int promoProduit;
	
	private Boolean activeProduit;
	
	
	
	private int nombreProduitPanier;
	private Double totalProduitPanier;
	private int indexPersonPanier;

	
	
	
	public ProduitMarketOuf() {
		
	}
	
	// Constructeur panier
	
	public ProduitMarketOuf(int indexPersonPanier, String nomProduit, Double prixProduit, String categorieProduit
			, int promoProduit, int nombreProduitPanier, Double totalProduitPanier) {
		
		this.indexPersonPanier = indexPersonPanier;
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
		this.categorieProduit = categorieProduit;
		this.promoProduit = promoProduit;
		this.nombreProduitPanier = nombreProduitPanier;
		this.totalProduitPanier =((prixProduit - (prixProduit * (promoProduit / 100)))* nombreProduitPanier);;
		
	}
	
	
	
	
	public ProduitMarketOuf(String nomProduit, Double prixProduit, String categorieProduit, String descriptionProduit,
			int quantiteProduit, String dlcProduit, int promoProduit, String fournisseurProduit, Boolean activeProduit) {
		
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
		this.categorieProduit = categorieProduit;
		this.descriptionProduit = descriptionProduit;
		this.quantiteProduit = quantiteProduit;
		this.dlcProduit = dlcProduit;
		this.promoProduit = promoProduit;
		this.fournisseurProduit = fournisseurProduit;
		this.activeProduit = activeProduit;
		
	}

	// Getters Setters
	
	
	public int getIndexPersonPanier() {
		return indexPersonPanier;
	}
	
	public void setIndexPersonPanier(int indexPersonPanier) {
		this.indexPersonPanier = indexPersonPanier;
	}
	
	public int getNombreProduitPanier() {
		return nombreProduitPanier;
	}

	public Double getTotalProduitPanier() {
		return totalProduitPanier;
	}

	public void setTotalProduitPanier(Double totalProduitPanier) {
		this.totalProduitPanier = totalProduitPanier;
	}

	public void setNombreProduitPanier(int nombreProduitPanier) {
		this.nombreProduitPanier = nombreProduitPanier;
	}
	

	public String getNomProduit() {
		return nomProduit;
	}


	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}


	public String getCategorieProduit() {
		return categorieProduit;
	}


	public void setCategorieProduit(String categorieProduit) {
		this.categorieProduit = categorieProduit;
	}


	public String getDescriptionProduit() {
		return descriptionProduit;
	}


	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}


	public Double getPrixProduit() {
		return prixProduit;
	}


	public void setPrixProduit(Double prixProduit) {
		this.prixProduit = prixProduit;
	}


	public int getQuantiteProduit() {
		return quantiteProduit;
	}


	public void setQuantiteProduit(int quantiteProduit) {
		this.quantiteProduit = quantiteProduit;
	}


	public String getDlcProduit() {
		return dlcProduit;
	}


	public void setDlcProduit(String dlcProduit) {
		this.dlcProduit = dlcProduit;
	}



	public String getFournisseurProduit() {
		return fournisseurProduit;
	}


	public void setFournisseurProduit(String fournisseurProduit) {
		this.fournisseurProduit = fournisseurProduit;
	}


	
	public int getPromoProduit() {
		return promoProduit;
	}


	public void setPromoProduit(int promoProduit) {
		this.promoProduit = promoProduit;
	}


	public Boolean getActiveProduit() {
		return activeProduit;
	}


	public void setActiveProduit(Boolean activeProduit) {
		this.activeProduit = activeProduit;
	}


	public String infoProduitAdmin () {
		return nomProduit + " \n "
				+ prixProduit + " € | "
				+ categorieProduit + " | "
				+ descriptionProduit + " | Qte : "
				+ quantiteProduit + " | Dlc :"
				+ dlcProduit + "\n Promo : "
				+ promoProduit + " % | "
				+ fournisseurProduit + " | "
				+ "Actif : " + activeProduit +" ";
		
	}
	
	
	
	public String infoProduitUser () {
		
		if (getQuantiteProduit() <= 0) {
			
			return nomProduit + " \n Prix : "
					+ prixProduit + " € \nCatégorie : "
					+ categorieProduit + "\nDescription : "
					+ descriptionProduit + "\n"
					+ "Quantité : " + quantiteProduit
					+ "\nPromo : " + promoProduit + "%"
					+ "\nRupture de stock.";
			
		}
		
		return nomProduit + " \n Prix : "
				+ prixProduit + " € \nCatégorie : "
				+ categorieProduit + "\nDescription : "
				+ descriptionProduit + "\n"
				+ "Quantité : " + quantiteProduit
				+ "\nPromo : " + promoProduit + "%"
				+ "\nEn stock.";
		
	}
	
	
	 public String infoProduitPanier () {
		 
		 
		return nomProduit + "\n  "
				+ prixProduit + " €\n  "
				+ categorieProduit + "\n  "
				+ promoProduit + " %\n  "
				+ nombreProduitPanier + "\n  Total : "
				+ totalProduitPanier + "\n  (promotion appliquée)";
		
	}
	
	
	
	
	

}
