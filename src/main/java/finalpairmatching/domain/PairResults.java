package finalpairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class PairResults {
    private List<PairResult> results = new ArrayList<>();

    public void add(PairResult result) {
        results.add(result);
    }

    public PairResult findResult(String[] conditions) {
        PairResult result;
        for (PairResult pairResult : results) {
            if (conditions[1].equals("레벨3") || conditions[1].equals("레벨5")) {
                return pairResult.findThreeOrFiveLevel(conditions);
            }
            result = pairResult.find(conditions);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public void remove(PairResult findResult) {
        results.remove(findResult);
    }

    public void reset() {
        results = new ArrayList<>();
    }
}
