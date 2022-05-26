package com.wagnerww.cleanarch.quarkus;

import javax.inject.Inject;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wagnerww.cleanarch.quarkus.product.activate.ActivateProductUseCase;
import com.wagnerww.cleanarch.quarkus.product.create.CreateProductUseCase;
import com.wagnerww.cleanarch.quarkus.product.create.CreateProdutInput;
import com.wagnerww.cleanarch.quarkus.product.create.CreateProdutOutput;
import com.wagnerww.cleanarch.quarkus.product.deactivate.DeactivateProductUseCase;
import com.wagnerww.cleanarch.quarkus.product.update.UpdateProductInput;
import com.wagnerww.cleanarch.quarkus.product.update.UpdateProductUseCase;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/v1/products")
public class GreetingResource {

   // @Inject
    private CreateProductUseCase useCaseProductCreate;
    private UpdateProductUseCase updateProductUseCase;
    private ActivateProductUseCase activateProductUseCase;
    private DeactivateProductUseCase deactivateProductUseCase;

    @Inject
    GreetingResource(
        CreateProductUseCase useCaseProductCreate,
        UpdateProductUseCase updateProductUseCase,
        ActivateProductUseCase activateProductUseCase,
        DeactivateProductUseCase deactivateProductUseCase
    ) {
        this.useCaseProductCreate = useCaseProductCreate;
        this.updateProductUseCase = updateProductUseCase;
        this.activateProductUseCase = activateProductUseCase;
        this.deactivateProductUseCase = deactivateProductUseCase;
    }

    @Operation(description = "Criação de produto")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    //@ResponseStatus(value = 201)
    public CreateProdutOutput create(@RequestBody CreateProdutInput anProduct) {
        return useCaseProductCreate.execute(anProduct);
        
    }

    @Operation(description = "Edição de produto")
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    //@ResponseStatus(value = 200)
    public void update(
        @PathParam("id") String id    ,
        @RequestBody UpdateProductInput anProduct
    ) {
        updateProductUseCase.execute(id, anProduct);
    }

    @Operation(description = "Ativação de produto")
    @PATCH
    @Path("/{id}/activate")
    @Produces(MediaType.APPLICATION_JSON)
    //@ResponseStatus(value = )
    public void activate(
        @PathParam("id") String id
    ) {
        activateProductUseCase.execute(id);
    }

    @Operation(description = "Desativação de produto")
    @PATCH
    @Path("/{id}/deactivate")
    @Produces(MediaType.APPLICATION_JSON)
    //@ResponseStatus(value = 200)
    public void deactivate(
        @PathParam("id") String id
    ) {
        deactivateProductUseCase.execute(id);
    }
}