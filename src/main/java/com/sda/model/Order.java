package com.sda.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "`Order`")
@Data
@NoArgsConstructor
@ToString(exclude = "products")
@EqualsAndHashCode(exclude = "products")
public class Order implements ModelClass {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ORD_ID")
  private int id;
  @Column(name = "ORD_DATE")
  private LocalDateTime orderDate;
  @Column(name = "ORD_PRICE")
  private BigDecimal orderPrice;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORD_USR_ID", referencedColumnName = "USR_ID")
  private User user;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "Cart",
  joinColumns = {@JoinColumn(name = "CRT_ORD_ID")},
  inverseJoinColumns = {@JoinColumn(name = "CRT_PRO_ID")})
  private Set<Product> products = new HashSet<>();

  public Order(LocalDateTime orderDate, BigDecimal orderPrice, User user) {
    this.orderDate = orderDate;
    this.orderPrice = orderPrice;
    this.user = user;
  }
}
