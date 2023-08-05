package com.example.reflectocalc.controller;

import com.example.reflectocalc.DTO.RooftopAreaDTO;
import com.example.reflectocalc.model.Rooftop;
import com.example.reflectocalc.service.RooftopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*") // Replace with the actual URL of your frontend
@RequestMapping("/api/rooftop")
public class RooftopController {
    private final RooftopService rooftopService;

    @Autowired
    public RooftopController(RooftopService rooftopService) {
        this.rooftopService = rooftopService;
    }

    @PostMapping("/area")
    public ResponseEntity<Rooftop> saveRooftopArea(@RequestBody RooftopAreaDTO rooftopAreaDTO) {
        double rooftopArea = rooftopAreaDTO.getArea();
        double rooftopReflectance = rooftopAreaDTO.getReflectance();
        String rooftopMaterial = rooftopAreaDTO.getMaterial();

        // Create a Rooftop object and set the area, reflectance, and material
        Rooftop rooftop = new Rooftop();
        rooftop.setArea(rooftopArea);
        rooftop.setReflectance(rooftopReflectance);
        rooftop.setMaterial(rooftopMaterial);

        // Save the rooftop object to the database
        Rooftop savedRooftop = rooftopService.saveRooftop(rooftop);

        return ResponseEntity.ok().body(savedRooftop);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Rooftop> getRooftopById(@PathVariable Long id) {
        Rooftop rooftop = rooftopService.getRooftopById(id);
        if (rooftop != null) {
            return ResponseEntity.ok(rooftop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/latest-rooftop")
    public ResponseEntity<Long> getLatestRooftopId() {
        Long latestRooftopId = rooftopService.getLatestRooftopId();
        return ResponseEntity.ok(latestRooftopId);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Rooftop> updateRooftop(@PathVariable Long id, @RequestBody Rooftop updatedRooftop) {
        Rooftop rooftop = rooftopService.getRooftopById(id);

        if (rooftop == null) {
            return ResponseEntity.notFound().build();
        }

        rooftop.setArea(updatedRooftop.getArea());
        rooftop.setReflectance(updatedRooftop.getReflectance());

        updatedRooftop = rooftopService.saveRooftop(rooftop);
        return ResponseEntity.ok(updatedRooftop);
    }
}

