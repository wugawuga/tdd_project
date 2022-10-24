package baseball;

public class GameController {

    private boolean flag = true;
    private final Player player = new Player(); // 유저 클래스 -> 정답 입력
    private final Printer printer = new Printer();

    public void start() {
        playGameByUser(Computer.makeAnswer());
    }

    private void playGameByUser(int[] answer) {
        while (flag) {
            printer.inputAnswer();

            CheckInput check = new CheckInput(player.writeAnswer()); // 체크인풋 클래스 -> 유저입력 체크

            Game playGame = new Game(answer, check.finishCheck());
            printer.printResult(playGame.gameResult());
            if (playGame.win()) {
                printer.restartEnd();
                flag = playGame.againGame(player, printer);
            }
        }
    }

}
