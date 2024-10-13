package com.ty.jmrp_logistics.configuration;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {

        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Server URL");

        Server prodServer = new Server();
        prodServer.setUrl("http://localhost:8080/swagger-ui/index.html");
        prodServer.setDescription("Swagger doc of jmrp");

        Contact contact = new Contact();
        contact.setEmail("info@jmrp.in");
        contact.setName("JMRP Logistics");
        contact.setUrl("https://www.JMRPDomainName.in");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info().title("JMRP Logistics").version("1.0")
                .contact(contact).description("endpoints.")
                .termsOfService("").license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}
