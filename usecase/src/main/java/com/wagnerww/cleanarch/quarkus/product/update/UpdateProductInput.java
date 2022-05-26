package com.wagnerww.cleanarch.quarkus.product.update;

import java.math.BigDecimal;

public class UpdateProductInput {
  private String name;
  private BigDecimal price;
  
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
