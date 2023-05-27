package com.example.client;

import com.example.model.Excursie;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

public class StartRestClient {
    private static final ExcursieClient excursieClient = new ExcursieClient();
    public static void main(String[] args) {
        Excursie e1 = new Excursie(UUID.fromString("0ff9f51e-b231-45cd-8783-2c39908483d9"), "Casa lui Ion Creanga", "HolidayFun", "10:00", 52.5f, 12);
        Excursie e2 = new Excursie(UUID.randomUUID(), "Cetatea Neamtului", "HolidayFun", "14:00", 20f, 0);

        RestTemplate restTemplate = new RestTemplate();

        try {

            show(() -> System.out.println(excursieClient.create(e1)));
            show(() -> System.out.println(excursieClient.create(e2)));

            show(() -> {
                Excursie[] excursii = excursieClient.getAll();

                for(Excursie e : excursii)
                    System.out.println(e + "-----------------");
            });

            show(() -> {
                Excursie[] excursii = excursieClient.filter(e2.getObirctivTuristic(), e2.getOraPlecarii());

                for(Excursie e : excursii)
                    System.out.println(e + "-----------------");
            });

            show(() -> System.out.println(excursieClient.getById(e1.getId())));

            e1.setPret(666);
            show(() -> System.out.println(excursieClient.update(e1)));

            show(() -> {
                Excursie[] excursii = excursieClient.getAll();

                for(Excursie e : excursii)
                    System.out.println(e + "-----------------");
            });

            show(() -> System.out.println(excursieClient.delete(e1)));

            show(() -> {
                Excursie[] excursii = excursieClient.getAll();

                for(Excursie e : excursii)
                    System.out.println(e + "-----------------");
            });



        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void show(Runnable task) {
        try {
            task.run();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
