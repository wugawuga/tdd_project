package subway.ui;

public class OutputView {
    private static final String ERROR = "[ERROR]";

    public static void start() {
        System.out.println("## 메인 화면\n"
                + "1. 경로 조회\n"
                + "Q. 종료");
    }

    public static void mainCommand() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public static void error(String message) {
        System.out.println(ERROR + message);
    }
}
