package com.example.reflectocalc.service;

import com.example.reflectocalc.Repository.RooftopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.reflectocalc.model.Rooftop;


import java.util.List;

@Service
public class RooftopServiceImpl implements RooftopService {
    private final RooftopRepository rooftopRepository;
    private static final double CONSTANT_FACTOR = 0.5;

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

    @Override
    public Rooftop saveRooftop(Rooftop rooftop) {
        return rooftopRepository.save(rooftop);
    }

    @Override
    public Rooftop getRooftopById(Long id) {
        return rooftopRepository.findById(id).orElse(null);
    }

    @Override
    public Long getLatestRooftopId() {
        Long latestRooftopId = rooftopRepository.findTopByOrderByIdDesc().getId();
        return latestRooftopId;
    }

}
