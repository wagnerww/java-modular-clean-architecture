package com.wagnerww.cleanarch.quarkus.domain.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Product {

  private String id;
  private String name;
  private BigDecimal price;
  private LocalDateTime createdAt;
  private LocalDateTime upatedAt;
  private LocalDateTime deletedAt;

  private Product(
      final String aId,
      final String aName,
      final BigDecimal aPrice,
      final LocalDateTime aCreatedAt,
      final LocalDateTime aUpdateat,
      final LocalDateTime aDeletedAt
  ) {
    this.id = aId;
    this.name = aName;
    this.price = aPrice;
    this.createdAt = aCreatedAt;
    this.upatedAt = aUpdateat;
    this.deletedAt = aDeletedAt;
  }

  public static Product newProduct(
      final String aName,
      final BigDecimal aPrice
  ) {
    final String id = UUID.randomUUID().toString();
    final LocalDateTime now = LocalDateTime.now();
    return new Product(id, aName, aPrice, now, now, null);
  }

  public static Product with(
      final String aId,
      final String aName,
      final BigDecimal aPrice,
      final LocalDateTime aCreatedAt,
      final LocalDateTime aUpdatedAt,
      final LocalDateTime aDeletedAt
  ) {
    return new Product(
      aId,
      aName,
      aPrice,
      aCreatedAt,
      aUpdatedAt,
      aDeletedAt
    );
  }

  public Product update(
    final String aName,
    final BigDecimal aPrice
  ) {
    this.name = aName;
    this.price = aPrice;
    this.upatedAt = LocalDateTime.now();
    return this;
  }

  public Product activate() {
    this.deletedAt = null;
    this.upatedAt = LocalDateTime.now();
    return this;
  }

  public Product deactivate() {
    this.deletedAt = LocalDateTime.now();
    this.upatedAt = LocalDateTime.now();
    return this;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpatedAt() {
    return upatedAt;
  }

  public LocalDateTime getDeletedAt() {
    return deletedAt;
  }

}
