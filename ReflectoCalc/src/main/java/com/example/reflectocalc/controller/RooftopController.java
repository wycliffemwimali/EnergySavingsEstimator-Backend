package com.example.reflectocalc.controller;

import com.example.reflectocalc.DTO.RooftopAreaDTO;
import com.example.reflectocalc.model.Rooftop;
import com.example.reflectocalc.service.RooftopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

        // Create a Rooftop object and save it to the database
        Rooftop rooftop = new Rooftop();
        rooftop.setArea(rooftopArea);
        Rooftop savedRooftop = rooftopService.saveRooftop(rooftop);

        return ResponseEntity.ok(savedRooftop);
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

