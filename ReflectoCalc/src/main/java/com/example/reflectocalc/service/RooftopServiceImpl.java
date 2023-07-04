package com.example.reflectocalc.service;

import com.example.reflectocalc.Repository.RooftopRepository;
import com.example.reflectocalc.model.Rooftop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

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

//    @Override
//    public Rooftop getRooftopById(Long rooftopId) {
//        return rooftopRepository.findById(rooftopId)
//                .orElseThrow(() -> new NotFoundException("Rooftop not found with ID: " + rooftopId));
//    }

    @Override
    public void saveRooftop(Rooftop rooftop) {
        rooftopRepository.save(rooftop);
    }

    @Override
    public void deleteRooftopById(Long rooftopId) throws ChangeSetPersister.NotFoundException {
        if (!rooftopRepository.existsById(rooftopId)) {
            throw new ChangeSetPersister.NotFoundException();
        }
        rooftopRepository.deleteById(rooftopId);
    }

    // Add more methods as needed
}

