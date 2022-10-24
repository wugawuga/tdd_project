package pairmatching;

import static pairmatching.Options.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {

	private static final List<String> backendCrews = FileReader.read("backend-crew.md");
	private static final List<String> frontedCrews = FileReader.read("frontend-crew.md");

	public static void main(String[] args) {
		Matching matching = new Matching(backendCrews, frontedCrews);
		boolean programFlag = true;

		while (programFlag) {
			Print.options();
			String input = validInput(Console.readLine());
			if (input.equals(QUIT)) {
				programFlag = false;
			}
			matching.selectOption(input);
		}
	}

	private static String validInput(String input) {
		try {
			catchError(input);
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + CONTROL_LIST + " 중에 입력하세요.");
		}
		return input;
	}

	private static void catchError(String input) {
		if (!CONTROL_LIST.contains(input)) {
			throw new IllegalArgumentException();
		}
	}
}
