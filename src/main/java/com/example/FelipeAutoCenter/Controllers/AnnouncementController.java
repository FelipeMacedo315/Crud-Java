package com.example.FelipeAutoCenter.Controllers;

import com.example.FelipeAutoCenter.Entities.AnnouncementEntities;
import com.example.FelipeAutoCenter.Services.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

@RestController
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping(path = "/ads/show-all-announcement")
    public ResponseEntity ShowAllAnnouncement() {
        List<AnnouncementEntities> allAnnouncement = announcementService.ShowAll();
        return ResponseEntity.ok().body(allAnnouncement);
    }

    @PostMapping(path = "/ads/create/{id_owner}")
    public ResponseEntity PostAds(@RequestParam String brand, String description, String model, Double price, Double km, String color, Long year, Long modelYear, @RequestPart MultipartFile imageVehicle, @PathVariable Long id_owner) throws URISyntaxException, IOException {
        URI uri = new URI("http://localhost:8080/ads/create/");
        Boolean response = announcementService.createAds(brand, description, model, price, km, color, year, modelYear, id_owner, imageVehicle.getBytes());
        if (response && !imageVehicle.isEmpty()) {
            return ResponseEntity.created(uri).body("Ads created with sucessfull");
        } else {
            return ResponseEntity.status(404).body("Ads not created");
        }
    }

    @PatchMapping(path = "/ads/update/owner-{id_owner}/ads-{id_ads}")
    public ResponseEntity UpdateAds(@RequestParam String brand, String description, String model, Double price, Double km, String color, Long year, Long modelYear, @RequestPart MultipartFile imageVehicle, @PathVariable Long id_owner, @PathVariable Long id_ads) throws IOException {
        System.out.println("ID CLIENT:" + id_owner + "ID ANUNCIO" + id_ads);
        Boolean response = announcementService.patchAnnoucement(brand, description, model, price, km, color, year, modelYear, imageVehicle, id_owner, id_ads);
        if (response) {
            return ResponseEntity.ok().body("Announcement update with sucessfull");
        } else {
            return ResponseEntity.status(404).body("Unable updated annoucement");
        }
    }
}
