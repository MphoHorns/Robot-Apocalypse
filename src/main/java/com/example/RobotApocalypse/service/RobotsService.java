package com.example.RobotApocalypse.service;

import com.example.RobotApocalypse.entity.Robots;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
@Service
public class RobotsService {
    public List<Robots> getSortedRobotsFromURL(String url){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Robots[]> responseEntity = restTemplate.getForEntity(url, Robots[].class);
        Robots[] robots = responseEntity.getBody();

        Arrays.sort(robots, Comparator.comparing(Robots::getCategory));
        return Arrays.asList(robots);
    }
}
