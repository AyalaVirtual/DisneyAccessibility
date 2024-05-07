package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name="attractions")
public class Attraction {

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

    // This links the table representing the Attraction model to the table representing the Park model
    @JsonIgnore // This prevents a stack overflow from Parks and Attractions calling each other back and forth
    @ManyToOne // This means there is a many-to-one relationship between Attraction and Park
    @JoinColumn(name = "park_id") // This means that the Attraction entity will have a foreign key column named park_id referring to the primary attribute id of our Park entity. This foreign key in SQL joins the columns to connect the 2 tables
    private Park park;


    public Attraction() {
    }

    public Attraction(Long id, String name, String imageUrl, String description, double latitude, double longitude, Park park) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.park = park;
    }


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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }


    @Override
    public String toString() {
        return "Attraction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", park=" + park +
                '}';
    }

}
