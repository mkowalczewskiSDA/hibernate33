package com.sda.model;

import java.time.LocalDate;
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
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "address")
public class User implements ModelClass {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USR_ID")
  private int id;
  @Column(name = "USR_FIRSTNAME")
  private String firstName;
  @Column(name = "USR_LASTNAME")
  private String lastName;
  @Column(name = "USR_EMAIL")
  private String email;
  @Column(name = "USR_BIRTH_DATE")
  private LocalDate birthDate;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USR_ADD_ID", referencedColumnName = "ADD_ID")
  private Address address;

  public User(int id) {
    this.id = id;
  }
}