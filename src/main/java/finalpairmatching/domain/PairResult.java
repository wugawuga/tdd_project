package finalpairmatching.domain;

import java.util.List;

public class PairResult {
    private final Course course;
    private final Level level;
    private final Mission mission;
    private List<String> shuffleCrews;

    public PairResult(String[] conditions, List<String> crews) {
        Mission initMission = null;
        this.course = Course.findCourse(conditions[0]);
        this.level = Level.findLevel(conditions[1]);
        if (!checkLevel(conditions[1])) {
            initMission = Mission.findMission(conditions[2]);
        }
        this.mission = initMission;
        shuffleCrews = crews;
    }

    private boolean checkLevel(String condition) {
        return condition.equals("레벨3") || condition.equals("레벨5");
    }

    public List<String> printShuffle() {
        return shuffleCrews;
    }

    public PairResult find(String[] conditions) {
        if (this.course.checkCourse(conditions[0]) && this.level.checkLevel(conditions[1]) && this.mission.checkMission(
                conditions[2])) {
            return this;
        }
        return null;
    }

    public PairResult findThreeOrFiveLevel(String[] conditions) {
        if (this.course.checkCourse(conditions[0]) && this.level.checkLevel(conditions[1]) && this.mission == null) {
            return this;
        }
        return null;
    }
}
