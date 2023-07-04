package com.example.reflectocalc.service;

import com.example.reflectocalc.Repository.RooftopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.reflectocalc.model.Rooftop;


import java.util.List;

@Service
public class RooftopServiceImpl implements RooftopService {
    private final RooftopRepository rooftopRepository;

    @Autowired
    public RooftopServiceImpl(RooftopRepository rooftopRepository) {
        this.rooftopRepository = rooftopRepository;
    }

    @Override
    public List<Rooftop> getRooftopsByBuildingId(Long buildingId) {
        return rooftopRepository.findByBuildingId(buildingId);
    }

    @Override
    public double getRooftopArea(Long rooftopId) {
        Rooftop rooftop = rooftopRepository.findById(rooftopId).orElse(null);
        return (rooftop != null) ? rooftop.getArea() : 0.0;
    }

    // Add more methods as needed
}
