package baseball;

public class Printer {

    private final String INPUTANSWER = "정답을 입력하세요 : ";
    private final String RESTARTOREND = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String END = "게임 종료";

    public void inputAnswer() {
        System.out.print(INPUTANSWER);
    }

    public void restartEnd() {
        System.out.println(RESTARTOREND);
    }

    public void end() {
        System.out.println(END);
    }

    public void printResult(String gameResult) {
        System.out.println(gameResult);
    }
}
