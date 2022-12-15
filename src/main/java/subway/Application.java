package subway;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.config.GraphPath;
import subway.config.SubwayConfig;
import subway.ui.OutputView;

public class Application {

    private static final String END_COMMAND = "Q";
    private static final String FEAT_START_COMMAND = "1";
    private static final RouteMapService service = new RouteMapService();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayConfig.init();
        GraphPath path = new GraphPath();
        path.initGraph();
        // TODO: 프로그램 구현
        startGame(scanner);
    }

    private static void startGame(Scanner scanner) {
        String mainCommand;
        do {
            OutputView.start();
            mainCommand = getMainCommand(scanner);
            if (mainCommand.equals(FEAT_START_COMMAND)) {
                selectService(scanner);
            }
        } while (!mainCommand.equals(END_COMMAND));
    }

    private static void selectService(Scanner scanner) {
        OutputView.features();
        String featuresCommand = getFeaturesCommand(scanner);
        if (featuresCommand.equals("B")) {
            return;
        }
        branchOff(scanner, featuresCommand);
    }

    private static void branchOff(Scanner scanner, String command) {
        try {
            List<String> inputStations = getStations(scanner);
            if (command.equals("1")) {
                service.makeShortestDistance(inputStations);
            }
            if (command.equals("2")) {
                service.makeMinimumTime(inputStations);
            }
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());
            selectService(scanner);
        }
    }

    private static List<String> getStations(Scanner scanner) {
        String departureStation = getDepartureStation(scanner);
        String terminalStation = getTerminalStation(scanner);
        validateSameStation(departureStation, terminalStation);
        return Arrays.asList(departureStation, terminalStation);
    }

    private static void validateSameStation(String departureStation, String terminalStation) {
        if (service.isSameStation(departureStation, terminalStation)) {
            throw new IllegalArgumentException(" 출발역과 도착역이 동일합니다.");
        }
    }

    private static String getTerminalStation(Scanner scanner) {
        OutputView.terminalStation();
        return scanner.nextLine();
    }

    private static String getDepartureStation(Scanner scanner) {
        OutputView.departureStation();
        return scanner.nextLine();
    }

    private static String getFeaturesCommand(Scanner scanner) {
        try {
            String featuresCommand = scanner.nextLine();
            validateFeaturesCommand(featuresCommand);
            return featuresCommand;
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());
            return getFeaturesCommand(scanner);
        }
    }

    private static void validateFeaturesCommand(String command) {
        if (!command.equals("1") && !command.equals("2") && !command.equals("B")) {
            throw new IllegalArgumentException(" 1 또는 2, B 를 입력해주세요.");
        }
    }

    private static String getMainCommand(Scanner scanner) {
        try {
            String mainCommand = scanner.nextLine();
            validateMainCommand(mainCommand);
            return mainCommand;
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());
            return getMainCommand(scanner);
        }
    }

    private static void validateMainCommand(String command) {
        if (!command.equals(FEAT_START_COMMAND) && !command.equals(END_COMMAND)) {
            throw new IllegalArgumentException(" 1 또는 Q 를 입력해주세요.");
        }
    }
}
