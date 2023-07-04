package com.example.reflectocalc.Repository;

import com.example.reflectocalc.model.Roof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoofRepository extends JpaRepository<Roof, Long> {
}
