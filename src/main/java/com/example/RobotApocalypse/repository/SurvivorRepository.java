package com.example.RobotApocalypse.repository;

import com.example.RobotApocalypse.entity.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurvivorRepository  extends JpaRepository<Survivor, Integer> {
//    List<Survivor> findByInfectedTrue();
    List<Survivor> findByInfected(boolean infected);
    long countByInfected(boolean infected);
}
