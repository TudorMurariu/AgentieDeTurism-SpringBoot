package com.example.services;

import com.example.model.Excursie;
import com.example.model.User;

public interface Service {
    User authenticate(User user) throws Exception;

    void logout(User user);
    Iterable<Excursie> getExcursii();

    Iterable<Excursie> getExcursii(String numeObiectiv);

    Iterable<Excursie> getExcursii(String startTime, String endTime);

    Iterable<Excursie> getExcursii(String numeObiectiv, String startTime, String endTime);

    boolean rezervare(String numeClient, String numarDeTelefon, Excursie excursie, int numarBilete);

    Excursie getExcursie(String numeObiectiv, String numeCompanie, String oraPlecarii, float pret, int numarLocuriDisponibile);
}
