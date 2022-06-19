package com.example.obhibernateproyecto.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * BillingInfo: representa la informacion de facturacion de un usuario
 */

@Entity
@Table(name="ob_billing_info")
public class BillingInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String street;

    @Column(name="postal_code")
    private String postalCode;

    private String country;

    private String city;

    private String iban;

    @OneToOne(mappedBy="billingInfo")
    private User user;

    public BillingInfo() {
    }

    public BillingInfo(Long id, String street, String postalCode, String country, String city, String iban, User user) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.country = country;
        this.city = city;
        this.iban = iban;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "BillingInfo{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", iban='" + iban + '\'' +
                '}';
    }
}
