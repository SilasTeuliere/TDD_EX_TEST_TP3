package ilu2Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ilu2.Welcome;

class WelcomeTest {
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void respond_Bob() {
		assertEquals("Hello, Bob", Welcome.welcome("bob"));
	}
	
	@Test
	void respond_vide_blanc_espace() {
		assertEquals("Hello, my friend", Welcome.welcome(""));
		assertEquals("Hello, my friend", Welcome.welcome("    "));
		assertEquals("Hello, my friend", Welcome.welcome(null));
	}
	
	@Test
	void respond_majuscule() {
		assertEquals("HELLO, JAMES !", Welcome.welcome("JAMES"));
	}
	
	@Test
	void respond_deux_noms() {
		assertEquals("Hello, Bob and Amy", Welcome.welcome("bob,amy"));
		assertEquals("Hello, James and Patrick", Welcome.welcome("James,patrick"));
	}
	
	@Test
	void respond_plusieur_noms() {
		assertEquals("Hello, Bob, Amy and Richard", Welcome.welcome("bob,amy,richard"));
		assertEquals("Hello, James, Patrick and Jerry", Welcome.welcome("James,patrick,Jerry"));
	}
	
	@Test
	void respond_plusieur_noms_maj() {
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !", Welcome.welcome("Amy,BOB,Jerry"));
		assertEquals("HELLO, AMY, BOB AND JERRY !", Welcome.welcome("AMY,BOB,JERRY"));
		assertEquals("Hello, Amy, Bob and Jerry", Welcome.welcome("Amy,bob,jerry"));
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB AND TOTO !", Welcome.welcome("Amy,BOB,jerry,TOTO"));
	}
	
	@Test
	void respond_plusieur_noms_and() {
		assertEquals("Hello, Bob, Amy and Jerry", Welcome.welcome("bob,amy,Jerry"));
		assertEquals("HELLO, AMY, BOB AND JERRY !", Welcome.welcome("AMY,BOB,JERRY"));
		assertEquals("Hello, Bob and Jean. AND HELLO, AMY AND JERRY !", Welcome.welcome("AMY,bob,JERRY,jean"));
	}
	
	@Test
	void respond_plusieur_noms_vide() {
		assertEquals("Hello, Amy, Bob and Jerry", Welcome.welcome("Amy    ,  bob,  jerry  "));
		assertEquals("Hello, my friends", Welcome.welcome("  ,  "));
		assertEquals("Hello, my friends", Welcome.welcome("  ,, "));
	}
	
	@Test
	void respond_plusieur_noms_occurence() {
		assertEquals("Hello, Bob (x3) and Amy. AND HELLO, JERRY (x3) !", Welcome.welcome("bob,JERRY,bob,amy,bob,JERRY,JERRY"));
		assertEquals("Hello, Bob (x2) and Amy. AND HELLO, JERRY (x2) AND BOB !", Welcome.welcome("bob,JERRY, BOB,amy,bob,JERRY"));
		assertEquals("Hello, Bob (x2) and Amy (x3)", Welcome.welcome("bob,amy, bob,amy,amy"));
	}
	
	@Test
	void respond_plusieur_noms_YODA() {
		assertEquals("Bob, Yoda and Amy, Hello. AND HELLO, JERRY !", Welcome.welcome(" bob,yoda, amy, JERRY,"));
		assertEquals("Hello, Bob and Amy. AND YODA (x2) AND JERRY, HELLO !", Welcome.welcome("bob, YODA, amy, JERRY, YODA"));
		assertEquals("Bob, Amy and Yoda, Hello. AND YODA (x2) AND JERRY, HELLO !", Welcome.welcome("bob, YODA, amy, JERRY, YODA,yoda"));
		assertEquals("Hello, Bob, Amy and Yod. AND YODA (x2) AND JERRY, HELLO !", Welcome.welcome("bob, YODA, amy, JERRY, YODA,yod"));
		assertEquals("Bob, Amy, my friend and Yoda (x2), Hello. AND YODA AND JERRY, HELLO !", Welcome.welcome("bob, YODA, amy, JERRY, ,yoda,Yoda"));
	}
	
}
