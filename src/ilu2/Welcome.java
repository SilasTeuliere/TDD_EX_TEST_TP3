package ilu2;

public class Welcome {
	private String conv;
	
	public String conversation(String nom) {
		if(nom == null || nom.trim().equals("")) {
			conv = "Hello, my friend";
		}
		else if(nom.equals(nom.toUpperCase())) {
			conv = "HELLO, " + nom + " !";
		}
		else {
			conv = "Hello, " + nom;
		}
		return conv;
	}
}

