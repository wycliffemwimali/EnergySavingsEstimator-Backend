package com.example.reflectocalc.controller;

import com.example.reflectocalc.DTO.RooftopAreaDTO;
import com.example.reflectocalc.service.EnergySavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EnergySavingsController {

    private final EnergySavingsService energySavingsService;

    @Autowired
    public EnergySavingsController(EnergySavingsService energySavingsService) {
        this.energySavingsService = energySavingsService;
    }

    @GetMapping("/energy-savings/{rooftopId}")
    public ResponseEntity<Double> getEnergySavings(@PathVariable Long rooftopId) {
        double energySavings = energySavingsService.calculateEnergySavingsByRooftopId(rooftopId);
        return ResponseEntity.status(HttpStatus.OK).body(energySavings);
    }




}