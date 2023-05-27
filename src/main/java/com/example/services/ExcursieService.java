package com.example.services;

import com.example.model.Excursie;

import java.util.UUID;

public interface ExcursieService {
    Iterable<Excursie> getAll();
    Excursie getById(UUID id);
    void create(Excursie excursie);
    void update(Excursie excursie);
    void delete(Excursie excursie);
    Iterable<Excursie> getFilter(String obiectiv, String ora);
}
