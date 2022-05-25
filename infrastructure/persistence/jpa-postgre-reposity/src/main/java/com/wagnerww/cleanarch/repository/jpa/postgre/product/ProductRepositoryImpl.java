package com.wagnerww.cleanarch.repository.jpa.postgre.product;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.wagnerww.cleanarch.quarkus.domain.product.ProductRepository;
import com.wagnerww.cleanarch.quarkus.domain.product.Proudct;
import com.wagnerww.cleanarch.repository.jpa.postgre.ProductModel;

import org.hibernate.sql.Update;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@Named
@ApplicationScoped
public class ProductRepositoryImpl implements PanacheRepositoryBase<ProductModel, String>, ProductRepository {

  @Inject
  EntityManager em;
  //private final ProductModelRepository productModelRepository;

  /*@Inject
  public ProductRepositoryImpl(final ProductModelRepository productModelRepository ){
    this.productModelRepository = productModelRepository;
  }*/

  @Override
  @Transactional
  public void create(Proudct product) {

    ProductModel model = new ProductModel();
    model.setId(product.getId());
    model.setName(product.getName());
    model.setPrice(product.getPrice());

    em.persist(model);
        
  }

  @Override
  public Proudct findOneById(String id) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
