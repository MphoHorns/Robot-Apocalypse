package com.example.RobotApocalypse.service;

import com.example.RobotApocalypse.entity.Survivor;
import com.example.RobotApocalypse.repository.SurvivorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface SurvivorService {
    List<Survivor> getAllSurvivors();
    Survivor getSurvivorById(Integer id);
    Survivor addSurvivor(Survivor survivor);
//    Survivor updateSurvivor(Integer id, Survivor survivor);
    void updateSurvivorLocation(Integer id, float latitude, float longitude);

    void reportInfection(Integer survivorId);

//    List<Survivor> getInfectedSurvivors();
//    List<Survivor> getDisinfectedSurvivors();

       List<Survivor>getSurvivorsByInfectionStatus(boolean infected);

       double getPercentageInfectedSurvivors();
       double getPercentageDisinfectedSurvivors();
}
