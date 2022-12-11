package repairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Crews {
    private final Course course;
    private final Level level;
    private List<Crew> crews;

    public Crews(String[] choice) {
        this.course = Course.find(choice[0]);
        this.level = Level.find(choice[1]);
    }

    private List<String> shuffleCrew(Map<String, List<String>> crews) {
        List<String> crewsByCourse = crews.get(course.getCourse());
        return Randoms.shuffle(crewsByCourse);
    }

    public void makeCrews(Map<String, List<String>> crews) {
        List<String> shuffleCrews = shuffleCrew(crews);
        if (shuffleCrews.size() % 2 == 0) {
            makeCrewsEven(shuffleCrews);
            return;
        }
        makeCrewsOdd(shuffleCrews);
    }

    private void makeCrewsOdd(List<String> shuffleCrews) {
        List<Crew> crews = commonShuffle(shuffleCrews);
        Crew lastPair = crews.get(crews.size() - 1);
        int lastIndex = shuffleCrews.size() - 1;
        lastPair.add(shuffleCrews.get(lastIndex));
        this.crews = crews;
    }

    private void makeCrewsEven(List<String> shuffleCrews) {
        List<Crew> crews = commonShuffle(shuffleCrews);
        int lastIndex = shuffleCrews.size() - 1;
        crews.add(new Crew(shuffleCrews.get(lastIndex - 1),
                shuffleCrews.get(lastIndex))
        );
        this.crews = crews;
    }

    private static List<Crew> commonShuffle(List<String> shuffleCrews) {
        List<Crew> crews = new ArrayList<>();
        for (int i = 0; i < shuffleCrews.size() - 2; i += 2) {
            Crew crew = new Crew(shuffleCrews.get(i), shuffleCrews.get(i + 1));
            crews.add(crew);
        }
        return crews;
    }

    public boolean findCrews(String[] choice) {
        return course.isEqual(choice[0]) && level.isEqual(choice[1]);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (Crew crew : crews) {
            sb.append(crew.toString()).append("\n");
        }
        return sb.toString();
    }
}
