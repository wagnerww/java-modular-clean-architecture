package com.wagnerww.cleanarch.quarkus;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wagnerww.cleanarch.quarkus.product.create.UseCaseProductCreate;

@Path("/hello")
public class GreetingResource {

   // @Inject
    private UseCaseProductCreate useCaseProductCreate;

    
    GreetingResource( UseCaseProductCreate useCaseProductCreate) {
        this.useCaseProductCreate = useCaseProductCreate;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        useCaseProductCreate.execute();
        return "Hello from RESTEasy Reactive";
    }
}