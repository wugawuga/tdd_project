package finalpairmatching;

import java.util.ArrayList;
import java.util.List;

public class PairResults {
    private List<PairResult> results = new ArrayList<>();

    public void add(PairResult result) {
        results.add(result);
    }

    public PairResult findResult(String course, String level, String mission) {
        PairResult result;
        for (PairResult pairResult : results) {
            result = pairResult.find(course, level, mission);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
