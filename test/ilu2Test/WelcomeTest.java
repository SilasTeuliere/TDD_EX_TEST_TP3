package ilu2Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ilu2.Welcome;

class WelcomeTest {
	
	private Welcome str;
	
	@BeforeEach
	void setUp() throws Exception {
		str = new Welcome();
	}

	@Test
	void respond_Bob() {
		assertEquals("Hello, Bob", str.conversation("bob"));
	}
	
	@Test
	void respond_vide_blanc_espace() {
		assertEquals("Hello, my friend", str.conversation(""));
		assertEquals("Hello, my friend", str.conversation("    "));
		assertEquals("Hello, my friend", str.conversation(null));
	}
	
	@Test
	void respond_majuscule() {
		assertEquals("HELLO, JAMES !", str.conversation("JAMES"));
	}
	
	@Test
	void respond_deux_noms() {
		assertEquals("Hello, Bob, Amy", str.conversation("bob,amy"));
		assertEquals("Hello, James, Patrick", str.conversation("James,patrick"));
	}
	
	@Test
	void respond_plusieur_noms() {
		assertEquals("Hello, Bob, Amy, Richard", str.conversation("bob,amy,richard"));
		assertEquals("Hello, James, Patrick, Jerry", str.conversation("James,patrick,Jerry"));
	}
	
	@Test
	void respond_plusieur_noms_maj() {
		assertEquals("Hello, Amy, Jerry. AND HELLO, BOB !", str.conversation("Amy,BOB,Jerry"));
		assertEquals("HELLO, AMY, BOB, JERRY !", str.conversation("AMY,BOB,JERRY"));
		assertEquals("Hello, Amy, Bob, Jerry", str.conversation("Amy,bob,jerry"));
		assertEquals("Hello, Amy, Jerry. AND HELLO, BOB, TOTO !", str.conversation("Amy,BOB,jerry,TOTO"));
	}
	
//	@Test
//	void respond_plusieur_noms_and() {
//		assertEquals("Hello, Bob, Amy and Jerry!", str.conversation("bob,amy,Jerry"));
//		assertEquals("HELLO, AMY, BOB AND JERRY !", str.conversation("AMY,BOB,JERRY"));
//		assertEquals("Hello, Bob and Jean. AND HELLO, AMY AND JERRY !", str.conversation("AMY,bob,JERRY,jean"));
//	}
	
//	@Test
//	void respond_plusieur_noms_vide() {
//		assertEquals("Hello, Amy, Bob, Jerry", str.conversation("Amy    ,  bob,  jerry  "));
//	}
	
//	@Test
//	void respond_plusieur_noms_occurence() {
//		assertEquals("Hello, Bob(x3), and Amy. AND HELLO JERRY (x2)", str.conversation("bob,JERRY, bob,amy,bob,JERRY"));
//		assertEquals("Hello, Bob(x2), and Amy. AND HELLO JERRY (x2) AND BOB", str.conversation("bob,JERRY, BOB,amy,bob,JERRY"));
//	}
	
//	@Test
//	void respond_plusieur_noms_YODA() {
//		assertEquals("Bob, Yoda, and Amy, Hello. AND HELLO JERRY", str.conversation(" bob, yoda, amy, JERRY,"));
//		assertEquals("Hello, Bob and Amy. AND YODA (X2) AND JERRY HELLO !", str.conversation("bob, YODA, amy, JERRY, YODA"));
//	}
}
