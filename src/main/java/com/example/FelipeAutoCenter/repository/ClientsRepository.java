package com.example.FelipeAutoCenter.repository;

import com.example.FelipeAutoCenter.Entities.ClientsEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<ClientsEntities, Long> {

}
