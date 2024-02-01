package com.example.RobotApocalypse.controller;


import com.example.RobotApocalypse.entity.Survivor;
import com.example.RobotApocalypse.request.SurvivorUpdateRequest;
import com.example.RobotApocalypse.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/survivors")
public class SurvivorController {
 public final SurvivorService survivorService;

    @Autowired
    public SurvivorController(SurvivorService survivorService) {
        this.survivorService = survivorService;
    }
   @GetMapping
   public ResponseEntity<List<Survivor>> getAllSurvivors(){
     List<Survivor> survivors = survivorService.getAllSurvivors();
     return new ResponseEntity<>(survivors, HttpStatus.OK);
   }
   @GetMapping("/{id}")
   public ResponseEntity<Survivor> getSurvivorById(@PathVariable Integer id){
     Survivor survivor = survivorService.getSurvivorById(id);
     return new ResponseEntity<>(survivor, HttpStatus.OK);
   }
   @PostMapping
   public ResponseEntity<Survivor> addSurvivor(@RequestBody Survivor survivor){
     Survivor newSurvivor = survivorService.addSurvivor(survivor);
     return  new ResponseEntity<>(survivor, HttpStatus.CREATED);
   }
//   @PutMapping("/{id}")
//   public ResponseEntity<Survivor> updateSurvivor(@PathVariable Integer id, @RequestBody Survivor survivor){
//    Survivor updatedSurvivor = survivorService.updateSurvivor(id, survivor);
//    return new ResponseEntity<>(updatedSurvivor, HttpStatus.OK);
//   }

 @PatchMapping("/{id}")
 public ResponseEntity<String> updateSurvivorLocation(@PathVariable Integer id, @RequestBody SurvivorUpdateRequest request){
     try{
         survivorService.updateSurvivorLocation(id, request.getLatitude(), request.getLongitude());
         return ResponseEntity.ok("Survivor location updated successfully");
     } catch (Exception e){
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update survivor location.");
     }
 }

 @PutMapping("/{id}/report-infection")
    public ResponseEntity<String> reportInfection(@PathVariable Integer id){
        survivorService.reportInfection(id);
        return ResponseEntity.ok("Survivor infection reported successfully.");
 }

 @GetMapping("/infected")
 public ResponseEntity<List<Survivor>> getInfectedSurvivors(){
        List<Survivor> infectedSurvivors = survivorService.getSurvivorsByInfectionStatus(true);
        return ResponseEntity.ok(infectedSurvivors);
 }

 @GetMapping("/disinfected")
    public ResponseEntity<List<Survivor>> getDisinfectedSurvivors(){
        List<Survivor> disinfectedSurvivors = survivorService.getSurvivorsByInfectionStatus(false);
        return ResponseEntity.ok(disinfectedSurvivors);
 }

 @GetMapping("/infected-percentage")
    public ResponseEntity<Double> getPercentageInfectedSurvivors(){
        double infectedPercentage = survivorService.getPercentageInfectedSurvivors();
        return ResponseEntity.ok(infectedPercentage);
 }

 @GetMapping("/disinfected-percentage")
    public ResponseEntity<Double> getPercentageDisinfectedSurvivors(){
        double disinfectedPercentage = survivorService.getPercentageDisinfectedSurvivors();
        return ResponseEntity.ok(disinfectedPercentage);
 }

}
