package vendingmachine;

import java.util.List;

public class Beverages {
    private final List<Beverage> beverages;

    public Beverages(List<Beverage> beverages) {
        this.beverages = beverages;
    }

    public Beverage order(String beverageName) {
        Beverage beverage = findBeverage(beverageName);
        checkExist(beverage);
        return beverage;
    }

    private Beverage findBeverage(String beverageName) {
        for (Beverage beverage : beverages) {
            if (beverage.isName(beverageName)) {
                return beverage;
            }
        }
        return null;
    }

    private void checkExist(Beverage beverage) {
        if (beverage == null) {
            throw new IllegalArgumentException("[ERROR] 음료가 없습니다");
        }
    }

    public boolean checkMinimumMoney(int inputMoney) {
        int minimumMoney = findMinimumMoney();
        return minimumMoney > inputMoney;
    }

    private int findMinimumMoney() {
        int min = Integer.MAX_VALUE;
        for (Beverage beverage : beverages) {
            min = Math.min(min, beverage.getPrice());
        }
        return min;
    }
}
