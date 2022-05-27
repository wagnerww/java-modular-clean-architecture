package com.wagnerww.cleanarch.quarkus.domain.eventstore.events;

public interface EventStoreProducerEventRepository {

  public void send(final EventStoreInputEvent eventStore);
  
}
