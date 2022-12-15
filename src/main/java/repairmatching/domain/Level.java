package repairmatching.domain;

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

    public static Level find(String name) {
        return Stream.of(values())
                .filter(v -> v.name.equals(name))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("레벨을 확인해주세요.");
                });
    }

    public boolean isEqual(String name) {
        return this.name.equals(name);
    }
}
