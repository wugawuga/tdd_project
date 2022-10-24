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

		List<String> backendCrews = FileReader.read("backend-crew.md");
		List<String> frontedCrews = FileReader.read("frontend-crew.md");

		System.out.println("backendCrews = " + backendCrews);
		System.out.println("frontedCrews = " + frontedCrews);
	}
}
