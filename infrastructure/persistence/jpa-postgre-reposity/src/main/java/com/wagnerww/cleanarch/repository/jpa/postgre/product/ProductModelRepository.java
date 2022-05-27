package com.wagnerww.cleanarch.repository.jpa.postgre.product;



import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public abstract interface ProductModelRepository extends 
PanacheRepositoryBase<ProductJpaEnity, String> {

}
