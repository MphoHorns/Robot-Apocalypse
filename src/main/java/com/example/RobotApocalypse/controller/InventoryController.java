package com.example.RobotApocalypse.controller;

import com.example.RobotApocalypse.entity.Inventory;
import com.example.RobotApocalypse.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventories")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory){
       Inventory savedInventory = inventoryService.saveInventory(inventory);
       return new ResponseEntity<>(savedInventory, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id){
        Inventory inventory = inventoryService.getInventoryById(id);
        if(inventory!=null){
            return new ResponseEntity<>(inventory, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
