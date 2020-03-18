package com.map.COVID19.builder;

import com.map.COVID19.model.Point;

public class PointBuilder {

    private Point point = new Point();

    public static PointBuilder builder(){
        return new PointBuilder();
    }

    public PointBuilder country(String country){
        point.setCountry(country);
        return this;
    }

    public PointBuilder province(String province){
        point.setProvince(province);
        return this;
    }

    public PointBuilder latitude(Double latitude){
        point.setLatitude(latitude);
        return this;
    }

    public PointBuilder longitude(Double longitude){
        point.setLongitude(longitude);
        return this;
    }

    public PointBuilder recovered(String recovered){
        point.setRecovered(recovered);
        return this;
    }

    public PointBuilder deaths(String deaths){
        point.setDeaths(deaths);
        return this;
    }

    public PointBuilder confirmed(String confirmed){
        point.setConfirmed(confirmed);
        return this;
    }

    public Point build(){
        return point;
    }
}
