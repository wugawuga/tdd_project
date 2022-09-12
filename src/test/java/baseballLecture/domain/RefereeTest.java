package baseballLecture.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RefereeTest {
	private Referee referee;
	private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);

	@BeforeEach
	void setUp() {
		referee = new Referee();
	}

	@ParameterizedTest
	@CsvSource({"1,2,3,0 볼 3 스트라이크", "4,5,6,낫싱", "3,1,2,3 볼 0 스트라이크", "1,3,2,2 볼 1 스트라이크"})
	public void compare(int number1, int number2, int number3, String expected) {
		String actual = referee.compare(ANSWER, Arrays.asList(number1, number2, number3));
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void 스트라이크3() {
		String result = referee.compare(ANSWER, Arrays.asList(1, 2, 3));
		assertThat(result).isEqualTo("0 볼 3 스트라이크");
	}

	@Test
	void 낫싱() {
		String result = referee.compare(ANSWER, Arrays.asList(4, 5, 6));
		assertThat(result).isEqualTo("낫싱");
	}

	@Test
	void 볼3() {
		String result = referee.compare(ANSWER, Arrays.asList(3, 1, 2));
		assertThat(result).isEqualTo("3 볼 0 스트라이크");
	}

	@Test
	void 볼2_스트라이크1() {
		String result = referee.compare(ANSWER, Arrays.asList(1, 3, 2));
		assertThat(result).isEqualTo("2 볼 1 스트라이크");
	}
}
