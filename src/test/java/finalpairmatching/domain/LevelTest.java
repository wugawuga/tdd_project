package finalpairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LevelTest {

    @Test
    @DisplayName("존재하지 않는 레벨일때 예외")
    void valdiateLevel() {
        assertThatThrownBy(() -> Level.findLevel("레벨6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("존재하는 레벨일때 확인")
    @CsvSource(value = {
            "레벨1,LEVEL1",
            "레벨2,LEVEL2",
            "레벨3,LEVEL3",
            "레벨4,LEVEL4",
            "레벨5,LEVEL5"
    })
    void returnLevel(String name, Level level) {
        assertThat(Level.findLevel(name)).isEqualTo(level);
    }

    @Test
    @DisplayName("레벨 체크 확인")
    void checkLevel() {
        Level level = Level.findLevel("레벨1");

        assertThat(level.checkLevel("레벨1")).isTrue();
        assertThat(level.checkLevel("레벨2")).isFalse();
    }
}
