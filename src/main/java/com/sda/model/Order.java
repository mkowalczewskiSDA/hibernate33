package com.sda.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "`Order`")
@Data
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

}
