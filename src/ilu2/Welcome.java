package ilu2;

public class Welcome {
	
	public String conversation(String nom) {
		if(nom == null || nom.trim().equals("")) {
			nom = "my friend";
		}
		return "Hello, "+ nom;
	}
}
