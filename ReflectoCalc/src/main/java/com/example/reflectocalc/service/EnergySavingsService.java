package com.example.reflectocalc.service;

public interface EnergySavingsService {
    double CONSTANT_FACTOR = 0.5;
    double calculateEnergySavingsByRooftopId(Long rooftopId);
}