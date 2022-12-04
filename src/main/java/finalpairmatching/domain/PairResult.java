package finalpairmatching.domain;

import java.util.List;

public class PairResult {
    private final Course course;
    private final Level level;
    private final String mission;
    private List<String> shuffleCrews;

    public PairResult(String course, String level, String mission, List<String> crews) {
        this.course = Course.findCourse(course);
        this.level = Level.findLevel(level);
        this.mission = mission;
        shuffleCrews = crews;
    }

    public List<String> printShuffle() {
        return shuffleCrews;
    }

    public PairResult find(String course, String level, String mission) {
        if (this.course.checkCourse(course) && this.level.checkLevel(level) && this.mission.equals(mission)) {
            return this;
        }
        return null;
    }
}
