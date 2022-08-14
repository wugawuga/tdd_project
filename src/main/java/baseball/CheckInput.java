package baseball;

public class CheckInput {

    private final int NUMBEROFANSWER = 3;

    private int[] answerArray;

    public CheckInput(String playerAnswer) {
        int convertToInteger = convertPlayerAnswerToInteger(playerAnswer);
        this.answerArray = convertPlayerAnswerToArray(convertToInteger);
    }

    public int[] convertPlayerAnswerToArray(int playerAnswer) {
        int[] changeArray = new int[NUMBEROFANSWER];

        for (int i = NUMBEROFANSWER - 1; i >= 0; i--) {
            changeArray[i] = playerAnswer % 10;
            playerAnswer /= 10;
        }

        return changeArray;
    }

    public int convertPlayerAnswerToInteger(String playerAnswer) {
        if (playerAnswer.length() != NUMBEROFANSWER) {
            throw new IllegalArgumentException(NUMBEROFANSWER + "자리를 숫자를 입력하세요");
        }
        try {
            return Integer.parseInt(playerAnswer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBEROFANSWER + "자리를 숫자를 입력하세요");
        }
    }

    public int[] finishCheck() {
        return answerArray;
    }
}
