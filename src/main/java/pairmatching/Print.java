package pairmatching;

import static pairmatching.Options.*;

public class Print {
	public static void options() {
		System.out.println("기능을 선택하세요.");
		System.out.println(MATCHING +". 페어 매칭");
		System.out.println(SELECT +". 페어 조회");
		System.out.println(RESET +". 페어 초기화");
		System.out.println(QUIT + ". 종료");
	}
}
