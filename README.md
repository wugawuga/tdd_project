# 미션 - 숫자 야구 게임

## 🔍 진행방식

- 미션은 **기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항** 세 가지로 구성되어 있다.
- 세 개의 요구사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.

## 📝 커밋메세지

- feat
- docs
- style
- refactor
- fix

## 🚀 기능 요구사항

- 입력
  - 1~9 3자리
  - 재시작(1), 종료(2)
- 기능
  - 게임 시작 시 랜덤 3자리 생성
  - 유저 입력 1~9 3자리 수
    - 중복 x
    - 3자리
    - 다른 문자 입력시 에러
  - 랜덤 3자리 유저 3자리 비교
    - 같은 수 x -> "낫싱"
    - 자리는 틀리나 숫자가 포함되면 -> "볼"
    - 자리도 같고 숫자도 같으면 -> "스트라이크"
    - 볼과 스트라이크 둘 다 있으면 볼부터 출력 -> "1볼 1스트라이크"
  - 결과
    - 정답이 아니면 계속 유저 입력
    - 정답을 맞히면 종료
  - 종료
    - 재시작(1)
    - 프로그램 종료(2)
    - 다른 문자 입력시 에러
<br>

---

## 🎱 프로그래밍 요구사항

- 프로그램을 실행하는 시작점은 `Application`의 `main()`이다.
- JDK 8 버전에서 실행 가능해야 한다. **JDK 8에서 정상 동작하지 않을 경우 0점 처리**한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - https://naver.github.io/hackday-conventions-java
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.

### 프로그래밍 요구사항 - Randoms, Console

- JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을 때 `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.
