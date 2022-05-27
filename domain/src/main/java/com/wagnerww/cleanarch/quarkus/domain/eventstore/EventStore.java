package com.wagnerww.cleanarch.quarkus.domain.eventstore;

import java.time.LocalDateTime;
import java.util.UUID;

public class EventStore {

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

  private EventStore(
    final String aId,
    final String aAggregate,
    final String aAggregateId,
    final String aAction,
    final String aPayload,
    final Boolean aIsSycnNeeded,
    final String aUserDispatch,
    final LocalDateTime aCreatedAt,
    final LocalDateTime aUpdateat,
    final LocalDateTime aDeletedAt
  ){
    this.id = aId;
    this.aggregate = aAggregate;
    this.aggregateId = aAggregateId;
    this.action = aAction;
    this.payload = aPayload;
    this.isSycnNeeded = aIsSycnNeeded;
    this.userDispatch = aUserDispatch;
    this.createdAt = aCreatedAt;
    this.upatedAt = aUpdateat;
    this.deletedAt = aDeletedAt;
  }

  public static EventStore newEventStore(
    final String aAggregate,
    final String aAggregateId,
    final String aAction,
    final String aPayload,
    final Boolean aIsSycnNeeded,
    final String aUserDispatch
  ) {
    final String id = UUID.randomUUID().toString();
    final LocalDateTime now = LocalDateTime.now();
    return new EventStore(
      id,
      aAggregate,
      aAggregateId,
      aAction,
      aPayload,
      aIsSycnNeeded,
      aUserDispatch,
      now,
      now,
      null
    );
  }

  public static EventStore with(
    final String aid,
    final String aAggregate,
    final String aAggregateId,
    final String aAction,
    final String aPayload,
    final Boolean aIsSycnNeeded,
    final String aUserDispatch,
    final LocalDateTime aCreatedAt,
    final LocalDateTime aUpdateat,
    final LocalDateTime aDeletedAt
  ) {
    return new EventStore(
      aid,
      aAggregate,
      aAggregateId,
      aAction,
      aPayload,
      aIsSycnNeeded,
      aUserDispatch,
      aCreatedAt,
      aUpdateat,
      aDeletedAt
    );
  }

  public EventStore sync() {
    this.isSycnNeeded = true;
    this.upatedAt = LocalDateTime.now();
    return this;
  }

  public EventStore activate() {
    this.deletedAt = null;
    this.upatedAt = LocalDateTime.now();
    return this;
  }

  public EventStore deactivate() {
    this.deletedAt = LocalDateTime.now();
    this.upatedAt = LocalDateTime.now();
    return this;
  }

  public String getId() {
    return id;
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

  public String getPayload() {
    return payload;
  }

  public Boolean getIsSycnNeeded() {
    return isSycnNeeded;
  }

  public String getUserDispatch() {
    return userDispatch;
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
