package com.example.services;

import com.example.model.Excursie;

import java.util.UUID;

public interface ExcursieService {
    Iterable<Excursie> getAll();
    Excursie getById(UUID id);
    Excursie create(Excursie excursie);
    Excursie update(Excursie excursie);
    void delete(Excursie excursie);
    Iterable<Excursie> getFilter(String obiectiv, String ora);
}
