package it.demo.mybank;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybankApplicationTests {

	@Test
	void contextLoads() {
	}

	// Azioni a cascata
	/*
	 * Persist, caso 1 -> salvo oggetto transient con dentro un altro oggetto transient collegato
	 * Persist, caso 2 -> leggo un oggetto dal db (stato managed) e aggiungo un oggetto transient
	 * 
	 */

}
