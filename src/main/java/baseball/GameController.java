package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {

    boolean flag = true;

    public void start() {
        Computer computer = new Computer(); // 컴퓨터 클래스 -> 정답 생성
        int[] answer = computer.makeAnswer();
        playGameByUser(answer);
    }

    private void playGameByUser(int[] answer) {
        while (flag) {
            Player player = new Player(); // 유저 클래스 -> 정답 입력
            System.out.print("정답을 입력하세요 : ");
            String playerAnswer = player.writeAnswer();

            CheckInput check = new CheckInput(playerAnswer); // 체크인풋 클래스 -> 유저입력 체크
            int[] playerAnswerToArray = check.finishCheck(); // 유저 정답 -> 배열
            Game playGame = new Game(answer, playerAnswerToArray);
            String result = playGame.gameResult();
            System.out.println(result);
            if (result.equals("3스트라이크")) {
                againGame();
            }
        }
    }

    private void againGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String goStop = Console.readLine();
        if (goStop.equals("1")) {
            start();
        }
        if (goStop.equals("2")) {
            System.out.println("게임 종료");
            flag = false;
        }
    }

}
