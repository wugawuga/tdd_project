package vendingmachine.ui;

import java.util.Map;
import vendingmachine.Coin;
import vendingmachine.CoinPocket;

public class OutputView {
    public static void printError(String message) {
        System.out.println(message);
    }

    public void howMuchHasMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
    }

    public void fillBeverage() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
    }

    public void changesOfMachine(CoinPocket pocket) {
        System.out.println();
        System.out.println("자판기가 보유한 동전");
        Map<Coin, Integer> changes = pocket.getPocket();
        for (Map.Entry<Coin, Integer> entry : changes.entrySet()) {
            Coin key = entry.getKey();
            int count = entry.getValue();
            System.out.println(key.getAmount() + " - " + count + "개");
        }
    }

    public void inputAmount() {
        System.out.println();
        System.out.println("투입 금액을 입력해 주세요.");
    }

    public void machineRemainder(int money) {
        System.out.println();
        System.out.println("투입 금액: " + money);
    }

    public void order() {
        System.out.println("구매할 상품명을 입력해 주세요.");
    }

    public void makeChanges(int changes, CoinPocket pocket) {
        machineRemainder(changes);
        System.out.println("잔돈");
        Map<Coin, Integer> coinIntegerMap = pocket.makeChanges(changes);
        for (Map.Entry<Coin, Integer> entry : coinIntegerMap.entrySet()) {
            Coin key = entry.getKey();
            int count = entry.getValue();
            System.out.println(key.getAmount() + "원 - " + count + "개");
        }
    }
}
