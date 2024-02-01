package com.example.RobotApocalypse.entity;

import jakarta.persistence.*;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "survivor_id")
    private Survivor survivor;
    @Column(name = "hasWater")
    private boolean hasWater;
    @Column(name = "hasFood")
    private boolean hasFood;
    @Column(name = "hasMedication")
    private boolean hasMedication;
    @Column(name = "hasAmmunition")
    private boolean hasAmmunition;

    public Inventory() {
    }

    public Inventory(boolean hasWater, boolean hasFood, boolean hasMedication, boolean hasAmmunition) {
        this.hasWater = hasWater;
        this.hasFood = hasFood;
        this.hasMedication = hasMedication;
        this.hasAmmunition = hasAmmunition;
    }

    public boolean isHasWater() {
        return hasWater;
    }

    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }

    public boolean isHasFood() {
        return hasFood;
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public boolean isHasMedication() {
        return hasMedication;
    }

    public void setHasMedication(boolean hasMedication) {
        this.hasMedication = hasMedication;
    }

    public boolean isHasAmmunition() {
        return hasAmmunition;
    }

    public void setHasAmmunition(boolean hasAmmunition) {
        this.hasAmmunition = hasAmmunition;
    }
}
