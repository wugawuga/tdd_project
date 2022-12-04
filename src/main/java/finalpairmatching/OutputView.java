package finalpairmatching;

import java.util.List;

public class OutputView {
    public void chooseFeat() {
        System.out.println("기능을 선택하세요.\n"
                + "1. 페어 매칭\n"
                + "2. 페어 조회\n"
                + "3. 페어 초기화\n"
                + "Q. 종료");
    }

    public void chooseMatchingCondition() {
        System.out.println();
        System.out.println("#############################################\n"
                + "과정: 백엔드 | 프론트엔드\n"
                + "미션:\n"
                + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
                + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
                + "  - 레벨3: \n"
                + "  - 레벨4: 성능개선 | 배포\n"
                + "  - 레벨5: \n"
                + "############################################\n"
                + "과정, 레벨, 미션을 선택하세요.\n"
                + "ex) 백엔드, 레벨1, 자동차경주");
    }

    public void matchingResult(PairResult pairResult) {
        System.out.println();
        System.out.println("페어 매칭 결과입니다.");
        List<String> crews = pairResult.printShuffle();
        if (crews.size() % 2 == 0) {
            printEven(crews);
        }
        if (crews.size() % 2 != 0) {
            printOdd(crews);
        }
        System.out.println();
    }

    private static void printEven(List<String> crews) {
        for (int i = 0; i < crews.size() - 1; i += 2) {
            System.out.println(crews.get(i) + " : " + crews.get(i + 1));
        }
    }

    private static void printOdd(List<String> crews) {
        for (int i = 0; i <= crews.size() - 3; i += 2) {
            if (i == crews.size() - 3) {
                System.out.println(crews.get(i) + " : " + crews.get(i + 1) + " : " + crews.get(i + 2));
                break;
            }
            System.out.println(crews.get(i) + " : " + crews.get(i + 1));
        }
    }

    public void existResult() {
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
    }

    public void nonExist() {
        System.out.println("조회 결과가 없습니다");
        System.out.println("다시 입력해 주세요");
        chooseMatchingCondition();
    }
}
