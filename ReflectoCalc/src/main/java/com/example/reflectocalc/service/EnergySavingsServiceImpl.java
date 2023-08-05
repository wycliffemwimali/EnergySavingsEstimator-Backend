package com.example.reflectocalc.service;

import com.example.reflectocalc.DTO.RooftopAreaDTO;
import org.springframework.stereotype.Service;

@Service
public class EnergySavingsServiceImpl implements EnergySavingsService {

    @Override
    public double calculateEnergySavings(RooftopAreaDTO rooftopAreaDTO) {
        double rooftopArea = rooftopAreaDTO.getArea();
        return rooftopArea * CONSTANT_FACTOR;
    }
}
