package baseball;

public class Game {

    GameStatus status = new GameStatus();

    public Game(int[] answer, int[] userAnswer) {
        compareAnswerToUserAnswer(answer, userAnswer);
    }

    private void compareAnswerToUserAnswer(int[] answer, int[] userAnswer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checkMatch(answer[i], userAnswer[j], i, j);
            }
        }
    }

    private void checkMatch(int computer, int user, int i, int j) {
        if (user == computer) {
            if (i == j) {
                status.strike();
            } else {
                status.ball();
            }
        }
    }

    public String gameResult() {
        return this.status.toString();
    }

}
