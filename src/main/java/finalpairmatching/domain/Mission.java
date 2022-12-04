package finalpairmatching.domain;

import static finalpairmatching.domain.Level.LEVEL1;
import static finalpairmatching.domain.Level.LEVEL2;
import static finalpairmatching.domain.Level.LEVEL4;

import java.util.stream.Stream;

public enum Mission {
    CAR(LEVEL1, "자동차경주"),
    LOTTO(LEVEL1, "로또"),
    BASEBALL(LEVEL1, "숫자야구게임"),
    CART(LEVEL2, "장바구니"),
    PAYMENT(LEVEL2, "결제"),
    SUBWAY(LEVEL2, "지하철노선도"),
    PERFORMANCE_IMPROVEMENT(LEVEL4, "성능개선"),
    RELEASE(LEVEL4, "배포");

    private Level level;
    private String mission;

    Mission(Level level, String mission) {
        this.level = level;
        this.mission = mission;
    }

    public static Mission findMission(String mission) {
        return Stream.of(values())
                .filter(value -> value.mission.equals(mission))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 미션을 확인해주세요"));
    }

    public boolean checkMission(String mission) {
        return mission.equals(mission);
    }
}
