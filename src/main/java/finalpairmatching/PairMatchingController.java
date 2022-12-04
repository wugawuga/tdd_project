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
    private PairResults results = new PairResults();
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
        if (command.equals("2")) {
            select();
            return;
        }
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

    private void select() {
        output.chooseMatchingCondition();
        String[] conditions = input.matchingCondition();
        PairResult result = results.findResult(conditions[0], conditions[1], conditions[2]);
        while (result == null) {
            output.nonExist();
            conditions = input.matchingCondition();
            result = results.findResult(conditions[0], conditions[1], conditions[2]);
        }
        output.matchingResult(result);
    }

    private void matching() {
        output.chooseMatchingCondition();
        String[] conditions = input.matchingCondition();
        PairResult findResult = results.findResult(conditions[0], conditions[1], conditions[2]);
        if (findResult != null) {
            output.existResult();
            String command = input.rematchCommand();
            if (branchOffRematchCommand(command)) {
                PairResult pairResult = makeShuffle(conditions[0], conditions[1], conditions[2]);
                results.add(pairResult);
                results.remove(findResult);
                output.matchingResult(pairResult);
                return;
            }
            output.matchingResult(findResult);
        }
        if (findResult == null) {
            PairResult pairResult = makeShuffle(conditions[0], conditions[1], conditions[2]);
            results.add(pairResult);
            output.matchingResult(pairResult);
        }
    }

    private boolean branchOffRematchCommand(String command) {
        if (!command.equals("네") && !command.equals("아니오")) {
            throw new IllegalArgumentException("[ERROR] 재매칭 결과는 네 또는 아니오만 입력 가능해요");
        }
        return command.equals("네");
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
