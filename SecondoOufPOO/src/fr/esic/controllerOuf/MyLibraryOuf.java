package fr.esic.controllerOuf;

import javax.swing.JOptionPane;

public class MyLibraryOuf {
	
	
	public static void afficher(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static String saisie(String msg) {
        return JOptionPane.showInputDialog(msg);
    }
    
    public static int saisieInt(String msg) {
        return Integer.parseInt(JOptionPane.showInputDialog(msg));
    }
    
    public static int convertirInt(String msg) {
        return Integer.parseInt(msg);
    }
    
    public static Double convertirDouble(String msg) {
        return Double.parseDouble(msg);
    }
    
    public static Double saisieDouble(String msg) {
        return Double.parseDouble(JOptionPane.showInputDialog(msg));
    }
    
    public static Boolean saisieBoolean(String msg) {
        return Boolean.parseBoolean(JOptionPane.showInputDialog(msg));
    }
    
    
    
    // Fonctions qui verifie si une saisie est un nombre entier ou double
    public static String checkIntDouble(String check) {

		if (check.isEmpty()) {
			return "non";
		}
		
		if ((check.charAt(0) == '-') && (check.length() == 1)) {
			return "non";
		}
		for (int i = 0; i < check.length(); i++) {

			if ((check.charAt(i) == '1') || (check.charAt(i) == '2') || (check.charAt(i) == '3')
					|| (check.charAt(i) == '4') || (check.charAt(i) == '5') || (check.charAt(i) == '6')
					|| (check.charAt(i) == '7') || (check.charAt(i) == '8') || (check.charAt(i) == '9')
					|| (check.charAt(i) == '0') || ((check.charAt(i) == '-') && (i == 0))
					|| ((check.charAt(i) == '.') && (i != 0)) || ((check.charAt(i) == '.') && (i != check.length()-1 )) ) {
			} 
			else {
				return "non";
			}
		}
		return "oui";
	}
    
    
 // Vérifier la saisie et convertir en Int
    public static int repeterInt(String msg) {
    	
    	String aux;
    	
    	do {
    		
    		aux = JOptionPane.showInputDialog(msg);
    		
    		
    	}while (checkIntDouble(aux) != "oui");
    	
    	
    	return convertirInt(aux);
    }
    
    
    // Vérifier la saisie et convertir en Double
    public static Double repeterDouble(String msg) {
    	
    	String aux;
    	
    	do {
    		
    		aux = JOptionPane.showInputDialog(msg);
    		
    		
    	}while (checkIntDouble(aux) != "oui");
    	
    	
    	return convertirDouble(aux);
    }

}
