package com.sda.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "orders")
@EqualsAndHashCode(exclude = "orders")
public class Product implements ModelClass {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PRO_ID")
  private int id;
  @Column(name = "PRO_NAME")
  private String name;
  @Column(name = "PRO_PRICE")
  private BigDecimal price;
  @Column(name = "PRO_DESCRIPTION")
  private String description;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRO_CAT_ID", referencedColumnName = "CAT_ID")
  private Category category;
  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
  private Set<Order> orders = new HashSet<>();

  public Product(String name, BigDecimal price, String description, Category category) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.category = category;
  }
}
