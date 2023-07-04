package com.example.reflectocalc.service;

import com.example.reflectocalc.model.Rooftop;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface RooftopService {
    List<Rooftop> getRooftopsByBuildingId(Long buildingId);

    void saveRooftop(Rooftop rooftop);

    void deleteRooftopById(Long rooftopId) throws ChangeSetPersister.NotFoundException;
}
