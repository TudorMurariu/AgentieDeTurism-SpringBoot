package com.example.controller;

import com.example.model.Excursie;
import com.example.services.ExcursieServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/excursie")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ExcursieController {
    private final ExcursieServiceImp excursieService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Excursie> getAll()
    {
        return excursieService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable UUID id)
    {
        Excursie e = excursieService.getById(id);
        if(e == null)
            return new ResponseEntity<String>("There is no user with this id.", HttpStatus.NOT_FOUND);

        return new ResponseEntity<Excursie>(e, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Excursie create(@RequestBody Excursie excursie) {
        excursieService.create(excursie);
        return excursie;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Excursie update(@RequestBody Excursie excursie) {
        excursieService.update(excursie);
        return excursie;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable String id) {
        System.out.println(id + " ________________");
        try {
            Excursie excursie = new Excursie();
            excursie.setId(UUID.fromString(id));
            excursieService.delete(excursie);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("The entity has been deleted", HttpStatus.OK);
    }

    @RequestMapping(value = "/filter",method = RequestMethod.GET)
    public Iterable<Excursie> getFilter(@RequestParam Optional<String> obiectiv, @RequestParam Optional<String> ora)
    {
        if(obiectiv.isEmpty() || ora.isEmpty())
            return excursieService.getAll();
        return excursieService.getFilter(obiectiv.get(), ora.get());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String excursieError(Exception e) {
        return e.getMessage();
    }
}
