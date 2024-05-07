package org.example.model;

import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="parks")
public class Park {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;

    @Column
    public String name;

    @Column
    public String imageUrl;

    @Column
    public String description;

    @Column
    public double latitude;

    @Column
    private double longitude;


    // This links the table representing the Park model to the table representing the ParkAccessibility model
    @OneToOne(mappedBy = "park") // This means it's a one-to-one relationship that is mappedBy the variable representing the link to the other table.
    @LazyCollection(LazyCollectionOption.FALSE)  // This means when you fetch an instance of a park, fetch the associated accessibility details
    private List<ParkAccessibility> parkAccessibilityList;


    public Park() {
    }

    public Park(Long id, String name, String imageUrl, String description, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
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


    @Override
    public String toString() {
        return "Park{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
