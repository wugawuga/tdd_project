package subway.config;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.LineStation;
import subway.domain.LineStationRepository;
import subway.domain.Section;
import subway.domain.Station;
import subway.domain.StationRepository;

public class GraphPath {
    private static WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(
            DefaultWeightedEdge.class);
    private static WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(
            DefaultWeightedEdge.class);

    public static DijkstraShortestPath distancePath = new DijkstraShortestPath(distanceGraph);
    public static DijkstraShortestPath timePath = new DijkstraShortestPath(timeGraph);

    public void initGraph() {
        makeTimeGraph();
        makeDistanceGraph();
    }

    private static void makeTimeGraph() {
        for (Station station : StationRepository.stations()) {
            timeGraph.addVertex(station.getName());
        }
        for (LineStation lineStation : LineStationRepository.lineStations()) {
            makeSectionEdgeTime(lineStation.getSection());
        }
    }

    private static void makeSectionEdgeTime(List<Section> sections) {
        for (Section section : sections) {
            timeGraph.setEdgeWeight(timeGraph.addEdge(
                    section.firstStation(), section.secondStation()), section.getTime());
        }
    }

    private void makeDistanceGraph() {
        for (Station station : StationRepository.stations()) {
            distanceGraph.addVertex(station.getName());
        }
        for (LineStation lineStation : LineStationRepository.lineStations()) {
            makeSectionEdgeByDistance(lineStation.getSection());
        }
    }

    private void makeSectionEdgeByDistance(List<Section> sections) {
        for (Section section : sections) {
            distanceGraph.setEdgeWeight(distanceGraph.addEdge(
                    section.firstStation(), section.secondStation()), section.getDistance());
        }
    }

    public GraphPath() {
    }
}
