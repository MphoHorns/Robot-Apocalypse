package com.example.RobotApocalypse.controller;

import com.example.RobotApocalypse.entity.Robots;
import com.example.RobotApocalypse.service.RobotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sorted-robots")
public class RobotsController {
    @Autowired
    private RobotsService robotsService;
    @GetMapping
    public ResponseEntity<List<Robots>> getSortedRobots(){
        String url = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";
        List<Robots> sortedRobots = robotsService.getSortedRobotsFromURL(url);
        return ResponseEntity.ok(sortedRobots);
    }
}
