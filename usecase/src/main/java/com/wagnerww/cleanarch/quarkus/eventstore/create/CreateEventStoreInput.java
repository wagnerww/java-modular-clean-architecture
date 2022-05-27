package com.wagnerww.cleanarch.quarkus.eventstore.create;

public class CreateEventStoreInput {

  private String aggregate;
  private String aggregateId;
  private String action;
  private String payload;
  private String userDispatch;
  private Boolean isSycnNeeded;

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
  public String getUserDispatch() {
    return userDispatch;
  }
  public void setUserDispatch(String userDispatch) {
    this.userDispatch = userDispatch;
  }
  public Boolean getIsSycnNeeded() {
    return isSycnNeeded;
  }
  public void setIsSycnNeeded(Boolean isSycnNeeded) {
    this.isSycnNeeded = isSycnNeeded;
  } 
  
}
