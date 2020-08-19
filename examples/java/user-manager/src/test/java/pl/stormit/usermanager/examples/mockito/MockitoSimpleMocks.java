package pl.stormit.usermanager.examples.mockito;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MockitoSimpleMocks {

	@Test
	void testCreateMock() {
		// given
		List list = Mockito.mock(List.class);

		// when
		list.add("Ala");
		list.clear();

		// then
		Mockito.verify(list).add("Ala");
		Mockito.verify(list).add(ArgumentMatchers.eq("Ala"));
		Mockito.verify(list).add(ArgumentMatchers.any());
		Mockito.verify(list).add(ArgumentMatchers.anyString());
		Mockito.verify(list).clear();
	}

	@Test
	void testMockMethod() {
		List list = Mockito.mock(List.class);
		Mockito.when(list.get(0)).thenReturn("Ala");

		System.out.println(list.get(0));
		System.out.println(list.get(1));

		Assertions.assertThat(list.get(0)).isEqualTo("Ala");
		Assertions.assertThat(list.get(1)).isNull();
	}
}
