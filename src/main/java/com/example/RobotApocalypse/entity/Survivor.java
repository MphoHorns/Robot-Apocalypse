package com.example.RobotApocalypse.entity;

import com.example.RobotApocalypse.enumeration.Gender;
import jakarta.persistence.*;

@Entity
public class Survivor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
  private String name;
  private int age;
  @Enumerated(EnumType.STRING)
  private Gender gender;
  private float latitude;
  private  float longitude;

    @Column(name = "infectionCounter")
    private int infectionCounter;
    @Column(name = "infected")
    private boolean infected;

  @OneToOne(mappedBy = "survivor", cascade = CascadeType.ALL)
  private Inventory inventory;
    public Survivor() {
    }

    public Survivor(String name, int age, Gender gender, float latitude, float longitude) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Survivor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public int getInfectionCounter() {
        return infectionCounter;
    }

    public void setInfectionCounter(int infectionCounter) {
        this.infectionCounter = infectionCounter;
    }
    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }
}
