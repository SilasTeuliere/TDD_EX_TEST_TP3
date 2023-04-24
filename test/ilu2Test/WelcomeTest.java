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
		assertEquals("Hello, Bob", str.conversation("Bob"));
	}
	
	@Test
	void respond_vide_blanc_espace() {
		assertEquals("Hello, my friend", str.conversation(""));
		assertEquals("Hello, my friend", str.conversation("    "));
		assertEquals("Hello, my friend", str.conversation(null));
	}
}
