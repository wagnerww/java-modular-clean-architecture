package com.wagnerww.cleanarch.quarkus.product.deactivate;

import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.wagnerww.cleanarch.quarkus.domain.product.Product;
import com.wagnerww.cleanarch.quarkus.domain.product.ProductRepository;

@Named
@ApplicationScoped
public class DeactivateProductUseCase {
  
  private final ProductRepository productRepository;

  @Inject
  public DeactivateProductUseCase(final ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void execute(String id) {

    Product product = productRepository.findOneById(id);

    if (product == null) {
      throw new IllegalAccessError("Produto com o 'id' " + id + "não encontrado");
    }

    product.deactivate();

    productRepository.update(product);
  }

}
