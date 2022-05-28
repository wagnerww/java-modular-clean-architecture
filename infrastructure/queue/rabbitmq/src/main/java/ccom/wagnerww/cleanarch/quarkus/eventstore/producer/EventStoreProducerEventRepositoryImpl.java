package ccom.wagnerww.cleanarch.quarkus.eventstore.producer;

import java.nio.charset.StandardCharsets;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.wagnerww.cleanarch.quarkus.domain.eventstore.events.EventStoreInputEvent;
import com.wagnerww.cleanarch.quarkus.domain.eventstore.events.EventStoreProducerEventRepository;
import com.wagnerww.cleanarch.quarkus.eventstore.create.CreateEventStoreInput;
import com.wagnerww.cleanarch.quarkus.eventstore.create.CreateEventStoreUseCase;

@Named
@ApplicationScoped
public class EventStoreProducerEventRepositoryImpl implements
  EventStoreProducerEventRepository {

  private final static String QUEUE_NAME = "Event_store";
  private final static String EXCHANGE_NAME = "Event_store_Direct";

  private final CreateEventStoreUseCase createEventStoreUseCase;

  @Inject
  public EventStoreProducerEventRepositoryImpl(
    final CreateEventStoreUseCase createEventStoreUseCase
  ) {
    this.createEventStoreUseCase = createEventStoreUseCase;
  }

  @Override
  public void send(EventStoreInputEvent aEventStoreInput) {

    try {

      ObjectMapper mapper = new ObjectMapper();
      mapper.registerModule(new JavaTimeModule());
      mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


      String domainJson = mapper.writeValueAsString(aEventStoreInput.getPayload());

      CreateEventStoreInput eventStoreInput = new CreateEventStoreInput();
      eventStoreInput.setAggregate(aEventStoreInput.getAggregate());
      eventStoreInput.setAggregateId(aEventStoreInput.getAggregateId());
      eventStoreInput.setAction(aEventStoreInput.getAction());
      eventStoreInput.setPayload(domainJson);
      eventStoreInput.setUserDispatch(aEventStoreInput.getUserDispatch());
      eventStoreInput.setIsSycnNeeded(true);

      String eventStoreInputJson = mapper.writeValueAsString(eventStoreInput);

      try {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, false, false, null);
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
            channel.basicPublish(EXCHANGE_NAME, "", null, eventStoreInputJson.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + eventStoreInputJson + "'");
        } catch (Exception e) {
          System.out.println("Error_rabbit"+e);
          createEventStoreUseCase.execute(eventStoreInput);
        }
      } catch (Exception e) {
        System.out.println("Error_rabbit"+e);
        createEventStoreUseCase.execute(eventStoreInput);
      } 
    } catch (Exception e) {
      System.out.println("Error to converter event "+e);
    }

  }
  
}
