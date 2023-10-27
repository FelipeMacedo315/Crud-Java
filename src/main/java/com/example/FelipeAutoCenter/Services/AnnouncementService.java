package com.example.FelipeAutoCenter.Services;

import com.example.FelipeAutoCenter.Entities.AnnouncementEntities;
import com.example.FelipeAutoCenter.Entities.ClientsEntities;
import com.example.FelipeAutoCenter.repository.AnnouncementRepository;
import com.example.FelipeAutoCenter.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Boolean createAds(String brand, String model, Double price, Double km, String color, Long year, Long modelYear, Long id_owner,List<byte[]> convertImages) {
        Optional<ClientsEntities> findOwner = clientsRepository.findById(id_owner);
        if (findOwner.isPresent()) {
            AnnouncementEntities novoRegistro = new AnnouncementEntities(brand, model, price, km, color, year, modelYear, findOwner.get(),convertImages);
            announcementRepository.save(novoRegistro);
            return true;
        } else {
            return false;
        }
    }
}
