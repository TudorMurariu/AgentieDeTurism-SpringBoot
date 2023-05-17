package com.example.services;

import com.example.model.Client;
import com.example.model.Excursie;
import com.example.model.Rezervare;
import com.example.model.User;
import com.example.repository.ClientRepo;
import com.example.repository.ExcursieRepo;
import com.example.repository.RezervareRepo;
import com.example.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class ServiceManager implements Service {

    private UserRepo userRepo;

    private ClientRepo clientRepo;

    private ExcursieRepo excursieRepo;

    private RezervareRepo rezervareRepo;

    public ServiceManager(UserRepo userRepo, ClientRepo clientRepo, ExcursieRepo excursieRepo, RezervareRepo rezervareRepo) {
        this.userRepo = userRepo;
        this.clientRepo = clientRepo;
        this.excursieRepo = excursieRepo;
        this.rezervareRepo = rezervareRepo;
    }

    @Override
    public User authenticate(User user) throws Exception {
        User user1 = userRepo.findByUserName(user.getUserName());
        System.out.println("user: " + user1);
        if(user1 == null)
            throw new Exception("There is no user with this Name.");
        else if(!user1.getPassword().equals(user.getPassword()))
            throw new Exception("The password is incorrect.");

        return user1;
    }

    @Override
    public void logout(User user) {

    }

    @Override
    public Iterable<Excursie> getExcursii() {
        return excursieRepo.findAll();
    }

    @Override
    public Iterable<Excursie> getExcursii(String numeObiectiv) {
        return excursieRepo.findFiltered(numeObiectiv);
    }

    @Override
    public Iterable<Excursie> getExcursii(String startTime, String endTime) {
        return excursieRepo.findFiltered(startTime, endTime);
    }

    @Override
    public Iterable<Excursie> getExcursii(String numeObiectiv, String startTime, String endTime) {
        return excursieRepo.findFiltered(numeObiectiv, startTime, endTime);
    }

    @Override
    public boolean rezervare(String numeClient, String numarDeTelefon,Excursie excursie, int numarBilete) {
        if(numarBilete > excursie.getNumarLocuriDisponibile())
            return false;

        Client client = clientRepo.findByName(numeClient);

        if(client == null) {
            client = new Client(numeClient, numarDeTelefon);
            clientRepo.save(client);
        }

        rezervareRepo.save(new Rezervare(client, excursie, numarBilete));
        return true;
    }

    @Override
    public Excursie getExcursie(String numeObiectiv, String numeCompanie, String oraPlecarii, float pret, int numarLocuriDisponibile) {
        for(Excursie e : excursieRepo.findFiltered(numeObiectiv)) {
            if(e.getNumeCompanieTurism().equals(numeCompanie) && e.getOraPlecarii().equals(oraPlecarii) && e.getPret() == pret && e.getNumarLocuriDisponibile() == numarLocuriDisponibile)
                return e;
        }
        return null;
    }
}
