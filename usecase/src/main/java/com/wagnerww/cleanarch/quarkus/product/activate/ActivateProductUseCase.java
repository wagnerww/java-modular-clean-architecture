package com.wagnerww.cleanarch.quarkus.product.activate;

import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.wagnerww.cleanarch.quarkus.domain.product.Product;
import com.wagnerww.cleanarch.quarkus.domain.product.ProductRepository;

@Named
@ApplicationScoped
public class ActivateProductUseCase {
  
  private final ProductRepository productRepository;

  @Inject
  public ActivateProductUseCase(final ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void execute(String id) {

    Product product = productRepository.findOneById(id);

    if (product == null) {
      throw new IllegalAccessError("Produto com o 'id' " + id + "não encontrado");
    }

    product.activate();

    productRepository.update(product);
  }

}
