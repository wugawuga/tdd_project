package pairmatching;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
	public static void main(String[] args) {
		//TODO: 구현 진행
		try {
			InputStream inputStream1 = Application.class
				.getClassLoader()
				.getResource("backend-crew.md")
				.openStream();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(inputStream1));
			List<String> backendCrew = br1.lines().collect(Collectors.toList());
			System.out.println("backendCrew = " + backendCrew);
		} catch (Exception e) {
			System.out.println("파일 이름을 확인해주세요");
		}

		try {
			InputStream inputStream1 = Application.class
				.getClassLoader()
				.getResource("backend-crew.md")
				.openStream();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(inputStream1));
			List<String> backendCrew = br1.lines().collect(Collectors.toList());
			System.out.println("backendCrew = " + backendCrew);
		} catch (Exception e) {
			System.out.println("파일 이름을 확인해주세요");
		}
	}
}
