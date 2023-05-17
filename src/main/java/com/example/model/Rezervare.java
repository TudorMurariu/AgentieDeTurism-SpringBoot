package com.example.model;

import java.util.UUID;

public class Rezervare extends Entity<UUID> {
    private Client client;
    private Excursie excursie;
    private int numarBileteDorite;

    public Rezervare(Client client, Excursie excursie, int numarBileteDorite) {
        this.client = client;
        this.excursie = excursie;
        this.numarBileteDorite = numarBileteDorite;
        this.setId(UUID.randomUUID());
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Excursie getExcursie() {
        return excursie;
    }

    public void setExcursie(Excursie excursie) {
        this.excursie = excursie;
    }

    public int getNumarBileteDorite() {
        return numarBileteDorite;
    }

    public void setNumarBileteDorite(int numarBileteDorite) {
        this.numarBileteDorite = numarBileteDorite;
    }

    @Override
    public String toString() {
        return "Rezervare{" +
                "id='" + this.getId() + '\'' +
                "client=" + client +
                ", excursie=" + excursie +
                ", numarBileteDorite=" + numarBileteDorite +
                '}';
    }
}
