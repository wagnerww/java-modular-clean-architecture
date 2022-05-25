package com.wagnerww.cleanarch.repository.jpa.postgre;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductModel {
  @Id
  private String id;
  private String name;
  private String price;

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
  public String getPrice() {
    return price;
  }
  public void setPrice(String price) {
    this.price = price;
  }

  
}
