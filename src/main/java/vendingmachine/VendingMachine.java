package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.ui.InputView;
import vendingmachine.ui.OutputView;

public class VendingMachine {
    private final InputView inputView;
    private final OutputView outputView;
    private CoinPocket pocket;
    private Beverages beverages;
    private int inputMoney = 0;

    public VendingMachine() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void on() {
        makeRandomChanges();
        outputView.changesOfMachine(pocket);
        beverages = fillBeverage();
        inputAmount();
        int changes = order();

        outputView.makeChanges(changes, pocket);
    }

    private int order() {
        if (beverages.checkMinimumMoney(inputMoney)) {
            return inputMoney;
        }
        outputView.machineRemainder(inputMoney);
        outputView.order();
        String beverageName = inputView.beverageName();

        Beverage orderBeverage = beverages.order(beverageName);
        inputMoney = orderBeverage.order(inputMoney);
        return order();
    }

    private void inputAmount() {
        outputView.inputAmount();
        inputMoney = inputView.inputMoney();
    }

    private Beverages fillBeverage() {
        outputView.fillBeverage();
        List<Beverage> beverages = new ArrayList<>();
        for (String beverage : inputView.beverages()) {
            beverages.add(new Beverage(beverage.split(",")));
        }
        return new Beverages(beverages);
    }

    private void makeRandomChanges() {
        outputView.howMuchHasMoney();
        int moneyOfMachine = inputView.inputMoney();
        pocket = new CoinPocket(moneyOfMachine);
    }
}
