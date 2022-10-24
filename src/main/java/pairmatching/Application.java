package pairmatching;

import java.util.List;

public class Application {
	public static void main(String[] args) {

		List<String> backendCrews = FileReader.read("backend-crew.md");
		List<String> frontedCrews = FileReader.read("frontend-crew.md");

	}
}
