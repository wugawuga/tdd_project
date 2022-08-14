package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public int[] makeAnswer() {

        int[] answer = new int[3];
        boolean[] usedCheck = new boolean[10];

        int index = 0;
        while (index != 3) {
            int random = Randoms.pickNumberInRange(1, 9);

            if (usedCheck[random]) {
                continue;
            }
            answer[index] = random;
            usedCheck[random] = true;
            index++;
        }
        return answer;
    }
}
