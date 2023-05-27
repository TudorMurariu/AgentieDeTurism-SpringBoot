package com.example.repository;

import com.example.model.Excursie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ExcursieRepo extends JpaRepository<Excursie, UUID> {
    List<Excursie> findByObirctivTuristicAndOraPlecarii(String obirctivTuristic, String oraPlecarii);
}
