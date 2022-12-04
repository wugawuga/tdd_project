package finalpairmatching;

import java.util.List;
import java.util.Map;

public class PairMatchingController {
    private static final String BACK_BRANCH = "back";
    private static final String FRONT_BRANCH = "fronted";
    private final OutputView output = new OutputView();
    private final List<String> backend;
    private final List<String> frontend;

    public PairMatchingController(Map<String, List<String>> crewList) {
        this.backend = crewList.get(BACK_BRANCH);
        this.frontend = crewList.get(FRONT_BRANCH);
    }

    public void start() {
        output.chooseFeat();
    }
}
