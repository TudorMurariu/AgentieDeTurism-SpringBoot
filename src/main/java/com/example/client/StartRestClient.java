package com.example.client;

import com.example.model.Excursie;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class StartRestClient {
    private static final ExcursieClient excursieClient = new ExcursieClient();
    public static void main(String[] args) {
        AtomicReference<Excursie> e1 = new AtomicReference<>(new Excursie(UUID.fromString("0ff9f51e-b231-45cd-8783-2c39908483d9"), "Casa lui Ion Creanga", "HolidayFun", "10:00", 52.5f, 12));
        AtomicReference<Excursie> e2 = new AtomicReference<>(new Excursie(UUID.randomUUID(), "Cetatea Neamtului", "HolidayFun", "14:00", 20f, 0));

        RestTemplate restTemplate = new RestTemplate();

        try {

            show(() -> {
                e1.set(excursieClient.create(e1.get()));
                System.out.println(e1.get());
            });
            show(() -> {
                e2.set(excursieClient.create(e2.get()));
                System.out.println(e2.get());
            });

            System.out.println("AAAAAAAAAAAAAAAAAAAAA");
            System.out.println(e1.get());
            System.out.println(e2.get());
            System.out.println("AAAAAAAAAAAAAAAAAAAAA");

            show(() -> {
                Excursie[] excursii = excursieClient.getAll();

                for(Excursie e : excursii)
                    System.out.println(e + "-----------------");
            });

            show(() -> {
                Excursie[] excursii = excursieClient.filter(e2.get().getObiectivTuristic(), e2.get().getOraPlecarii());

                for(Excursie e : excursii)
                    System.out.println(e + "-----------------");
            });

            show(() -> System.out.println(excursieClient.getById(e1.get().getId())));

            e1.get().setPret(666);
            show(() -> System.out.println(excursieClient.update(e1.get())));

            show(() -> {
                Excursie[] excursii = excursieClient.getAll();

                for(Excursie e : excursii)
                    System.out.println(e + "-----------------");
            });

            show(() -> System.out.println(excursieClient.delete(e1.get())));

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
