package com.example.reflectocalc.service;

public interface EnergySavingsService {
    double CONSTANT_FACTOR = 0.05;
    double calculateEnergySavingsByRooftopId(Long rooftopId);
}