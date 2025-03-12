package org.example.kino_marts.controller;

import org.example.kino_marts.model.Actor;
import org.example.kino_marts.repository.ActorRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342") // Juster porten hvis nødvendigt
@RestController
@RequestMapping("/api/actors")
public class ActorController {
    private final ActorRepo actorRepo;

    public ActorController(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    // Hent alle skuespillere
    @GetMapping
    public List<Actor> getAllActors() {
        List<Actor> actors = actorRepo.findAll();
        System.out.println("DEBUG: " + actors);
        return actors;
    }

    // Hent en specifik skuespiller via ID
    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable int id) {
        return actorRepo.findById(id).orElse(null);
    }

    // Opret en ny skuespiller
    @PostMapping
    public Actor createActor(@RequestBody Actor actor) {
        return actorRepo.save(actor);
    }

    // Slet en skuespiller via ID
    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable int id) {
        actorRepo.deleteById(id);
    }
}
