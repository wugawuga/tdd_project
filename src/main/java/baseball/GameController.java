package baseball;

public class GameController {

    private boolean flag = true;
    private final Player player = new Player(); // 유저 클래스 -> 정답 입력
    private final Printer printer = new Printer();
    private final Computer computer = new Computer(); // 컴퓨터 클래스 -> 정답 생성

    public void start() {
        int[] answer = computer.makeAnswer();
        playGameByUser(answer);
    }

    private void playGameByUser(int[] answer) {
        while (flag) {
            printer.inputAnswer();
            String playerAnswer = player.writeAnswer();

            CheckInput check = new CheckInput(playerAnswer); // 체크인풋 클래스 -> 유저입력 체크
            int[] playerAnswerToArray = check.finishCheck(); // 유저 정답 -> 배열
            Game playGame = new Game(answer, playerAnswerToArray);
            printer.printResult(playGame.gameResult());
            if (playGame.win()) {
                printer.restartEnd();
                flag = playGame.againGame(player, printer);
            }
        }
    }

}
