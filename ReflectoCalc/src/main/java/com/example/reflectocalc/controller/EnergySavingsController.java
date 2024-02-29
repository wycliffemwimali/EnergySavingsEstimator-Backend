package com.example.reflectocalc.controller;

import com.example.reflectocalc.DTO.RooftopAreaDTO;
import com.example.reflectocalc.Repository.EnergySavingsRepository;
import com.example.reflectocalc.model.EnergySavings;
import com.example.reflectocalc.service.EnergySavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EnergySavingsController {

    private final EnergySavingsService energySavingsService;
    private final EnergySavingsRepository energySavingsRepository;

    @Autowired
    public EnergySavingsController(EnergySavingsService energySavingsService, EnergySavingsRepository energySavingsRepository) {
        this.energySavingsService = energySavingsService;
        this.energySavingsRepository = energySavingsRepository;
    }

    @GetMapping("/energy-savings/{rooftopId}")
    public ResponseEntity<Double> getEnergySavings(@PathVariable Long rooftopId) {
        double energySavings = energySavingsService.calculateEnergySavingsByRooftopId(rooftopId);

        // Save data to the database
        EnergySavings entity = new EnergySavings();
        entity.setRooftopId(rooftopId);
        entity.setEnergySavings(energySavings);
        energySavingsRepository.save(entity);

        return ResponseEntity.status(HttpStatus.OK).body(energySavings);
    }





}
