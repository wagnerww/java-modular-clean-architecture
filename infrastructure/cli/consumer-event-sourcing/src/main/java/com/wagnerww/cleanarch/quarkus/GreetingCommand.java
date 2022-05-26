package com.wagnerww.cleanarch.quarkus;

import java.math.BigDecimal;

import javax.inject.Inject;

import com.wagnerww.cleanarch.quarkus.product.create.CreateProductUseCase;
import com.wagnerww.cleanarch.quarkus.product.create.CreateProdutInput;

import picocli.CommandLine.Command;

@Command
public class GreetingCommand implements Runnable {

    @Inject
    private CreateProductUseCase createProductUseCase;
   
    @Override
    public void run() {
        System.out.printf("go go commando persistence!");
        CreateProdutInput anProduct = new CreateProdutInput();
        anProduct.setName("Produto CLI");
        anProduct.setPrice(BigDecimal.valueOf(25));
        createProductUseCase.execute(anProduct);
    }

}
