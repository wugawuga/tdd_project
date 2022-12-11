package racingcar.domain;

import java.util.Objects;
import racingcar.service.MoveStrategy;

public class Car implements Comparable<Car> {
    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(MoveStrategy strategy) {
        if (strategy.movable()) {
            position = position.increase();
        }
    }

    public boolean isWin(Car winner) {
        return this.position.equals(winner.position);
    }

    public String printName() {
        return name.toString();
    }

    public Position printPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public int compareTo(Car other) {
        return this.position.compareTo(other.position);
    }
}
