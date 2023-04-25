package ilu2;

public class Welcome {
	private String conv;
	
	public String conversation(String nom) {
		if(nom == null || nom.trim().equals("")) {
			nom = "my friend";
		} else {
			nom = nom.substring(0, 1).toUpperCase() + nom.substring(1);
		}
		final String[] tabNoms = nom.split(",");
		if(tabNoms.length >= 2) {
			nom = concatPlusieurNoms(tabNoms);
		}
		if(nom.equals(nom.toUpperCase())) {
			conv = "HELLO, " + nom + " !";
		}
		else {
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
		StringBuilder plusieurNoms = new StringBuilder();
		for (int i = 0; i < tabNoms.length; i++) {
			plusieurNoms.append(tabNoms[i].substring(0, 1).toUpperCase() + tabNoms[i].substring(1)) ;
			if(i < tabNoms.length - 1) {
				plusieurNoms.append(", ");
			}
		}
		return plusieurNoms.toString();
	}
}

