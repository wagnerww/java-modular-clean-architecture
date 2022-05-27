package com.wagnerww.cleanarch.repository.jpa.postgre.aggregates.product;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductAggregateJpaEntity {

  @Id
  private String id;
  private String name;
  private BigDecimal price;
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public BigDecimal getPrice() {
    return price;
  }
  public void setPrice(BigDecimal price) {
    this.price = price;
  }
  

  
  
}
