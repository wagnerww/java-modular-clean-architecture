package com.wagnerww.cleanarch.repository.jpa.postgre.eventstore;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EventStoreJpaEntity {

  @Id
  private String id;
  private String aggregate;
  private String aggregateId;
  private String action;
  private String payload;
  private Boolean isSycnNeeded;
  private String userDispatch;
  private LocalDateTime createdAt;
  private LocalDateTime upatedAt;
  private LocalDateTime deletedAt;
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getAggregate() {
    return aggregate;
  }
  public void setAggregate(String aggregate) {
    this.aggregate = aggregate;
  }
  public String getAggregateId() {
    return aggregateId;
  }
  public void setAggregateId(String aggregateId) {
    this.aggregateId = aggregateId;
  }
  public String getAction() {
    return action;
  }
  public void setAction(String action) {
    this.action = action;
  }
  public String getPayload() {
    return payload;
  }
  public void setPayload(String payload) {
    this.payload = payload;
  }
  public Boolean getIsSycnNeeded() {
    return isSycnNeeded;
  }
  public void setIsSycnNeeded(Boolean isSycnNeeded) {
    this.isSycnNeeded = isSycnNeeded;
  }
  public String getUserDispatch() {
    return userDispatch;
  }
  public void setUserDispatch(String userDispatch) {
    this.userDispatch = userDispatch;
  }
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
  public LocalDateTime getUpatedAt() {
    return upatedAt;
  }
  public void setUpatedAt(LocalDateTime upatedAt) {
    this.upatedAt = upatedAt;
  }
  public LocalDateTime getDeletedAt() {
    return deletedAt;
  }
  public void setDeletedAt(LocalDateTime deletedAt) {
    this.deletedAt = deletedAt;
  }

  
  
}
