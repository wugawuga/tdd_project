package finalpairmatching.domain;

import java.util.stream.Stream;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course findCourse(String name) {
        return Stream.of(values())
                .filter(course -> course.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 백엔드, 프론트엔드만 가능해요"));
    }

    public boolean checkCourse(String course) {
        return name.equals(course);
    }
}
