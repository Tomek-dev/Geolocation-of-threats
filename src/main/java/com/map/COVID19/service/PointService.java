package com.map.COVID19.service;

import com.map.COVID19.dao.PointDao;
import com.map.COVID19.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    private PointDao pointDao;

    @Autowired
    public PointService(PointDao pointDao) {
        this.pointDao = pointDao;
    }

    public List<Point> findAll(){
        return pointDao.findAll();
    }
}
