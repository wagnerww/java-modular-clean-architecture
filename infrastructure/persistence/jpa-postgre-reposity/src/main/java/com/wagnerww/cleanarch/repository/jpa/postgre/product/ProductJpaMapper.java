package com.wagnerww.cleanarch.repository.jpa.postgre.product;

import com.wagnerww.cleanarch.quarkus.domain.product.Product;

public class ProductJpaMapper {

  public static ProductJpaEnity fromDomain(Product aProduct) {
    ProductJpaEnity entity = new ProductJpaEnity();
    entity.setId( aProduct.getId());
    entity.setName(aProduct.getName());
    entity.setPrice(aProduct.getPrice());
    entity.setCreatedAt(aProduct.getCreatedAt());
    entity.setUpdatedAt(aProduct.getUpatedAt());
    entity.setDeletedAt(aProduct.getDeletedAt());

    return entity;
  }

  public static Product toDomain(ProductJpaEnity aProductJpaEnitty) {
    if (aProductJpaEnitty != null) {
      return Product.with(
        aProductJpaEnitty.getId(),
        aProductJpaEnitty.getName(),
        aProductJpaEnitty.getPrice(),
        aProductJpaEnitty.getCreatedAt(),
        aProductJpaEnitty.getUpdatedAt(),
        aProductJpaEnitty.getDeletedAt()
      );
    } else {
      return null;
    }
  }
  
}
