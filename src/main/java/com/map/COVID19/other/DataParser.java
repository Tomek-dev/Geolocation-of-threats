package com.map.COVID19.other;

import com.map.COVID19.builder.PointBuilder;
import com.map.COVID19.model.Point;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

public class DataParser {

    public static List<Point> parser(String data) throws IOException {
        List<Point> points = new LinkedList<>();
        StringReader reader = new StringReader(data);
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
        parser.forEach(value -> {
            Point point = PointBuilder.builder()
                    .country(value.get("Country/Region"))
                    .province(value.get("Province/State"))
                    .latitude(Double.parseDouble(value.get("Latitude")))
                    .longitude(Double.parseDouble(value.get("Longitude")))
                    .recovered(value.get("Recovered"))
                    .deaths(value.get("Deaths"))
                    .confirmed(value.get("Confirmed"))
                    .build();
            points.add(point);
        });
        return points;
    }
}
