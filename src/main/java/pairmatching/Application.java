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
		List<String> backendCrew = crewList("backend-crew.md");
		System.out.println(backendCrew);
		List<String> frontendCrew = crewList("frontend-crew.md");
		System.out.println(frontendCrew);
	}

	private static List<String> crewList(String fileName) {
		try {
			InputStream inputStream1 = Application.class
				.getClassLoader()
				.getResource(fileName)
				.openStream();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(inputStream1));
			List<String> crewList = br1.lines().collect(Collectors.toList());
			return crewList;
		} catch (Exception e) {
			System.out.println("파일 이름(" + fileName + ")을 확인해주세요");
			return null;
		}
	}
}
