package racingcar;

import racingcar.controller.CarRacingController;
import racingcar.controller.GameController;

public class MainApplication {
    public static void main(String[] args) {
        GameController game = new CarRacingController();
        game.start();
    }
}
