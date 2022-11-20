package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarFactory {
    public Cars makeCars(List<String> participants) {
        List<Car> cars = new ArrayList<>();
        for (String participant : participants) {
            cars.add(new Car(participant));
        }
        return new Cars(cars);
    }
}
