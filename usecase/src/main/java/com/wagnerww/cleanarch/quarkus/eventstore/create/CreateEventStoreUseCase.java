package com.wagnerww.cleanarch.quarkus.eventstore.create;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.wagnerww.cleanarch.quarkus.domain.eventstore.EventStore;
import com.wagnerww.cleanarch.quarkus.domain.eventstore.EventStoreRepository;

@Named
@ApplicationScoped
public class CreateEventStoreUseCase {

  private final EventStoreRepository eventStoreRepository;

  @Inject
  public CreateEventStoreUseCase(final EventStoreRepository eventStoreRepository) {
    this.eventStoreRepository = eventStoreRepository;
  }

  public void execute(CreateEventStoreInput aEventStore) {

    EventStore eventStore = EventStore.newEventStore(
      aEventStore.getAggregate(),
      aEventStore.getAggregateId(),
      aEventStore.getAction(),
      aEventStore.getPayload(),
      aEventStore.getIsSycnNeeded(),
      aEventStore.getUserDispatch()
    );
    
    eventStoreRepository.create(eventStore);

    
  }
  
}
