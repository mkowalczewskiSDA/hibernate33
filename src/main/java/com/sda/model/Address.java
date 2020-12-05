package com.sda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {

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
  private Country country;

}
