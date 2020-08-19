package pl.stormit.kp.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests1 {

	@Test
	void simpleTest() {
		String expected = "XYZ";
		String actual = "XYZ---";

		assertEquals(expected, actual);
	}
}
