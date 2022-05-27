package com.wagnerww.cleanarch.repository.jpa.postgre.eventstore;

import com.wagnerww.cleanarch.quarkus.domain.eventstore.EventStore;

public class EventStoreJpaMapper {

  public static EventStoreJpaEntity fromDomain(EventStore aEventStore) {
    EventStoreJpaEntity model = new EventStoreJpaEntity();
    model.setId(aEventStore.getId());
    model.setAggregate(aEventStore.getAggregate());
    model.setAggregateId(aEventStore.getAggregateId());
    model.setAction(aEventStore.getAction());
    model.setIsSycnNeeded(aEventStore.getIsSycnNeeded());
    model.setPayload(aEventStore.getPayload());
    model.setUserDispatch(aEventStore.getUserDispatch());
    model.setCreatedAt(aEventStore.getCreatedAt());
    model.setUpatedAt(aEventStore.getUpatedAt());
    model.setDeletedAt(aEventStore.getDeletedAt());

    return model;
  }
  
}
