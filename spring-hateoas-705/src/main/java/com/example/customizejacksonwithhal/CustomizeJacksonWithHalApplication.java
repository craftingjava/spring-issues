package com.example.customizejacksonwithhal;

import static org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType.HAL;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableHypermediaSupport(type = HAL)
public class CustomizeJacksonWithHalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomizeJacksonWithHalApplication.class, args);
    }

}

@RestController
class Controller {

    @GetMapping
    Response getResponse() {
        Response response = new Response(Optional.of("test"));
        response.add(ControllerLinkBuilder.linkTo(Controller.class).withSelfRel());
        return response;
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Response extends ResourceSupport {

    Optional<String> field;

}
