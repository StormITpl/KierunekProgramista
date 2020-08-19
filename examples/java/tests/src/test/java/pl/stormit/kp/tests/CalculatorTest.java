package pl.stormit.kp.tests;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

	@Test
	public void shouldAddTwoIntegers() {
		// given
		int a = 1;
		int b = 3;
		Calculator calculator = new Calculator();

		// when
		int result = calculator.add(a, b);

		// then
		assertThat(result).isEqualTo(4);
	}
}