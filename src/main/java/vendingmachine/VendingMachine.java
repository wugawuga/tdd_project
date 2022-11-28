package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.ui.InputView;
import vendingmachine.ui.OutputView;

public class VendingMachine {
    private final InputView inputView;
    private final OutputView outputView;
    private CoinPocket pocket;

    public VendingMachine() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void on() {
        makeRandomChanges();
        outputView.changesOfMachine(pocket);
        List<Beverage> beverages = fillBeverage();
    }

    private List<Beverage> fillBeverage() {
        outputView.fillBeverage();
        String[] beverages = inputView.beverages();
        List<Beverage> list = new ArrayList<>();
        for (String beverage : beverages) {
            list.add(new Beverage(beverage.split(",")));
        }
        return list;
    }

    private void makeRandomChanges() {
        outputView.howMuchHasMoney();
        int moneyOfMachine = inputView.inputMoney();
        pocket = new CoinPocket(moneyOfMachine);
    }
}
