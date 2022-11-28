package vendingmachine.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputMoney() {
        String input = input();
        return changeInt(input);
    }

    public String[] beverages() {
        String input = input();
        checkSeparator(input);
        input = input.replaceAll("[\\[\\]]", "");
        return input.split(";");
    }

    private void checkSeparator(String input) {
        if (!input.contains(";")) {
            throw new IllegalArgumentException("[ERROR] 구분자 ';' 를 넣어주세요");
        }
    }

    private int changeInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            OutputView.printError("[ERROR] 숫자를 입력해주세요");
            return inputMoney();
        }
    }

    private String input() {
        return Console.readLine();
    }
}
