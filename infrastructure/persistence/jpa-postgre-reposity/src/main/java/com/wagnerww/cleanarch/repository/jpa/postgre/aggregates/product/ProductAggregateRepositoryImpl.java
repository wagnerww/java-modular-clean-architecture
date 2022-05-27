package com.wagnerww.cleanarch.repository.jpa.postgre.aggregates.product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.wagnerww.cleanarch.quarkus.domain.product.Product;
import com.wagnerww.cleanarch.quarkus.domain.product.ProductRepository;
import com.wagnerww.cleanarch.repository.jpa.postgre.product.ProductJpaEnity;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@Named
@ApplicationScoped
public class ProductAggregateRepositoryImpl implements 
  PanacheRepositoryBase<ProductAggregateJpaEntity, String> {

  @Inject
  EntityManager em;

  //@Inject
  //private ProductJpaMapper mapper;


  @Transactional
  public void create(ProductAggregateJpaEntity anProduct) {
    em.persist(anProduct);        
  }

  @Transactional
  public ProductAggregateJpaEntity findOneById(String id) {
    ProductAggregateJpaEntity entity =  em.find(ProductAggregateJpaEntity.class, id);
    return entity;  
  }

  
  @Transactional
  public void update(ProductAggregateJpaEntity anProduct) {
    em.merge(anProduct);    
  }
  
}
