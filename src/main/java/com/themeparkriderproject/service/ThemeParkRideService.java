package com.themeparkriderproject.service;

import com.themeparkriderproject.model.ThemeParkRide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.themeparkriderproject.repository.ThemeParkRideRepository;

import java.util.List;

@Service
public class ThemeParkRideService {
    private final ThemeParkRideRepository themeParkRideRepository;

    @Autowired
    public ThemeParkRideService(ThemeParkRideRepository themeParkRideRepository) {
        this.themeParkRideRepository = themeParkRideRepository;
    }

    public List<ThemeParkRide> findByName(String name) {
        return themeParkRideRepository.findByName(name);
    }
}
