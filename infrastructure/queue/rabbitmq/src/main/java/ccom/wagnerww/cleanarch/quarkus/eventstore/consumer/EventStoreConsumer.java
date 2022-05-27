package ccom.wagnerww.cleanarch.quarkus.eventstore.consumer;

import java.util.concurrent.TimeoutException;

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
import com.rabbitmq.client.DeliverCallback;
import com.wagnerww.cleanarch.quarkus.eventstore.create.CreateEventStoreInput;
import com.wagnerww.cleanarch.quarkus.eventstore.create.CreateEventStoreUseCase;

@Named
@ApplicationScoped
public class EventStoreConsumer {

  private final static String EXCHANGE_NAME = "Event_store_Direct";
  private final static String QUEUE_NAME = "Event_store";
  
  private final CreateEventStoreUseCase createEventStoreUseCase;

  @Inject
  public EventStoreConsumer(
    final CreateEventStoreUseCase createEventStoreUseCase
  ) {
    this.createEventStoreUseCase = createEventStoreUseCase;
  }

  
  public void persistEvent() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    final ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    try {
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, false, false, null);
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
        
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        //channel.basicQos(1);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
          channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

          String message = new String(delivery.getBody(), "UTF-8");

          System.out.println(" [x] Received '" + message + "'");           
           
          try {
            CreateEventStoreInput createEventStoreInput = mapper.readValue(message, CreateEventStoreInput.class);
            createEventStoreInput.setIsSycnNeeded(false);
            createEventStoreUseCase.execute(createEventStoreInput);
            
          } catch (Exception e) {
            System.out.println("Problema ao ler mensagem"+e);
            e.getStackTrace();
          } finally {
            System.out.println(" [x] Done");
          }
            
        };

        channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> {

        });
    } catch (Exception e) {
      //TODO: handle exception
    }
    
  }

 
}
