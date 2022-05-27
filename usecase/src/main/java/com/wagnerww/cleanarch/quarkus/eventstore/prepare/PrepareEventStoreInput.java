package com.wagnerww.cleanarch.quarkus.eventstore.prepare;

public class PrepareEventStoreInput {
  private String aggregate;
  private String aggregateId;
  private String action;
  private Object payload;
  private String userDispatch;
  
  private PrepareEventStoreInput(String aggregate, String aggregateId, String action, Object payload,
      String userDispatch) {
    this.aggregate = aggregate;
    this.aggregateId = aggregateId;
    this.action = action;
    this.payload = payload;
    this.userDispatch = userDispatch;
  }

  public static PrepareEventStoreInput from(
    String aAggregate,
    String aAggregateId,
    String aAction,
    Object aPayload,
    String aUserDispatch
  ){
    return new PrepareEventStoreInput(
      aAggregate,
      aAggregateId,
      aAction,
      aPayload,
      aUserDispatch
    );
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
  public Object getPayload() {
    return payload;
  }
  public void setPayload(Object payload) {
    this.payload = payload;
  }
  public String getUserDispatch() {
    return userDispatch;
  }
  public void setUserDispatch(String userDispatch) {
    this.userDispatch = userDispatch;
  }
  
}
