package com.example.reflectocalc.service;

import com.example.reflectocalc.model.Rooftop;

import java.util.List;

public interface RooftopService {
    List<Rooftop> getRooftopsByBuildingId(Long buildingId);
}
