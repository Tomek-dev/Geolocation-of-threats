package com.map.COVID19.service;

import com.map.COVID19.dao.PointDao;
import com.map.COVID19.other.DataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class DataLoaderService {

    private static final String URL = "http://localhost:8080/";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH);

    private PointDao pointDao;

    @Autowired
    public DataLoaderService(PointDao pointDao) {
        this.pointDao = pointDao;
    }

    public void saveData(){
        LocalDate instance = LocalDate.now();
        String time = FORMATTER.format(instance);
        RestTemplate template = new RestTemplate();
        String data = "";
        boolean success = false;
        while (!success){
            try{
                data = template.getForObject(URL + time, String.class);
                success = true;
            }catch (HttpClientErrorException e){
                instance = LocalDate.parse(time, FORMATTER);
                time = FORMATTER.format(instance.minusDays(1));
            }
        }
        try {
            pointDao.saveAll(DataParser.parser(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
