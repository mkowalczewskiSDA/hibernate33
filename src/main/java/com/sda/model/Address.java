package com.sda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "country")
@NoArgsConstructor
public class Address implements ModelClass {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ADD_ID")
  private int id;
  @Column(name = "ADD_STREET")
  private String street;
  @Column(name = "ADD_BUILDING_NO")
  private String buildingNo;
  @Column(name = "ADD_APARTMENT_NO")
  private String apartmentNo;
  @Column(name = "ADD_CITY")
  private String city;
  @Column(name = "ADD_POSTAL_CODE")
  private String postalCode;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ADD_CO_ID", referencedColumnName = "CO_ID")
  private Country country;

  public Address(String street, String buildingNo, String apartmentNo, String city,
      String postalCode, Country country) {
    this.street = street;
    this.buildingNo = buildingNo;
    this.apartmentNo = apartmentNo;
    this.city = city;
    this.postalCode = postalCode;
    this.country = country;
  }
}
