package ccom.wagnerww.cleanarch.quarkus.projections.product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.wagnerww.cleanarch.quarkus.domain.product.Product;
import com.wagnerww.cleanarch.quarkus.domain.product.ProductRepository;
import com.wagnerww.cleanarch.repository.jpa.postgre.aggregates.product.ProductAggregateJpaEntity;
import com.wagnerww.cleanarch.repository.jpa.postgre.aggregates.product.ProductAggregateModelRepository;

@ApplicationScoped
@Named
public class ProductProjectionSimpleSearch {
  
  private final ProductRepository productRepository;
  private final ProductAggregateModelRepository productAggregateModelRepository;

  @Inject
  public ProductProjectionSimpleSearch(
    final ProductRepository productRepository,
    final ProductAggregateModelRepository productAggregateModelRepository
  ){
    this.productRepository = productRepository;
    this.productAggregateModelRepository = productAggregateModelRepository;
  }

  public void execute(String anId) {

    Product aProduct = productRepository.findOneById(anId);

    if (aProduct == null) {
    return;
    }

    ProductAggregateJpaEntity aProductAggreate = null;
    aProductAggreate = productAggregateModelRepository.findOneById(anId);
    Boolean isInsert = false;

    if (aProductAggreate == null) {
      aProductAggreate = new ProductAggregateJpaEntity();
      aProductAggreate.setId(aProduct.getId());
      isInsert = true;
    }

    aProductAggreate.setName(aProduct.getName());
    aProductAggreate.setPrice(aProduct.getPrice());

    if (isInsert) {
      productAggregateModelRepository.create(aProductAggreate);
    } else {
      productAggregateModelRepository.update(aProductAggreate);
    }

  }

}
