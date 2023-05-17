package com.example.controller;

import com.example.model.Excursie;
import com.example.repository.ExcursieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/excursie")
@RequiredArgsConstructor
public class ExcursieController {

    @Autowired
    private ExcursieRepo excursieRepo;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Excursie> getAll()
    {
        return excursieRepo.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable UUID id)
    {
        Excursie e = excursieRepo.findOne(id);
        if(e == null)
            return new ResponseEntity<String>("There is no user with this id.", HttpStatus.NOT_FOUND);

        return new ResponseEntity<Excursie>(e, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Excursie create(@RequestBody Excursie excursie) {
        excursieRepo.save(excursie);
        return excursie;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Excursie update(@RequestBody Excursie excursie) {
        excursieRepo.update(excursie.getId(), excursie);
        return excursie;
    }

    @RequestMapping(value = "/{obirctivTuristic}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody String obirctivTuristic) {
        try {
            excursieRepo.delete(obirctivTuristic);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("The entity has been deleted", HttpStatus.OK);;
    }
}