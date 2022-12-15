package subway;

import java.util.List;
import java.util.Optional;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import subway.config.GraphPath;
import subway.domain.LineStation;
import subway.domain.LineStationRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class RouteMapService {
    public RouteMapService() {
    }

    public void makeShortestDistance(List<String> inputStations) {
        validateStation(inputStations);
        validateConnected(inputStations);
        SingleSourcePaths firstStation = GraphPath.distancePath.getPaths(inputStations.get(0));
        double distance = GraphPath.distancePath.getPath(inputStations.get(0), inputStations.get(1)).getWeight();
        org.jgrapht.GraphPath path = firstStation.getPath(inputStations.get(1));
        List edgeList = path.getVertexList();
        int time = getTime(edgeList);
        System.out.println("## 조회 결과");
        System.out.println("[INFO] ---");
        System.out.println("[INFO] 총 거리: " + (long) distance + "km");
        System.out.println("[INFO] 총 소요 시간: " + (long) time + "분");
        System.out.println("[INFO] ---");
        for (Object o : edgeList) {
            System.out.println("[INFO] " + o);
        }
        System.out.println();
        System.out.println();
    }

    private int getTime(List edgeList) {
        int time = 0;
        List<Section> sections = SectionRepository.sections();
        for (Section section : sections) {
            for (int i = 0; i < edgeList.size() - 1; i++) {
                time += section.findTime(edgeList.get(i), edgeList.get(i + 1));
            }
        }
        return time;
    }

    private static void validateConnected(List<String> inputStations) {
        List distanceVertexList = GraphPath.distancePath.getPath(inputStations.get(0), inputStations.get(1))
                .getVertexList();
        List timeVertexList = GraphPath.timePath.getPath(inputStations.get(0), inputStations.get(1)).getVertexList();
        if (distanceVertexList.isEmpty() || timeVertexList.isEmpty()) {
            throw new IllegalArgumentException(" 연결되지 않는 역입니다.");
        }
    }

    public void makeMinimumTime(List<String> inputStations) {
        validateStation(inputStations);
        validateConnected(inputStations);
        SingleSourcePaths firstStation = GraphPath.timePath.getPaths(inputStations.get(0));
        double time = GraphPath.timePath.getPath(inputStations.get(0), inputStations.get(1)).getWeight();
        org.jgrapht.GraphPath path = firstStation.getPath(inputStations.get(1));
        List edgeList = path.getVertexList();
        int distance = getDistance(edgeList);
        System.out.println("## 조회 결과");
        System.out.println("[INFO] ---");
        System.out.println("[INFO] 총 거리: " + (long) distance + "km");
        System.out.println("[INFO] 총 소요 시간: " + (long) time + "분");
        System.out.println("[INFO] ---");
        for (Object o : edgeList) {
            System.out.println("[INFO] " + o);
        }
        System.out.println();
        System.out.println();

    }

    private int getDistance(List edgeList) {
        int distance = 0;
        List<Section> sections = SectionRepository.sections();
        for (Section section : sections) {
            for (int i = 0; i < edgeList.size() - 1; i++) {
                distance += section.findDistance(edgeList.get(i), edgeList.get(i + 1));
            }
        }
        return distance;
    }

    public boolean isSameStation(String departureStation, String terminalStation) {
        return departureStation.equals(terminalStation);
    }

    private void validateStation(List<String> inputStations) {
        Optional<Station> firstStation = StationRepository.findByName(inputStations.get(0));
        Optional<Station> secondStation = StationRepository.findByName(inputStations.get(1));
        if (!firstStation.isPresent() && !secondStation.isPresent()) {
            throw new IllegalArgumentException(" 존재하지 않는 역 입니다.");
        }
    }
}
