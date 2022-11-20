package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("첫 포지션 디폴트 1")
    void initPosition() {
        Position actual = new Position();

        assertThat(actual).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("포지션 증가 확인")
    void checkIncrease() {
        Position actual = new Position();

        actual = actual.increase();

        assertThat(actual).isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("포지션 확인")
    void checkPosition() {
        Position actual = new Position();

        assertThat(actual.toString()).isEqualTo("1");
    }
}
