package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.Map;

public class CoinPocket {
    private final Map<Coin, Integer> pocket = new LinkedHashMap<>();

    public CoinPocket(int money) {
        validate(money);
        initMachine();
        makeRandomChanges(money);
    }

    public Map<Coin, Integer> getPocket() {
        return pocket;
    }

    private void initMachine() {
        pocket.put(Coin.COIN_500, 0);
        pocket.put(Coin.COIN_100, 0);
        pocket.put(Coin.COIN_50, 0);
        pocket.put(Coin.COIN_10, 0);
    }

    private void validate(int money) {
        if (money % 10 != 0 || money < 10) {
            throw new IllegalArgumentException("[ERROR] 10원으로 나누어 떨어져야해요");
        }
    }

    private void makeRandomChanges(int money) {
        while (money != 0) {
            int randomAmount = Randoms.pickNumberInList(Coin.getAmounts());
            if (randomAmount > money) {
                continue;
            }
            Coin coin = Coin.findCoin(randomAmount);
            pocket.put(coin, pocket.get(coin) + 1);
            money -= randomAmount;
        }
    }
}
