package ilu2;

import java.util.ArrayList;

public class Welcome {
	private static String conv;
	
	public static String welcome(String input) {
		if(input == null || input.trim().equals("")) {
			conv = "Hello, my friend";
		}else {
			final String[] tabNoms = input.split(",");
			if (tabNoms.length == 1) {
				conv = minOrMajHello(input);
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
	private static String minOrMajHello(String nom) {
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
	private static String concatPlusieurNoms(final String[] tabNoms) {
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
	private static String testToStrReturn(StringBuilder helloMin, StringBuilder helloMaj, ArrayList<String> tabMin,
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
	private static void prepHelloMin(StringBuilder helloMin, ArrayList<String> tabMin) {
		if(tabMin.size() > 0) {
			for (int i = 0; i < tabMin.size(); i++) {
				if(i == tabMin.size() - 1 && tabMin.size() != 1) {
					helloMin.append(" and ");
				}
				if(tabMin.get(i)!= "my friend") {
					helloMin.append(tabMin.get(i).substring(0, 1).toUpperCase() + tabMin.get(i).substring(1)) ;
				} else {
					helloMin.append(tabMin.get(i));
				}
				if(i < tabMin.size() - 2) {
					helloMin.append(", ");
				}
			}
		}
	}

	/**
	 * @param helloMaj
	 * @param tabMaj
	 */
	private static void prepHelloMaj(StringBuilder helloMaj, ArrayList<String> tabMaj) {
		if(tabMaj.size() > 0) {
			for (int i = 0; i < tabMaj.size(); i++) {
				if(i == tabMaj.size() - 1 && tabMaj.size() != 1) {
					helloMaj.append(" AND ");
				}
				helloMaj.append(tabMaj.get(i));
				if(i < tabMaj.size() - 2) {
					helloMaj.append(", ");
				}
			}
		}
	}
	
	
	/**
	 * @param tab
	 * @return
	 */
	private static ArrayList<String> extractTabToMajTab(String[] tab) {
		ArrayList<String> tabMaj = new ArrayList<String>();
		for(int i = 0;i < tab.length ;i++) {
			if(tab[i].equals(tab[i].toUpperCase())){
				if(!tab[i].trim().equals("")) {
					tabMaj.add(tab[i].trim());
				}
			}

		}
		return tabMaj;
	}

	/**
	 * @param tab
	 * @return
	 */
	private static ArrayList<String> extractTabToMinTAb(String[] tab) {
		ArrayList<String> tabMin = new ArrayList<String>();
		for(int i = 0;i < tab.length ;i++) {
			if(!tab[i].equals(tab[i].toUpperCase())){
				tabMin.add(tab[i].trim());
			}
			if(tab[i].trim().equals(""))
				tabMin.add("my friend");
		}
		return tabMin;
	}
	
}

