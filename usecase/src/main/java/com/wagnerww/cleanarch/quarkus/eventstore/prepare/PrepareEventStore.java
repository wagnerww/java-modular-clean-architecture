package com.wagnerww.cleanarch.quarkus.eventstore.prepare;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wagnerww.cleanarch.quarkus.eventstore.create.CreateEventStoreInput;
import com.wagnerww.cleanarch.quarkus.eventstore.create.CreateEventStoreUseCase;

@Named
@ApplicationScoped
public class PrepareEventStore {

  private CreateEventStoreUseCase createEventStoreUseCase;

  @Inject
  public PrepareEventStore(
    CreateEventStoreUseCase createEventStoreUseCase
  ) {
    this.createEventStoreUseCase = createEventStoreUseCase;
  }

  public void send(PrepareEventStoreInput anEvent){

    

    try {
      ObjectMapper mapper = new ObjectMapper();
      mapper.registerModule(new JavaTimeModule());
      mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    
      String json = mapper.writeValueAsString(anEvent.getPayload());

      CreateEventStoreInput aEventInput = new CreateEventStoreInput();
      aEventInput.setAggregate(anEvent.getAggregate());
      aEventInput.setAggregateId(anEvent.getAggregateId());
      aEventInput.setIsSycnNeeded(true);
      aEventInput.setAction(anEvent.getAction());
      aEventInput.setUserDispatch(anEvent.getUserDispatch());
      aEventInput.setPayload(json);

      createEventStoreUseCase.execute(aEventInput);
    } catch (Exception e) {
      System.out.println("errrooo_"+ e);
    }
    
  }
  
}
