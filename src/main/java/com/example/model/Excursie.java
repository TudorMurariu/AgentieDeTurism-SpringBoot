package com.example.model;

import java.util.UUID;

public class Excursie extends Entity<UUID> {
    private String obirctivTuristic;
    private String numeCompanieTurism;
    private String oraPlecarii;
    private float pret;
    private int numarLocuriDisponibile;

    public Excursie() {

    }

    public Excursie(UUID id, String obirctivTuristic, String numeCompanieTurism, String oraPlecarii, float pret, int numarLocuriDisponibile) {
        this.obirctivTuristic = obirctivTuristic;
        this.numeCompanieTurism = numeCompanieTurism;
        this.oraPlecarii = oraPlecarii;
        this.pret = pret;
        this.numarLocuriDisponibile = numarLocuriDisponibile;
        this.setId(id);
    }

    public Excursie(String obirctivTuristic, String numeCompanieTurism, String oraPlecarii, float pret, int numarLocuriDisponibile) {
        this.obirctivTuristic = obirctivTuristic;
        this.numeCompanieTurism = numeCompanieTurism;
        this.oraPlecarii = oraPlecarii;
        this.pret = pret;
        this.numarLocuriDisponibile = numarLocuriDisponibile;
        this.setId(UUID.randomUUID());
    }

    public String getObirctivTuristic() {
        return obirctivTuristic;
    }

    public void setObirctivTuristic(String obirctivTuristic) {
        this.obirctivTuristic = obirctivTuristic;
    }

    public String getNumeCompanieTurism() {
        return numeCompanieTurism;
    }

    public void setNumeCompanieTurism(String numeCompanieTurism) {
        this.numeCompanieTurism = numeCompanieTurism;
    }

    public String getOraPlecarii() {
        return oraPlecarii;
    }

    public void setOraPlecarii(String oraPlecarii) {
        this.oraPlecarii = oraPlecarii;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public int getNumarLocuriDisponibile() {
        return numarLocuriDisponibile;
    }

    public void setNumarLocuriDisponibile(int numarLocuriDisponibile) {
        this.numarLocuriDisponibile = numarLocuriDisponibile;
    }

    @Override
    public String toString() {
        return "Excursie{" +
                "id='" + this.getId() + '\'' +
                "obirctivTuristic='" + obirctivTuristic + '\'' +
                ", numeCompanieTurism='" + numeCompanieTurism + '\'' +
                ", oraPlecarii=" + oraPlecarii +
                ", pret=" + pret +
                ", numarLocuriDisponibile=" + numarLocuriDisponibile +
                '}';
    }
}
