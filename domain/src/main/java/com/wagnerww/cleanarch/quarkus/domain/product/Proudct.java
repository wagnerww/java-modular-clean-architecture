package com.wagnerww.cleanarch.quarkus.domain.product;

import java.util.UUID;

public class Proudct {

  private final String id;
  private final String name;
  private final String price;

  //public Proudct() {}
  
  private Proudct(final String anName, final String anPrice) {
    this.id = UUID.randomUUID().toString();
    this.name = anName;
    this.price = anPrice;
  }

  public static Proudct newProduct(final String anName, final String anPrice) {
    return new Proudct(anName, anPrice);
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPrice() {
    return price;
  }  
  
}
