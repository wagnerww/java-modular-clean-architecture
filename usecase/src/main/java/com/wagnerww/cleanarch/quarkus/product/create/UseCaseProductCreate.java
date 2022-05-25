package com.wagnerww.cleanarch.quarkus.product.create;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.wagnerww.cleanarch.quarkus.domain.product.ProductRepository;
import com.wagnerww.cleanarch.quarkus.domain.product.Proudct;

@Named
@ApplicationScoped
public class UseCaseProductCreate {
  
  private final ProductRepository productRepository;

  @Inject
  public UseCaseProductCreate(final ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void execute() {
    Proudct product = Proudct.newProduct("nome", "10");
    System.out.println("Chegou usecase");
    productRepository.create(product);
  }

}
