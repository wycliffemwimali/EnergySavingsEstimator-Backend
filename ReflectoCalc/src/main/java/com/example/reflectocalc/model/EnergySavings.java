package com.example.reflectocalc.model;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Entity
@Table(name = "energy_savings")
public class EnergySavings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "savings")
    private double savings;
    private Long rooftopId;

    public Long getRooftopId() {
        return rooftopId;
    }

    public void setRooftopId(Long rooftopId) {
        this.rooftopId = rooftopId;
    }

    public Double getEnergySavings() {
        return energySavings;
    }

    public void setEnergySavings(Double energySavings) {
        this.energySavings = energySavings;
    }

    private Double energySavings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
