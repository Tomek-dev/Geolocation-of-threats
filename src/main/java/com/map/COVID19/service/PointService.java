package com.map.COVID19.service;

import com.map.COVID19.model.Point;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PointService {

    private PointService pointService;

    @Autowired
    public PointService(PointService pointService) {
        this.pointService = pointService;
    }

    public List<Point> findAll(){
        return pointService.findAll();
    }
}
