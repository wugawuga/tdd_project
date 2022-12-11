package repairmatching;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import repairmatching.domain.Crews;
import repairmatching.ui.InputView;
import repairmatching.ui.OutputView;

public class PairController {
    private Map<String, List<String>> crews;
    private List<Crews> pairs = new ArrayList<>();

    public PairController(Map<String, List<String>> crews) {
        this.crews = crews;
    }

    public void start() {
        String command = "";
        while (!command.equals("Q")) {
            OutputView.command();
            command = choiceCommand();
            branchOffCommand(command);
        }
    }

    private void branchOffCommand(String command) {
        if (command.equals("1")) {
            match();
        }
    }

    private void match() {
        OutputView.choiceCourseLevelMission();
        String[] choice = InputView.choice();
        checkExist(choice);
    }

    private void matching(String[] choice) {
        Crews shuffleCrews = new Crews(choice);
        shuffleCrews.makeCrews(crews);
        OutputView.printResult(shuffleCrews);
        pairs.add(shuffleCrews);
    }

    private void checkExist(String[] choice) {
        if (!pairs.isEmpty()) {
            for (Crews pair : pairs) {
                choiceEqualPairs(choice, pair);
            }
            return;
        }
        matching(choice);
    }

    private void choiceEqualPairs(String[] choice, Crews pair) {
        if (pair.findCrews(choice)) {
            OutputView.reMatch();
            String yesOrNo = InputView.reMatch();
            checkRematch(yesOrNo, pair, choice);
        }
    }

    private void checkRematch(String yesOrNo, Crews pair, String[] choice) {
        if (yesOrNo.equals("네")) {
            pairs.remove(pair);
            matching(choice);
            return;
        }
        OutputView.printResult(pair);
        start();
    }

    private String choiceCommand() {
        try {
            String command = InputView.command();
            validateCommand(command);
            return command;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return choiceCommand();
        }
    }

    private void validateCommand(String command) {
        if (!command.equals("1") &&
                !command.equals("2") &&
                !command.equals("3") &&
                !command.equals("Q")) {
            throw new IllegalArgumentException("1, 2, 3, Q 중에 입력하세요");
        }
    }
}
