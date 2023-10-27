package com.example.FelipeAutoCenter.repository;

import com.example.FelipeAutoCenter.Entities.AnnouncementEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<AnnouncementEntities, Long> {
}
