package com.example.reflectocalc.controller;

import com.example.reflectocalc.model.Rooftop;
import com.example.reflectocalc.service.RooftopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooftops")
public class RooftopController {
    private final RooftopService rooftopService;

    @Autowired
    public RooftopController(RooftopService rooftopService) {
        this.rooftopService = rooftopService;
    }

    @GetMapping("/building/{buildingId}")
    public ResponseEntity<List<Rooftop>> getRooftopsByBuildingId(@PathVariable Long buildingId) {
        List<Rooftop> rooftops = rooftopService.getRooftopsByBuildingId(buildingId);
        return ResponseEntity.ok(rooftops);
    }

    @GetMapping("/{rooftopId}/area")
    public ResponseEntity<Double> getRooftopArea(@PathVariable Long rooftopId) {
        double rooftopArea = rooftopService.getRooftopArea(rooftopId);
        return ResponseEntity.ok(rooftopArea);
    }

    // Add more methods as needed
}

