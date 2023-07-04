package com.example.reflectocalc.model;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table(name = "buildings")
public class Building {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    public Rooftop getRooftop() {
        return rooftop;
    }

    public void setRooftop(Rooftop rooftop) {
        this.rooftop = rooftop;
    }

    @OneToOne(mappedBy = "building", cascade = CascadeType.ALL)
    private Rooftop rooftop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
