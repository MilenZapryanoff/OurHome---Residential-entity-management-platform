package com.example.OurHome.model.Entity;

import jakarta.persistence.*;

@Entity(name = "property_requests")
public class PropertyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long residentialEntityId;
    @Column(nullable = false)
    private int number;
    @Column
    private String floor;
    @Column
    private int numberOfAdults;
    @Column
    private int numberOfChildren;
    @Column
    private int numberOfPets;

    @Column
    private boolean changeRequest;
    @Column
    private boolean obtainRequest;
    @Column
    private boolean notHabitable;
    @Column
    private boolean parkingAvailable;
    @Column
    private boolean active;

    @ManyToOne
    private PropertyType propertyType;
    @Column
    private String numberOfRooms;
    @ManyToOne
    private UserEntity owner;
    @OneToOne(mappedBy = "propertyRequest", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private Property property;

    public PropertyRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResidentialEntityId() {
        return residentialEntityId;
    }

    public void setResidentialEntityId(Long residentialEntityId) {
        this.residentialEntityId = residentialEntityId;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public int getNumberOfPets() {
        return numberOfPets;
    }

    public void setNumberOfPets(int numberOfPets) {
        this.numberOfPets = numberOfPets;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public boolean isChangeRequest() {
        return changeRequest;
    }

    public void setChangeRequest(boolean changeRequest) {
        this.changeRequest = changeRequest;
    }

    public boolean isObtainRequest() {
        return obtainRequest;
    }

    public void setObtainRequest(boolean obtainRequest) {
        this.obtainRequest = obtainRequest;
    }

    public boolean isNotHabitable() {
        return notHabitable;
    }

    public void setNotHabitable(boolean notHabitable) {
        this.notHabitable = notHabitable;
    }

    public boolean isParkingAvailable() {
        return parkingAvailable;
    }

    public void setParkingAvailable(boolean parkingAvailable) {
        this.parkingAvailable = parkingAvailable;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
