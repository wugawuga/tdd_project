package vendingmachine.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputMoney() {
        String input = input();
        return changeInt(input);
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
