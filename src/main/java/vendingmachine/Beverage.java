package vendingmachine;

public class Beverage {
    private final String name;
    private int price;
    private int amount;

    public Beverage(String[] beverageInfo) {
        validatePrice(beverageInfo[1]);
        validateAmount(beverageInfo[2]);
        this.name = beverageInfo[0];
        this.price = Integer.parseInt(beverageInfo[1]);
        this.amount = Integer.parseInt(beverageInfo[2]);
    }

    private void validateAmount(String amount) {
        if (Integer.parseInt(amount) < 1) {
            throw new IllegalArgumentException("[ERROR] 재고는 1미만일 수 없어요");
        }
    }

    private void validatePrice(String priceStr) {
        try {
            checkPrice(Integer.parseInt(priceStr));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    private void checkPrice(int price) {
        if (price < 100 || price % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 가격은 100원 이상, 10원으로 나누어 떨어져야 합니다");
        }
    }
}
