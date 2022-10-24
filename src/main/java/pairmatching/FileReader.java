package pairmatching;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

	public static List<String> read(String fileName) {
		try {
			InputStream inputStream = Application.class
				.getClassLoader()
				.getResource(fileName)
				.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			List<String> allLines = br.lines().collect(Collectors.toList());
			return allLines;
		} catch (Exception e) {
			System.out.println("파일 이름(" + fileName + ")을 확인해주세요");
			return null;
		}
	}
}
