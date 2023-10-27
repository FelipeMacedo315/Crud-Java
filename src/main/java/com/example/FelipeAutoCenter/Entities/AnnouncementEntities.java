package com.example.FelipeAutoCenter.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AnnouncementEntities {

    @ManyToOne
    @JoinColumn(name = "id_owner")
    private ClientsEntities owner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnnouncement;
    private String brand;
    private String model;
    private Double price;
    private Double km;
    private String color;
    private Long year;
    private Long modelYear;

    @Lob
    @Column (columnDefinition = "LONGBLOB")
    private List<byte[]> imagesVehicle;

    public AnnouncementEntities(String brand, String model, Double price, Double km, String color, Long year, Long modelYear, ClientsEntities clientsEntities, List<byte[]> convertImages) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.km = km;
        this.color = color;
        this.year = year;
        this.modelYear = modelYear;
        this.setOwner(clientsEntities);
        this.setImagesVehicle(convertImages);

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

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getModelYear() {
        return modelYear;
    }

    public void setModelYear(Long modelYear) {
        this.modelYear = modelYear;
    }

    public ClientsEntities getOwner() {
        return owner;
    }

    public void setOwner(ClientsEntities owner) {
        this.owner = owner;
    }

    public List<byte[]> getImagesVehicle() {
        return imagesVehicle;
    }

    public void setImagesVehicle(List<byte[]> imagesVehicle) {
        this.imagesVehicle = imagesVehicle;
    }


}
