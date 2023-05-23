package com.example.services;

import com.example.model.Excursie;
import com.example.model.User;

public interface Service {
    User authenticate(User user) throws Exception;

    void logout(User user);
    Iterable<Excursie> getExcursii();

    boolean rezervare(String numeClient, String numarDeTelefon, Excursie excursie, int numarBilete);

}
