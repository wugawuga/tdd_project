package pairmatching;

import static pairmatching.Options.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Matching {

	private List<String> backend;
	private List<String> frontend;
	private List<String> suffledCrew;

	public Matching(List<String> backendCrews, List<String> frontedCrews) {
		this.backend = backendCrews;
		this.frontend = frontedCrews;
	}

	public void selectOption(String input) {
		if (input.equals(MATCHING)) {
			match();
		}
		if (input.equals(SELECT)) {
			select();
		}
		if (input.equals(RESET)) {
			reset();
		}
	}

	public void match() {
		Print.match();
		String[] split = Console.readLine().split(", ");
		try {
			validCourseLevelMission(split[0], split[1], split[2]);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			match();
		}

		if (split[0].equals("백엔드")) {
			matching(backend);
		}
		if (split[0].equals("프론트엔드")) {
			matching(frontend);
		}
	}

	private void matching(List<String> crews) {
		shuffle(crews);
		StringBuilder sb = new StringBuilder();
		int size = this.suffledCrew.size();
		int i = 0;
		while (3 <= size) {
			matchCrews(this.suffledCrew, sb, size, i);
			i += 2;
			size -= 2;
		}
		if (size == 1) {
			sb.append(" : ").append(this.suffledCrew.get(this.suffledCrew.size() - 1));
		}
		System.out.println("페어매칭결과다");
		System.out.println(sb);
	}

	private void matchCrews(List<String> crews, StringBuilder sb, int size, int i) {
		if (size == 3) {
			sb.append(crews.get(i))
				.append(" : ")
				.append(crews.get(i + 1));
			return;
		}
		sb.append(crews.get(i))
			.append(" : ")
			.append(crews.get(i + 1))
			.append("\n");
	}

	private void shuffle(List<String> crews) {
		suffledCrew = Randoms.shuffle(crews);
	}

	private void validCourseLevelMission(String crewType, String level, String mission) {
		if (!checkCrew(crewType)) {
			throw new IllegalArgumentException("[ERROR] 과정을 다시 입력하세요");
		}
		if (!checkLevel(level)) {
			throw new IllegalArgumentException("[ERROR] 레벨을 다시 입력하세요");
		}
		if (!checkMission(level, mission)) {
			throw new IllegalArgumentException("[ERROR] 미션을 다시 입력하세요");
		}
	}

	private boolean checkMission(String level, String mission) {
		if (level.contains("3") || level.contains("5")) {
			checkLv3AndLv5(level, mission);
		}
		if (level.contains("1")) {
			return checkLv1Mission(mission);
		}
		if (level.contains("2")) {
			return checkLv2Mission(mission);
		}
		if (level.contains("4")) {
			return checkLv4Mission(mission);
		}
		return true;
	}

	private boolean checkLv4Mission(String mission) {
		return mission.equals("성능개선") ||
			mission.equals("배포");
	}

	private boolean checkLv2Mission(String mission) {
		return mission.equals("장바구니") ||
			mission.equals("결제") ||
			mission.equals("지하철노선도");
	}

	private boolean checkLv1Mission(String mission) {
		return mission.equals("자동차경주") ||
			mission.equals("로또") ||
			mission.equals("숫자야구게임");
	}

	private void checkLv3AndLv5(String level, String mission) {
		if (mission != null) {
			throw new IllegalArgumentException("[ERROR] 레벨3, 5는 미션이 없습니다.");
		}
	}

	private boolean checkLevel(String level) {
		return level.equals("레벨1") ||
			level.equals("레벨2") ||
			level.equals("레벨3") ||
			level.equals("레벨4") ||
			level.equals("레벨5");
	}

	private boolean checkCrew(String crewType) {
		return crewType.equals("백엔드") || crewType.equals("프론트엔드");
	}

	public void select() {
	}

	public void reset() {
	}
}
