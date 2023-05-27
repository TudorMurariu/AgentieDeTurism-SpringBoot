package com.example.services;

import com.example.model.Excursie;
import com.example.repository.ExcursieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
public class ExcursieServiceImp implements ExcursieService {
    private final ExcursieRepo excursieRepo;
    @Override
    public Iterable<Excursie> getAll() {
        return excursieRepo.findAll();
    }

    @Override
    public Excursie getById(UUID id) {
        Optional<Excursie> excursie = excursieRepo.findById(id);
        return excursie.orElse(null);
    }

    @Override
    public void create(Excursie excursie) {
        excursieRepo.save(excursie);
    }

    @Override
    public void update(Excursie excursie) {
        excursieRepo.save(excursie);
    }

    @Override
    public void delete(Excursie excursie) {
        excursieRepo.delete(excursie);
    }

    @Override
    public Iterable<Excursie> getFilter(String obiectiv, String ora) {
        return excursieRepo.findByObirctivTuristicAndOraPlecarii(obiectiv, ora);
    }
}
