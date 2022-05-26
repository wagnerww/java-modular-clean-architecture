package com.wagnerww.cleanarch.quarkus.config;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
        tags = {
                @Tag(name = "/v1/products", description = "API's para produtos")
        },
        info = @Info(
                title = "Sistema de exemplo de produtos",
                version = "1.0.0",
                contact = @Contact(
                        name = "Entre em contato",
                        url = "https:www.wagnerww.com/")),
        servers = {
                @Server(url = "http://localhost:8080")
        })
public class OpenApiConfig extends Application {
  
}
