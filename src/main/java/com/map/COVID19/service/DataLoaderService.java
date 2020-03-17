package com.map.COVID19.service;

import com.map.COVID19.dao.PointDao;
import com.map.COVID19.model.Point;
import com.map.COVID19.other.DataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Service
public class DataLoaderService {

    private static final String URL = "";

    private PointDao pointDao;

    @Autowired
    public DataLoaderService(PointDao pointDao) {
        this.pointDao = pointDao;
    }

    public void saveData(){
        LocalDateTime instance = LocalDateTime.now();
        String time = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(instance);
        RestTemplate template = new RestTemplate();
        String data = template.getForObject(URL + time + ".csv", String.class);
        try {
            pointDao.saveAll(DataParser.parser(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
