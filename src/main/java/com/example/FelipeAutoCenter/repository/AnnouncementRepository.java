package com.example.FelipeAutoCenter.repository;

import com.example.FelipeAutoCenter.Entities.AnnouncementEntities;
import com.example.FelipeAutoCenter.Entities.ClientsEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnnouncementRepository extends JpaRepository<AnnouncementEntities, Long> {
    List<AnnouncementEntities> findByowner(ClientsEntities owner);
}
