package com.sda.model;

import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Employee extends BaseEntity {

  private int pensja;

}
