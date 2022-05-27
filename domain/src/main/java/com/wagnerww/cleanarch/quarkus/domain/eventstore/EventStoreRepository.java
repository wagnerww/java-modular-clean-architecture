package com.wagnerww.cleanarch.quarkus.domain.eventstore;


public interface EventStoreRepository {

  public void create(final EventStore eventStore);

  public void sync(final EventStore eventStore);

  public void activateOrDeactivate(final EventStore eventStore);

}
