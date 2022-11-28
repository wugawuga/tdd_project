package vendingmachine;

import java.util.Arrays;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static List<Integer> getAmounts() {
        return Arrays.asList(
                COIN_500.amount,
                COIN_100.amount,
                COIN_50.amount,
                COIN_10.amount
        );
    }

    public static Coin findCoin(int randomAmount) {
        return Arrays.stream(values())
                .filter(coin -> coin.amount == randomAmount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getAmount() {
        return this.amount;
    }
}
