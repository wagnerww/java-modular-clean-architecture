package com.wagnerww.cleanarch.quarkus.domain.product;


public interface ProductRepository {

  public void create(final Proudct product);

  public Proudct findOneById(final String id);

}
