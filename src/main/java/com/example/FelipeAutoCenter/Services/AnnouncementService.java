package com.example.FelipeAutoCenter.Services;

import com.example.FelipeAutoCenter.Entities.AnnouncementEntities;
import com.example.FelipeAutoCenter.Entities.ClientsEntities;
import com.example.FelipeAutoCenter.repository.AnnouncementRepository;
import com.example.FelipeAutoCenter.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {


    @Autowired
    private AnnouncementRepository announcementRepository;
    @Autowired
    private ClientsRepository clientsRepository;


    public List<AnnouncementEntities> ShowAll() {
        return announcementRepository.findAll();
    }

    public List<AnnouncementEntities> showMyAnnoucecements(Long id_owner) {
        Optional<ClientsEntities> existOwner = clientsRepository.findById(id_owner);
        List<AnnouncementEntities> myAnnoucements = announcementRepository.findByowner(existOwner.get());
        if (!myAnnoucements.isEmpty()) {
            return myAnnoucements;
        } else {
            return null;
        }


    }

    public Boolean createAds(String brand, String description, String model, Double price, Double km, String color, Long year, Long modelYear, Long id_owner, byte[] imagesVehicle) throws IOException {
        Optional<ClientsEntities> findOwner = clientsRepository.findById(id_owner);
        if (findOwner.isPresent()) {
            AnnouncementEntities novoRegistro = new AnnouncementEntities(brand, description, model, price, km, color, year, modelYear, imagesVehicle, findOwner.get());
            announcementRepository.save(novoRegistro);
            return true;
        } else {
            return false;
        }
    }

    public Boolean patchAnnoucement(String brand, String description, String model, Double price, Double km, String color, Long year, Long modelYear, MultipartFile imageVehicle, Long idOwner, Long idAds) throws IOException {
        Optional<ClientsEntities> existOwner = clientsRepository.findById(idOwner);
        Optional<AnnouncementEntities> existAnnouncement = announcementRepository.findById(idAds);
        if (existOwner.isPresent() && existAnnouncement.isPresent()) {
            AnnouncementEntities patchingAnnouncement = new AnnouncementEntities(brand, description, model, price, km, color, year, modelYear, imageVehicle.getBytes(), existOwner.get(), idAds);
            announcementRepository.save(patchingAnnouncement);
            return true;
        } else {
            return false;
        }
    }


    public void deleteAnnoucement(Long idAds) {
        announcementRepository.deleteById(idAds);
    }


}
