package pairmatching;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FileReaderTest {

	@ParameterizedTest
	@CsvSource(value = {
		"backend-crew.md:20",
		"frontend-crew.md:15",
		"test.txt:6",
	}, delimiter = ':')
	void name(String fileName, int size) {
		List<String> lines = FileReader.read(fileName);

		assertThat(lines.size()).isEqualTo(size);
	}
}
