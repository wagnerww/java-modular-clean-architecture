package com.wagnerww.cleanarch.repository.jpa.postgre.product;

import com.wagnerww.cleanarch.repository.jpa.postgre.ProductJpaEnity;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public abstract interface ProductModelRepository extends 
PanacheRepositoryBase<ProductJpaEnity, String> {

}
