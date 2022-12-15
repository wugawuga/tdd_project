package subway.domain;

public class Section {
    private final Station firstStation;
    private final Station secondStation;
    private final int distance;
    private final int time;

    public Section(Station firstStation, Station secondStation, int distance, int time) {
        this.firstStation = firstStation;
        this.secondStation = secondStation;
        this.distance = distance;
        this.time = time;
    }

    public String firstStation() {
        return firstStation.getName();
    }

    public String secondStation() {
        return secondStation.getName();
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public int findTime(Object o, Object o1) {
        if (firstStation.isEqualToName((String) o) && secondStation.isEqualToName((String) o1)) {
            return time;
        }
        return 0;
    }

    public int findDistance(Object o, Object o1) {
        if (firstStation.isEqualToName((String) o) && secondStation.isEqualToName((String) o1)) {
            return distance;
        }
        return 0;
    }
}
