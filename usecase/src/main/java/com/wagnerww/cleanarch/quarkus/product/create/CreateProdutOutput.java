package com.wagnerww.cleanarch.quarkus.product.create;

import com.wagnerww.cleanarch.quarkus.domain.product.Product;

public class CreateProdutOutput {
  private String id;

  private CreateProdutOutput(String aId) {
    this.id = aId;
  }

  public static CreateProdutOutput from(final Product aProduct) {
    return new CreateProdutOutput(aProduct.getId());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
  
  
  
}
