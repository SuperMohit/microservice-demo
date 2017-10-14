package com.search.engine1.configuration;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@SwaggerDefinition(
        info = @Info(
                description = "Gets the weather",
                version = "V12.0.12",
                title = "The Weather API",
                termsOfService = "http://theweatherapi.io/terms.html",
                contact = @Contact(
                   name = "Rain Moore", 
                   email = "rain.moore@theweatherapi.io", 
                   url = "http://theweatherapi.io"
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        tags = {
                @Tag(name = "Private", description = "Tag used to denote operations as private")
        }, 
        externalDocs = @ExternalDocs(value = "Meteorology", url = "http://theweatherapi.io/meteorology.html")
)
public interface MovieRestDoc {

}
