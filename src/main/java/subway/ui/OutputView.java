package subway.ui;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String ERROR = "[ERROR]";

    public static void start() {
        System.out.println("## 메인 화면" + NEW_LINE
                + "1. 경로 조회" + NEW_LINE
                + "Q. 종료");
        mainCommand();
    }

    public static void mainCommand() {
        System.out.println(NEW_LINE + "## 원하는 기능을 선택하세요.");
    }

    public static void features() {
        System.out.println(NEW_LINE + "## 경로 기준" + NEW_LINE
                + "1. 최단 거리" + NEW_LINE
                + "2. 최소 시간" + NEW_LINE
                + "B. 돌아가기");
        mainCommand();
    }

    public static void departureStation() {
        System.out.println(NEW_LINE + "## 출발역을 입력하세요.");
    }

    public static void terminalStation() {
        System.out.println(NEW_LINE + "## 도착역을 입력하세요.");
    }

    public static void error(String message) {
        System.out.println(NEW_LINE + ERROR + message);
    }
}
