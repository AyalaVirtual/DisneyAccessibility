package org.example.model;

import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import java.util.List;


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
    @OneToOne(mappedBy = "park", cascade = CascadeType.ALL) // This means there is a one-to-one relationship between Park and ParkAccessibility that is mapped by the 'park' variable in the ParkAccessibility class. 'cascade = CascadeType.ALL' ensures that when you perform operations (like save or delete) on a Park, its associated ParkAccessibility will also be saved or deleted
    private ParkAccessibility parkAccessibility;


    @OneToMany(mappedBy = "park", orphanRemoval = true) // This means there is a one-to-many relationship between Park and Attraction that is mapped by the 'park' variable in the Accessibility class. 'orphanRemoval = true' means that if an Attraction entity is removed from a Park's collection, and that entity is not associated with any other parent entity, it should be deleted from the database
    @LazyCollection(LazyCollectionOption.FALSE) // This means that the associated Attractions are loaded immediately when the Park entity is fetched from the database
    private List<Attraction> attractionList;


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

    public ParkAccessibility getParkAccessibility() {
        return parkAccessibility;
    }

    public void setParkAccessibility(ParkAccessibility parkAccessibility) {
        this.parkAccessibility = parkAccessibility;
    }

    public List<Attraction> getAttractionList() {
        return attractionList;
    }

    public void setAttractionList(List<Attraction> attractionList) {
        this.attractionList = attractionList;
    }


    /**
     * This method adds attractions to the theme park's list of attractions
     *
     * @param attraction represents the attraction the user is trying to add to the theme park's list of attractions
     */
    public void addToAttractionList(Attraction attraction) {
        attractionList.add(attraction);
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
