package com.example.client;

import com.example.model.Excursie;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;
import java.util.concurrent.Callable;

public class ExcursieClient {
    private final static String URI = "http://localhost:8080/excursie";
    private RestTemplate restTemplate = new RestTemplate();

    private <T> T execute(Callable<T> callable) {
        try {
            return callable.call();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public Excursie[] getAll() {
        return execute(() -> restTemplate.getForObject(URI, Excursie[].class));
    }

    public Excursie getById(UUID id) {
        return execute(() -> restTemplate.getForObject(String.format("%s/%s", URI, id.toString()), Excursie.class));
    }

    public Excursie create(Excursie excursie) {
        return execute(() -> restTemplate.postForObject(URI, excursie, Excursie.class));
    }

    public Excursie update(Excursie excursie) {
        return execute(() -> {
            restTemplate.put(String.format("%s/%s", URI, excursie.getId()), excursie);
            return null;
        });
    }

    public Excursie delete(Excursie excursie) {
        return execute(() -> {
            restTemplate.delete(String.format("%s/%s", URI, excursie.getId()));
            return null;
        });
    }

    public Excursie[] filter(Excursie excursie) {
        return execute(() ->
            restTemplate.getForObject(URI + "/filter", Excursie[].class, excursie)
        );
    }
}
