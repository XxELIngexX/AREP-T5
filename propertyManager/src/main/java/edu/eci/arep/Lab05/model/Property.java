package edu.eci.arep.Lab05.model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "price", nullable = false)
    private String price;
    @Column(name = "size", nullable = false)
    private String size;
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "user_id", nullable = false)
    private UUID user;


    public Property(String address, String size, String price, String description, UUID user) {
        this.address = address;
        this.size = size;
        this.price = price;
        this.description = description;
        this.user = user;
    }
    public Property() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Property{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", price='" + price + '\'' +
                ", size='" + size + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
