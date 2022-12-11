package repairmatching.domain;

import java.util.stream.Stream;

public enum Course {
    BACK("백엔드"),
    FRONT("프론트엔드");

    private final String course;

    Course(String course) {
        this.course = course;
    }

    public static Course find(String course) {
        return Stream.of(values())
                .filter(v -> v.course.equals(course))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("코스를 확인해주세요.");
                });
    }

    public String getCourse() {
        return course;
    }

    public boolean isEqual(String course) {
        return this.course.equals(course);
    }
}
