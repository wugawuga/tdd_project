package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

class CarFactoryTest {

    @Test
    @DisplayName("자동차 생성 확인")
    void makeCars() {
        CarFactory factory = new CarFactory();

        Cars actual = factory.makeCars(List.of("a", "b"));

        assertThat(actual.getCars()).isEqualTo(List.of(new Car("a"), new Car("b")));
    }
}
