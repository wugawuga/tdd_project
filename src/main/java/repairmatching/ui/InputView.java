package repairmatching.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String command() {
        return input();
    }

    public static String[] choice() {
        String input = input();
        validateSeparator(input);
        String deletedBlankInput = input.replaceAll(" ", "");
        return deletedBlankInput.split(",");
    }

    public static String reMatch() {
        return input();
    }

    private static void validateSeparator(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("구분자 (,) 넣어주세요.");
        }
    }

    private static String input() {
        return Console.readLine();
    }

    private InputView() {
    }
}
