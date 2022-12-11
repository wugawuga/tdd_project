package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 움직임 확인")
    void checkCarMove() {
        Car pobi = new Car("pobi");
        Car wuga = new Car("wuga");

        pobi.move(() -> true);
        wuga.move(() -> false);
        assertThat(pobi.printPosition()).isEqualTo(new Position(2));
        assertThat(wuga.printPosition()).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("우승자 확인")
    void checkCarWinner() {
        Car pobi = new Car("pobi");
        Car wuga = new Car("wuga");
        Car win = new Car("win");

        pobi.move(() -> true);
        wuga.move(() -> false);
        win.move(() -> true);

        assertThat(pobi.isWin(win)).isTrue();
        assertThat(wuga.isWin(win)).isFalse();
    }

    @Test
    @DisplayName("이름 확인")
    void name() {
        Car pobi = new Car("pobi");

        assertThat(pobi.printName()).isEqualTo("pobi");
    }
}
