package subway;

import java.util.Scanner;
import subway.ui.OutputView;

public class Application {

    private static final String END_COMMAND = "Q";
    private static final String FEAT_START_COMMAND = "1";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        startGame(scanner);
    }

    private static void startGame(Scanner scanner) {
        OutputView.start();
        String mainCommand = "";
        while (!mainCommand.equals(END_COMMAND)) {
            OutputView.mainCommand();
            mainCommand = getMainCommand(scanner);
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

    private static void validateMainCommand(String mainCommand) {
        if (!mainCommand.equals(FEAT_START_COMMAND) && !mainCommand.equals(END_COMMAND)) {
            throw new IllegalArgumentException(" 1 또는 Q 를 입력해주세요.");
        }
    }
}
