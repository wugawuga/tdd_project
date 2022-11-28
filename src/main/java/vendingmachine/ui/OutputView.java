package vendingmachine.ui;

public class OutputView {
    public static void printError(String message) {
        System.out.println(message);
    }

    public void howMuchHasMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
    }
}
