package com.example.model;

import java.util.UUID;

public class Client extends Entity<UUID> {
    private String numeClient;
    private String numarDeTelefon;

    public Client(String numeClient, String numarDeTelefon) {
        this.numeClient = numeClient;
        this.numarDeTelefon = numarDeTelefon;
        this.setId(UUID.randomUUID());
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public String getNumarDeTelefon() {
        return numarDeTelefon;
    }

    public void setNumarDeTelefon(String numarDeTelefon) {
        this.numarDeTelefon = numarDeTelefon;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + this.getId() + '\'' +
                "numeClient='" + numeClient + '\'' +
                ", numarDeTelefon='" + numarDeTelefon + '\'' +
                '}';
    }
}
