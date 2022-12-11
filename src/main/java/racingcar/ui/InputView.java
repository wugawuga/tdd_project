package racingcar.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    public List<String> participate() {
        String input = sc.nextLine();
        checkSeparator(input);
        return Arrays.stream(input.split(SEPARATOR)).collect(Collectors.toList());
    }

    public int number() {
        String input = sc.nextLine();
        return changeNumber(input);
    }

    private void checkSeparator(String input) {
        if (!input.contains(SEPARATOR)) {
            throw new IllegalArgumentException("구분자 (,) 를 넣어주세요.");
        }
    }

    private int changeNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
