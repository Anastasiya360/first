package com.example.first.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.persistence.Column;

@OpenAPIDefinition(
        info = @Info(
                title = "First",
                description = "Online Shop", version = "2.6.0",
                contact = @Contact (
                        name = "Anastasiya",
                        email = "n.bogocharova@gmail.com"
                )
        )
)
public class OpenApiConfig {

}
