package pairmatching;

import static pairmatching.Options.*;

import java.util.List;

public class Matching {

	private List<String> backend;
	private List<String> frontend;

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
	}

	public void select() {
	}

	public void reset() {
	}
}
