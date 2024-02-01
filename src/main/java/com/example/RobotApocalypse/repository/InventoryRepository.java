package com.example.RobotApocalypse.repository;

import com.example.RobotApocalypse.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
