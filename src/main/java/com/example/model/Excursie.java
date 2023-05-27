package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Excursie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String obirctivTuristic;
    private String numeCompanieTurism;
    private String oraPlecarii;
    private float pret;
    private int numarLocuriDisponibile;
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
