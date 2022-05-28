package com.wagnerww.cleanarch.repository.jpa.postgre.aggregates.product;

public abstract interface ProductAggregateModelRepository  {

  public void create(ProductAggregateJpaEntity anProduct);

  public ProductAggregateJpaEntity findOneById(String anId);

  public void update(ProductAggregateJpaEntity anProduct);

}
