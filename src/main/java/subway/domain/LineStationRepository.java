package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineStationRepository {
    private static final List<LineStation> lineStations = new ArrayList<>();

    public static List<LineStation> lineStations() {
        return Collections.unmodifiableList(lineStations);
    }

    public static void addLine(LineStation lineStation) {
        lineStations.add(lineStation);
    }
}
