package finalpairmatching.domain;

import java.util.stream.Stream;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public static Level findLevel(String levelName) {
        return Stream.of(values())
                .filter(level -> level.name.equals(levelName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 레벨을 확인해주세요"));
    }

    public boolean checkLevel(String level) {
        return name.equals(level);
    }
}
