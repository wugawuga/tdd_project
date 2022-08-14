package baseball;

public class GameStatus {

    private int countOfBall;
    private int countOfStrike;


    public void strike() {
        this.countOfStrike++;
    }

    public void ball() {
        this.countOfBall++;
    }

    @Override
    public String toString() {
        if (countOfBall == 0 && countOfStrike == 0) {
            return "낫싱";
        }
        if (countOfBall != 0 && countOfStrike != 0) {
            return ballString() + " " + strikeString();
        }
        return ballString() + strikeString();
    }

    private String ballString() {
        if (countOfBall == 0) {
            return "";
        }
        return countOfBall + "볼";
    }

    private String strikeString() {
        if (countOfStrike == 0) {
            return "";
        }
        return countOfStrike + "스트라이크";
    }
}
