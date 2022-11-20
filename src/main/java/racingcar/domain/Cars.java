package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.service.MoveStrategy;
import racingcar.service.RandomMoveStrategy;

public class Cars {
    private final List<Car> cars;
    private MoveStrategy strategy;

    public Cars(List<Car> cars) {
        checkCars(cars);
        this.strategy = new RandomMoveStrategy();
        this.cars = cars;
    }

    private void checkCars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("한 대이상 입력해주세요.");
        }
    }

    public void move() {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    public Cars findWinner() {
        Car max = Collections.max(cars);
        return new Cars(cars.stream()
                .filter(car -> car.isWin(max))
                .collect(Collectors.toList()));
    }

    public List<Car> getCars() {
        return cars;
    }
}
