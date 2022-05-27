package com.wagnerww.cleanarch.quarkus.domain.eventstore.events;

public class EventStoreInputEvent {
  private String aggregate;
  private String aggregateId;
  private String action;
  private Object payload;
  private String userDispatch;

  private EventStoreInputEvent(
    String aAggregate,
    String aAggregateId,
    String aAction,
    Object aPayload,
    String aUserDispatch
  ) 
  {
    this.aggregate = aAggregate;
    this.aggregateId = aAggregateId;
    this.action = aAction;
    this.payload = aPayload;
    this.userDispatch = aUserDispatch;
  }

  public static EventStoreInputEvent from(
    String aAggregate,
    String aAggregateId,
    String aAction,
    Object aPayload,
    String aUserDispatch
  ) {
    return new EventStoreInputEvent(
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

  public String getAggregateId() {
    return aggregateId;
  }

  public String getAction() {
    return action;
  }

  public Object getPayload() {
    return payload;
  }

  public String getUserDispatch() {
    return userDispatch;
  }

}
