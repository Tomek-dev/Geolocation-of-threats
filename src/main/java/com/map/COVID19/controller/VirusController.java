package com.map.COVID19.controller;

import com.map.COVID19.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class VirusController {

    private PointService pointService;

    @Autowired
    public VirusController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping("/virus")
    public String virus(Model model){
        model.addAttribute("points", pointService.findAll());
        return "virus";
    }
}
