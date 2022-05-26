package com.wagnerww.cleanarch.quarkus.domain.product;


public interface ProductRepository {

  public void create(final Product product);

  public void update(final Product product);

  public Product findOneById(final String id);

}
