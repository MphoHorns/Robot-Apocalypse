package com.example.RobotApocalypse.implementation;

import com.example.RobotApocalypse.entity.Inventory;
import com.example.RobotApocalypse.repository.InventoryRepository;
import com.example.RobotApocalypse.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory saveInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getInventoryById(Long id){
        Optional<Inventory> optionalInventory= inventoryRepository.findById(id);
        return optionalInventory.orElse(null);
    }
}
