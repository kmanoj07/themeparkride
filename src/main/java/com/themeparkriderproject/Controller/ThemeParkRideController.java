package com.themeparkriderproject.Controller;

import com.themeparkriderproject.model.ThemeParkRide;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.themeparkriderproject.repository.ThemeParkRideRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/themepark")
public class ThemeParkRideController {
    private final ThemeParkRideRepository themeParkRideRepository;
    public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository) {
        this.themeParkRideRepository = themeParkRideRepository;
    }
    @GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ThemeParkRide> getRides() {
        return themeParkRideRepository.findAll();
    }
    @GetMapping(value = "/ride/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide getRide(@PathVariable long id) {
        return themeParkRideRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }
    @GetMapping(value = "/ride/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ThemeParkRide> getRideByName(@PathVariable String name) {
        return themeParkRideRepository.findByName(name);
    }
    @PostMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide themeParkRide) {
        return themeParkRideRepository.save(themeParkRide);
    }
}
