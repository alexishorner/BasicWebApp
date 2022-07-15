package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class QueryProcessorTest {

	private final QueryProcessor queryProcessor = new QueryProcessor();

	@Test
	void testEmptyStringIfCannotProcessQuery() {
		assertEquals("", queryProcessor.process("test"));
	}

	@Test
	void testKnowsAboutShakespeare() {
		String actual = queryProcessor.process("Shakespeare");
		if (!actual.contains("playwright")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}

	@Test
	void isNotCaseSensitive() {
		String actual = queryProcessor.process("shakespeare");
		if (!actual.contains("playwright")) {
			fail("Your QueryProcessor should not be case sensitive.");
		}
	}

	@Test
	void testLargestNumber() {
		String ret = queryProcessor.process("%20which%20of%20the%20following%20numbers%20is%20the%20largest:%2079,%20675,%2024,%2033");
		int actual = Integer.parseInt(ret);
		assertEquals(20675, actual);
	}

	@Test
	void testAddNumbers() {
		int a = 2016;
		int b = 200;
		int expected = a + b;
		String ret = queryProcessor.process("1a073e90:%20what%20is%" + a + "%20plus%" + b);
		int actual = Integer.parseInt(ret);
		assertEquals(expected, actual);
	}
}
