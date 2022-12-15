package subway.config;

import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.LineStation;
import subway.domain.LineStationRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayConfig {
    private static final List<String> LINES = Arrays.asList("2호선", "3호선", "신분당선");
    private static final List<String> STATIONS = Arrays.asList("교대역", "강남역", "역삼역", "양재역", "남부터미널역", "매봉역", "양재시민의숲역");

    public static void init() {
        insertLine();
        insertStation();
        insertSection();
        insertLineStation();
    }

    private static void insertSection() {
        SectionRepository.addSection(new Section(new Station("교대역"), new Station("강남역"), 2, 3));
        SectionRepository.addSection(new Section(new Station("강남역"), new Station("역삼역"), 2, 3));
        SectionRepository.addSection(new Section(new Station("교대역"), new Station("남부터미널역"), 3, 2));
        SectionRepository.addSection(new Section(new Station("남부터미널역"), new Station("양재역"), 6, 5));
        SectionRepository.addSection(new Section(new Station("양재역"), new Station("매봉역"), 1, 1));
        SectionRepository.addSection(new Section(new Station("강남역"), new Station("양재역"), 2, 8));
        SectionRepository.addSection(new Section(new Station("양재역"), new Station("양재시민의숲역"), 10, 3));
    }

    private static void insertStation() {
        for (String station : STATIONS) {
            StationRepository.addStation(new Station(station));
        }
    }

    private static void insertLine() {
        for (String line : LINES) {
            LineRepository.addLine(new Line(line));
        }
    }

    private static void insertLineStation() {
        List<LineStation> lineStations = Arrays.asList(
                makeLineStation("2호선", Arrays.asList(
                        new Section(new Station("교대역"), new Station("강남역"), 2, 3),
                        new Section(new Station("강남역"), new Station("역삼역"), 2, 3))),
                makeLineStation("3호선", Arrays.asList(
                        new Section(new Station("교대역"), new Station("남부터미널역"), 3, 2),
                        new Section(new Station("남부터미널역"), new Station("양재역"), 6, 5),
                        new Section(new Station("양재역"), new Station("매봉역"), 1, 1))),
                makeLineStation("신분당선", Arrays.asList(
                        new Section(new Station("강남역"), new Station("양재역"), 2, 8),
                        new Section(new Station("양재역"), new Station("양재시민의숲역"), 10, 3)))
        );
        for (LineStation lineStation : lineStations) {
            LineStationRepository.addLine(lineStation);
        }
    }

    private static LineStation makeLineStation(String name, List<Section> sections) {
        return new LineStation(new Line(name), sections);
    }
}
