package com.example.RobotApocalypse.service;

import com.example.RobotApocalypse.entity.Inventory;

public interface InventoryService {
    Inventory saveInventory(Inventory inventory);
    Inventory getInventoryById(Long id);

}
