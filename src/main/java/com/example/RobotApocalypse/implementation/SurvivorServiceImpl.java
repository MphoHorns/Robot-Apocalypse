package com.example.RobotApocalypse.implementation;

import com.example.RobotApocalypse.entity.Survivor;
import com.example.RobotApocalypse.repository.SurvivorRepository;
import com.example.RobotApocalypse.service.SurvivorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurvivorServiceImpl implements SurvivorService {
    public SurvivorRepository survivorRepository;

    @Autowired
    public SurvivorServiceImpl(SurvivorRepository survivorRepository){
        this.survivorRepository = survivorRepository;
    }
    @Override
    public List<Survivor> getAllSurvivors(){
        return survivorRepository.findAll();
    }
    @Override
    public Survivor getSurvivorById(Integer id){
        Optional<Survivor> optionalSurvivor = survivorRepository.findById(id);
        return optionalSurvivor.orElse(null);
    }
    @Override
    public Survivor addSurvivor(Survivor survivor){
        return survivorRepository.save(survivor);
    }
//    @Override
//    public Survivor updateSurvivor(Integer id, Survivor survivor){
//        if(survivorRepository.existsById(id)){
//            survivor.setId(id);
//            return survivorRepository.save(survivor);
//        }
//        else {
//            return null;
//        }
//    }

    @Override
    public void updateSurvivorLocation(Integer id, float latitude, float longitude){
     Optional<Survivor> survivorOptional = survivorRepository.findById(id);
     survivorOptional.ifPresent(survivor -> {
         survivor.setLatitude(latitude);
         survivor.setLongitude(longitude);
         survivorRepository.save(survivor);
     });
    }

    @Override
    @Transactional
    public void reportInfection(Integer survivorId){
        Optional<Survivor> optionalSurvivor = survivorRepository.findById(survivorId);
        if(optionalSurvivor.isPresent()){
            Survivor survivor = optionalSurvivor.get();
            survivor.setInfectionCounter(survivor.getInfectionCounter() + 1);

            if(survivor.getInfectionCounter() >= 3){
                survivor.setInfected(true);
            }
            survivorRepository.save(survivor);
        }
        else {
            throw new EntityNotFoundException("Survivor with Id "+ survivorId +" not found.");
        }
    }

    @Override
    @Transactional
    public List<Survivor> getSurvivorsByInfectionStatus(boolean infected){
        return survivorRepository.findByInfected(infected);
    }

// @Override
//    public List<Survivor> getInfectedSurvivors(){
//        return survivorRepository.findByInfectedTrue();
// }

    @Override
    public double getPercentageInfectedSurvivors(){
        long totalSurvivors = survivorRepository.count();
        long infectedSurvivors = survivorRepository.countByInfected(true);
        return (double) infectedSurvivors / totalSurvivors * 100;
    }

    @Override
    public double getPercentageDisinfectedSurvivors(){
        return  100 - getPercentageInfectedSurvivors();
    }

}
