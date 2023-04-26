package ilu2;

import java.util.ArrayList;

public class Welcome {
	private String conv;
	
	public String conversation(String nom) {
		if(nom == null || nom.trim().equals("")) {
			conv = "Hello, my friend";
		}else {
			final String[] tabNoms = nom.split(",");
			if (tabNoms.length == 1) {
				conv = minOrMajHello(nom);
			}else {
				conv = concatPlusieurNoms(tabNoms);
			}
		}
		return conv;
	}

	/**
	 * Cette methode regarde si le nom est crié ou non pour repondre en criant ou non
	 * @param nom
	 * @return
	 */
	private String minOrMajHello(String nom) {
		nom = nom.substring(0, 1).toUpperCase() + nom.substring(1);
		if(nom.equals(nom.toUpperCase())) {
			conv = "HELLO, " + nom + " !";
		}else {
			conv = "Hello, " + nom;
		}
		return conv;
	}

	/**
	 * Cette methode concatene plusieurs noms
	 * @param tabNoms
	 * @return
	 */
	private String concatPlusieurNoms(final String[] tabNoms) {
		StringBuilder helloMin = new StringBuilder("Hello, ");
		StringBuilder helloMaj = new StringBuilder("HELLO, ");
		String strReturn = "";
		ArrayList<String> tabMin = extractTabToMinTAb(tabNoms);
		ArrayList<String> tabMaj = extractTabToMajTab(tabNoms);
		prepHelloMaj(helloMaj, tabMaj);
		prepHelloMin(helloMin, tabMin);
		strReturn = testToStrReturn(helloMin, helloMaj, tabMin, tabMaj);
		return strReturn;
	}

	/**
	 * @param helloMin
	 * @param helloMaj
	 * @param tabMin
	 * @param tabMaj
	 * @return
	 */
	private String testToStrReturn(StringBuilder helloMin, StringBuilder helloMaj, ArrayList<String> tabMin,
			ArrayList<String> tabMaj) {
		String strReturn;
		if(tabMaj.size() > 0 && tabMin.size() > 0) {
			helloMin.append(". AND ");
		}
		if(tabMaj.size() > 0) {
			helloMaj.append(" !");
			if (tabMin.size() > 0)
				strReturn = helloMin.append(helloMaj).toString();
			else {
				strReturn = helloMaj.toString();
			}
		}else {
			strReturn = helloMin.toString();
		}
		return strReturn;
	}

	/**
	 * @param plusieurNoms
	 * @param tabMin
	 */
	private void prepHelloMin(StringBuilder helloMin, ArrayList<String> tabMin) {
		if(tabMin.size() > 0) {
			for (int i = 0; i < tabMin.size(); i++) {
				helloMin.append(tabMin.get(i).substring(0, 1).toUpperCase() + tabMin.get(i).substring(1)) ;
				if(i < tabMin.size() - 1) {
					helloMin.append(", ");
				}
			}
		}
	}

	/**
	 * @param helloMaj
	 * @param tabMaj
	 */
	private void prepHelloMaj(StringBuilder helloMaj, ArrayList<String> tabMaj) {
		if(tabMaj.size() > 0) {
			for (int i = 0; i < tabMaj.size(); i++) {
				helloMaj.append(tabMaj.get(i));
				if(i < tabMaj.size() - 1) {
					helloMaj.append(", ");
				}
			}
		}
	}
	
	
	/**
	 * @param tab
	 * @return
	 */
	private ArrayList<String> extractTabToMajTab(String[] tab) {
		ArrayList<String> tabMaj = new ArrayList<String>();
		for(int i = 0;i < tab.length ;i++) {
			if(tab[i].equals(tab[i].toUpperCase())){
				tabMaj.add(tab[i]);
			}
		}
		return tabMaj;
	}

	/**
	 * @param tab
	 * @return
	 */
	private ArrayList<String> extractTabToMinTAb(String[] tab) {
		ArrayList<String> tabMin = new ArrayList<String>();
		for(int i = 0;i < tab.length ;i++) {
			if(!tab[i].equals(tab[i].toUpperCase())){
				tabMin.add(tab[i]);
			}
		}
		return tabMin;
	}
	
}

