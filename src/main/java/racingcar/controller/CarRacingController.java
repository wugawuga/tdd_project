package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.CarFactory;
import racingcar.service.ExceptionTemplate;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class CarRacingController implements GameController {
    private final OutputView output = new OutputView();
    private final InputView input = new InputView();
    private final CarFactory factory = new CarFactory();

    @Override
    public void start() {
        Cars cars = makeCars();
        int tryCount = howManyTryMove();
        output.newLine();
        play(cars, tryCount);
        findWinner(cars);
    }

    private void findWinner(Cars cars) {
        Cars winners = cars.findWinner();
        output.winner(winners);
    }

    private void play(Cars cars, int tryCount) {
        output.result();
        for (int i = 0; i < tryCount; i++) {
            cars.move();
            output.gameResult(cars);
        }
    }

    private int howManyTryMove() {
        output.tryCount();
        ExceptionTemplate exception = input::number;
        return (int) exception.check();
    }

    private Cars makeCars() {
        output.participate();
        ExceptionTemplate exception = () -> factory.makeCars(input.participate());
        return (Cars) exception.check();
    }
}
