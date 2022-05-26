package com.wagnerww.cleanarch.quarkus.domain.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import com.wagnerww.cleanarch.quarkus.domain.product.Product;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class ProductTest {

  @DisplayName("Create a new product and validate attributes")
  @Test
  public void shouldCreateNewProduct() {
    final String expectedName = "Produto 1";
    final BigDecimal expectedPrice = BigDecimal.valueOf(25);
    Product product = Product.newProduct(expectedName, expectedPrice);

    assertNotNull(product.getId());
    assertEquals(expectedName, product.getName());
    assertEquals(expectedPrice, product.getPrice());
  }

  @DisplayName("Create a new product and validate audit")
  @Test
  public void shouldCreateNewProductAndVlidateAudit() {
    final String expectedName = "Produto 1";
    final BigDecimal expectedPrice = BigDecimal.valueOf(25);
    Product product = Product.newProduct(expectedName, expectedPrice);

    assertNotNull(product.getCreatedAt());
    assertNotNull(product.getUpatedAt());
    assertNull(product.getDeletedAt());
  }
  
}
