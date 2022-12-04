package finalpairmatching;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PairMatchingController {
    private static final String BACK_BRANCH = "back";
    private static final String FRONT_BRANCH = "front";
    private final OutputView output = new OutputView();
    private final InputView input = new InputView();
    private List<PairResult> results = new ArrayList<>();
    private final List<String> frontend;
    private final List<String> backend;
    private boolean programFlag = true;

    public PairMatchingController(Map<String, List<String>> crewList) {
        this.backend = crewList.get(BACK_BRANCH);
        this.frontend = crewList.get(FRONT_BRANCH);
    }

    public void start() {
        while (programFlag) {
            output.chooseFeat();
            branchOffCommand(input.command());
        }
    }

    private void branchOffCommand(String command) {
        if (command.equals("1")) {
            matching();
            return;
        }
//        if (command.equals("2")) {
//            select();
//            return;
//        }
//        if (command.equals("3")) {
//            init();
//            return;
//        }
        if (command.equals("Q")) {
            quit();
            return;
        }
        throw new IllegalArgumentException("[ERROR] 1,2,3,Q 중에 입력해 주세요");
    }

    private void matching() {
        output.chooseMatchingCondition();
        String[] conditions = input.matchingCondition();
        PairResult pairResult = makeShuffle(conditions[0], conditions[1], conditions[2]);
        results.add(pairResult);
        output.matchingResult(pairResult);
    }

    private PairResult makeShuffle(String course, String level, String mission) {
        if (course.equals("백엔드")) {
            return new PairResult(course, level, mission, Randoms.shuffle(backend));
        }
        return new PairResult(course, level, mission, Randoms.shuffle(frontend));
    }

    private void quit() {
        programFlag = false;
    }
}
