package subway.domain;

import java.util.List;

public class LineStation {
    private final Line line;
    private final List<Section> sections;

    public LineStation(Line line, List<Section> sections) {
        this.line = line;
        this.sections = sections;
    }

    public String getLine() {
        return line.getName();
    }

    public List<Section> getSection() {
        return sections;
    }
}
