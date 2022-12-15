package repairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Crew {
    private final List<String> pairs = new ArrayList<>();

    public Crew(String firstCrew, String secondCrew) {
        pairs.add(firstCrew);
        pairs.add(secondCrew);
    }

    public Crew(String firstCrew, String secondCrew, String thirdCrew) {
        pairs.add(firstCrew);
        pairs.add(secondCrew);
        pairs.add(thirdCrew);
    }

    public void add(String lastCrew) {
        pairs.add(lastCrew);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String pair : pairs) {
            sb.append(pair).append(" : ");
        }
        return sb.substring(0, sb.lastIndexOf(" : "));
    }
}
