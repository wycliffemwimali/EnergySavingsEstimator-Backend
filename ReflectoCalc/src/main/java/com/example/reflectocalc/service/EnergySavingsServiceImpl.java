package com.example.reflectocalc.service;

import com.example.reflectocalc.Repository.EnergySavingsRepository;
import com.example.reflectocalc.Repository.RooftopRepository;
import com.example.reflectocalc.model.Rooftop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class EnergySavingsServiceImpl implements EnergySavingsService {

    private final RooftopService rooftopService;
    private final EnergySavingsRepository energySavingsRepository;

    @Autowired
    public EnergySavingsServiceImpl(RooftopService rooftopService, EnergySavingsRepository energySavingsRepository) {
        this.rooftopService = rooftopService;
        this.energySavingsRepository = energySavingsRepository;
    }

    @Override
    public double calculateEnergySavingsByRooftopId(Long rooftopId) {
        Rooftop rooftop = rooftopService.getRooftopById(rooftopId);
//        if (rooftop == null) {
//            throw new ChangeSetPersister.NotFoundException("Rooftop not found with ID: ");
//        }

        double rooftopArea = rooftop.getArea();
        double energySavings = rooftopArea * CONSTANT_FACTOR;
        return energySavings;
    }
}