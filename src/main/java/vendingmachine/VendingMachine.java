package vendingmachine;

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
        outputView.howMuchHasMoney();
        int moneyOfMachine = inputView.inputMoney();
        pocket = new CoinPocket(moneyOfMachine);
    }
}
