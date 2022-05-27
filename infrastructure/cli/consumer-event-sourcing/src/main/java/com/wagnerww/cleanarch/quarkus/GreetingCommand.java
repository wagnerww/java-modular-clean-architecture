package com.wagnerww.cleanarch.quarkus;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import ccom.wagnerww.cleanarch.quarkus.eventstore.consumer.EventStoreConsumer;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.Scheduled.ConcurrentExecution;
import picocli.CommandLine.Command;

@Dependent
@QuarkusMain
public class GreetingCommand implements QuarkusApplication {

    @Inject
    private  EventStoreConsumer eventStoreConsumer;

    @Override
    public int run(String... args) throws Exception {      
        Quarkus.waitForExit();

        return 0;
    }

    @Scheduled(every = "1s", concurrentExecution = ConcurrentExecution.SKIP )
    public void test(){
        eventStoreConsumer.persistEvent();
    }

}
