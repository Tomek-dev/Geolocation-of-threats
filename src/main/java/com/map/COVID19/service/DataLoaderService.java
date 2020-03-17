package com.map.COVID19.service;

import com.map.COVID19.dao.PointDao;
import com.map.COVID19.model.Point;
import com.map.COVID19.other.DataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service
public class DataLoaderService {

    private static final String URL = "";

    private PointDao pointDao;

    @Autowired
    public DataLoaderService(PointDao pointDao) {
        this.pointDao = pointDao;
    }

    public void saveData(){
        List<Point> points = new LinkedList<>();
        RestTemplate template = new RestTemplate();
        String data = template.getForObject(URL, String.class);
        try {
            pointDao.saveAll(DataParser.parser(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
