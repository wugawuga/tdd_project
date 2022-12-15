package repairmatching;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    private static final List<String> fileNames = Arrays.asList("backend-crew.md", "frontend-crew.md");

    public static void main(String[] args) {
        Map<String, List<String>> front_back_crews = new HashMap<>();
        for (String fileName : fileNames) {
            String branch = divergeFileName(fileName);
            List<String> crews = readFile(fileName);
            front_back_crews.put(branch, crews);
        }

        PairController controller = new PairController(front_back_crews);
        controller.start();
    }

    private static List<String> readFile(String fileName) {
        try (InputStream is = Application.class.getClassLoader().getResource(fileName).openStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            return br.lines().collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 파일이름을 확인해주세요.");
        }
    }

    private static String divergeFileName(String fileName) {
        if (fileName.contains("backend-crew")) {
            return "백엔드";
        }
        if (fileName.contains("frontend-crew")) {
            return "프론트엔드";
        }
        throw new IllegalArgumentException("[ERROR] 파일이름은 'backend-crew', 'frontend-crew' 만 가능해요");
    }
}
