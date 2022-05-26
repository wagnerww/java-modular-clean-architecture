package com.wagnerww.cleanarch.quarkus.product.create;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.wagnerww.cleanarch.quarkus.domain.product.Product;
import com.wagnerww.cleanarch.quarkus.domain.product.ProductRepository;

@Named
@ApplicationScoped
public class CreateProductUseCase {
  
  private final ProductRepository productRepository;

  @Inject
  public CreateProductUseCase(final ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public CreateProdutOutput execute(CreateProdutInput anProduct) {
    Product product = Product.newProduct(anProduct.getName(), anProduct.getPrice());
    
    productRepository.create(product);

    return CreateProdutOutput.from(product);
  }

}
