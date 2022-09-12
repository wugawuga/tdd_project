package baseballLecture;

import java.util.List;

import baseballLecture.domain.NumberGenerator;

/**
 * 객체 지향 프로그래밍
 *	1. 기능을 가지고 있는 클래스를 인스턴스(객체)화 한다
 *	2. 필요한 기능을 각 인스턴스가 수행하게 한다
 *	3. 각 결과를 합친다
 */

public class Application {
	public static void main(String[] args) {
		final NumberGenerator generator = new NumberGenerator();
		final List<Integer> numbers = generator.createRandomNumbers();
		System.out.println(numbers);
	}
}
