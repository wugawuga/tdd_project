package baseball;

public class Game {

    private final GameStatus status = new GameStatus();

    public Game(int[] answer, int[] userAnswer) {
        compareAnswerToUserAnswer(answer, userAnswer);
    }

    private void compareAnswerToUserAnswer(int[] answer, int[] userAnswer) {
        for (int i = 0; i < 3; i++) {
            checkMatching(answer, userAnswer, i);
        }
    }

    private void checkMatching(int[] answer, int[] userAnswer, int index) {
        for (int j = 0; j < 3; j++) {
            checkMatch(answer[index], userAnswer[j], index, j);
        }
    }

    private void checkMatch(int computer, int user, int i, int j) {
        if (user == computer) {
            checkBallOrStrike(i, j);
        }
    }

    private void checkBallOrStrike(int i, int j) {
        if (i == j) {
            status.strike();
            return;
        }
        status.ball();
    }

    public String gameResult() {
        return this.status.toString();
    }

    public boolean win() {
        return status.strikeStatus() == 3;
    }

    public boolean againGame(Player player, Printer printer) {
        String goStop = player.writeAnswer();
        if (goStop.equals("1")) {
            return true;
        }
        if (goStop.equals("2")) {
            printer.end();
            return false;
        }
        return false;
    }
}
