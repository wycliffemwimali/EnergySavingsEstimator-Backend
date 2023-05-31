package com.example.reflectocalc.model;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "energy_consumptions")
public class EnergyConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    @Column(nullable = false)
    private double consumption;
}
