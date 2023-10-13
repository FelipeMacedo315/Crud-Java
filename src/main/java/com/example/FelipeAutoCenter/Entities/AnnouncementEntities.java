package com.example.FelipeAutoCenter.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AnnouncementEntities {

    @OneToMany(mappedBy = "announcementEntities")
    private List<ClientsEntities> clientsEntities = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnnouncement;
    private String brand;
    private String model;
    private Double price;
    private Double km;
    private String color;
    private LocalDateTime year;
    private LocalDateTime modelYear;

    public AnnouncementEntities() {

    }

    public Long getIdAnnouncement() {
        return idAnnouncement;
    }

    public void setIdAnnouncement(Long idAnnouncement) {
        this.idAnnouncement = idAnnouncement;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getYear() {
        return year;
    }

    public void setYear(LocalDateTime year) {
        this.year = year;
    }

    public LocalDateTime getModelYear() {
        return modelYear;
    }

    public void setModelYear(LocalDateTime modelYear) {
        this.modelYear = modelYear;
    }
}
