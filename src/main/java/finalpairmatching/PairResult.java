package finalpairmatching;

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
}
