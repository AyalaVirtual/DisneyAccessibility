package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name="parkaccessibility")
public class ParkAccessibility {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String imageUrl;

    @Column
    private String description;

    @Column
    private double latitude;

    @Column
    private double longitude;

    // This links the table representing the ParkAccessibility model to the table representing the Park model
    @JsonIgnore
    // This prevents a stack overflow/API crashing from parks and parkAccessibility calling each other back and forth
    @OneToOne
    @JoinColumn(name = "park_id") // This represents the foreign key in SQL joining the columns to connect the 2 tables
    private Park park;




}
