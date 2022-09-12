package baseballLecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import baseballLecture.domain.Judgment;
import baseballLecture.domain.NumberGenerator;
import baseballLecture.domain.Referee;

/**
 * 객체 지향 프로그래밍
 *	1. 기능을 가지고 있는 클래스를 인스턴스(객체)화 한다
 *	2. 필요한 기능을 각 인스턴스가 수행하게 한다
 *	3. 각 결과를 합친다
 */

public class Application {
	public static void main(String[] args) {
		NumberGenerator generator = new NumberGenerator();
		List<Integer> computer = generator.createRandomNumbers();

		Referee referee = new Referee();

		String result = "";
		while (!result.equals("0 볼 3 스트라이크")) {
			result = referee.compare(computer, askNumbers());
			System.out.println(result);
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public static List<Integer> askNumbers() {
		System.out.println("숫자를 입력해 주세요 : ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();

		List<Integer> numbers = new ArrayList<>();
		for (String number : input.split("")) {
			numbers.add(Integer.valueOf(number));
		}
		return numbers;
	}
}
