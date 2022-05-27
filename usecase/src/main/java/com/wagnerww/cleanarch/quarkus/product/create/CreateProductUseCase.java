package com.wagnerww.cleanarch.quarkus.product.create;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.wagnerww.cleanarch.quarkus.domain.eventstore.events.EventStoreInputEvent;
import com.wagnerww.cleanarch.quarkus.domain.eventstore.events.EventStoreProducerEventRepository;
import com.wagnerww.cleanarch.quarkus.domain.product.Product;
import com.wagnerww.cleanarch.quarkus.domain.product.ProductRepository;
import com.wagnerww.cleanarch.quarkus.eventstore.prepare.PrepareEventStore;
import com.wagnerww.cleanarch.quarkus.eventstore.prepare.PrepareEventStoreInput;

@ApplicationScoped
public class CreateProductUseCase {
  
  private final ProductRepository productRepository;
  private final PrepareEventStore prepareEventStore;
  private final EventStoreProducerEventRepository eventStoreProducerEventRepository;

  @Inject
  public CreateProductUseCase(
    final ProductRepository productRepository,
    final PrepareEventStore prepareEventStore,
    final EventStoreProducerEventRepository eventStoreProducerEventRepository
  ) {
    this.productRepository = productRepository;
    this.prepareEventStore = prepareEventStore;
    this.eventStoreProducerEventRepository = eventStoreProducerEventRepository;
  }

  public CreateProdutOutput execute(CreateProdutInput anProduct) {
    Product product = Product.newProduct(anProduct.getName(), anProduct.getPrice());
    
    productRepository.create(product);

    eventStoreProducerEventRepository.send(
      EventStoreInputEvent.from(
        Product.class.getSimpleName(), 
        product.getId(),
        "CREATED",
        product,
        ""
      )
    );

    return CreateProdutOutput.from(product);
  }

}
