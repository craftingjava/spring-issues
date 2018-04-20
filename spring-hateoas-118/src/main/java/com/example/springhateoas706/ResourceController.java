package com.example.springhateoas706;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping(path = "/{resourceId}", produces = HAL_JSON_VALUE)
    public Resource getResource(@PathVariable ResourceId resourceId) {
        Resource resource = new Resource(resourceId, "start");
        resource.add(
                linkTo(methodOn(ResourceController.class).updateResourceStatus(resourceId, "end"))
                        .withRel("status"));
        return resource;
    }

    @PutMapping(path = "/{resourceId}/{status}", produces = HAL_JSON_VALUE)
    public Resource updateResourceStatus(@PathVariable ResourceId resourceId,
            @PathVariable String status) {
        return new Resource(resourceId, status);
    }

}
