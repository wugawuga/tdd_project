package finalpairmatching;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String command() {
        return Console.readLine();
    }

    public String[] matchingCondition() {
        String input = Console.readLine();
        checkSeparator(input);
        return input.split(", ");
    }

    public String rematchCommand() {
        return Console.readLine();
    }

    private void checkSeparator(String input) {
        if (!input.contains(", ")) {
            throw new IllegalArgumentException("[ERROR] 예시대로 입력해 주세요. ex) 백엔드, 레벨, 자동차경주");
        }
    }
}
