package com.wagnerww.cleanarch.repository.jpa.postgre.aggregates.product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@Named
@ApplicationScoped
public class ProductAggregateRepositoryImpl implements
PanacheRepositoryBase<ProductAggregateJpaEntity, String>, ProductAggregateModelRepository {

  @Inject
  EntityManager em;

  //@Inject
  //private ProductJpaMapper mapper;


  @Transactional
  @Override
  public void create(ProductAggregateJpaEntity anProduct) {
    em.persist(anProduct);        
  }

  @Transactional
  @Override
  public ProductAggregateJpaEntity findOneById(String anId) {
    ProductAggregateJpaEntity entity =  em.find(ProductAggregateJpaEntity.class, anId);
    return entity;  
  }

  
  @Transactional
  @Override
  public void update(ProductAggregateJpaEntity anProduct) {
    em.merge(anProduct);    
  }
  
}
