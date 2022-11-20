package racingcar.ui;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Position;

public class OutputView {
    public void participate() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void tryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void result() {
        System.out.println("실행 결과");
    }

    public void gameResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.printName() + " : " + nowDistance(car.printPosition()));
        }
        newLine();
    }

    private String nowDistance(Position position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(String.valueOf(position)); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void newLine() {
        System.out.println();
    }

    public void winner(Cars cars) {
        String winners = cars.getCars().stream()
                .map(Car::printName)
                .collect(Collectors.joining(", "));

        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
