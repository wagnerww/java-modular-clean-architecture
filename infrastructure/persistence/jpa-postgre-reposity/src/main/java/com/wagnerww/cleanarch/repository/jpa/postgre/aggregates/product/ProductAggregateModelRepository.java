package com.wagnerww.cleanarch.repository.jpa.postgre.aggregates.product;



import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public abstract interface ProductAggregateModelRepository extends 
PanacheRepositoryBase<ProductAggregateJpaEntity, String> {

}
