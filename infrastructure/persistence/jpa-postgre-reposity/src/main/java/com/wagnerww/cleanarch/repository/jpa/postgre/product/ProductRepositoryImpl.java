package com.wagnerww.cleanarch.repository.jpa.postgre.product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.wagnerww.cleanarch.quarkus.domain.product.Product;
import com.wagnerww.cleanarch.quarkus.domain.product.ProductRepository;
import com.wagnerww.cleanarch.repository.jpa.postgre.ProductJpaEnity;


import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@Named
@ApplicationScoped
public class ProductRepositoryImpl implements 
  PanacheRepositoryBase<ProductJpaEnity, String>, ProductRepository {

  @Inject
  EntityManager em;

  //@Inject
  //private ProductJpaMapper mapper;


  @Override
  @Transactional
  public void create(Product anProduct) {

    ProductJpaEnity model = ProductJpaMapper.fromDomain(anProduct);
    em.persist(model);
        
  }

  @Override
  @Transactional
  public Product findOneById(String id) {
    ProductJpaEnity entity =  em.find(ProductJpaEnity.class, id);
    return ProductJpaMapper.toDomain(entity);
  }

  @Override
  @Transactional
  public void update(Product anProduct) {
    ProductJpaEnity model = ProductJpaMapper.fromDomain(anProduct);
    em.merge(model);
    
  }
  
}
