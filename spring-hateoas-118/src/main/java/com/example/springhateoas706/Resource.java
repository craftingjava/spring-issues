package com.example.springhateoas706;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Resource extends ResourceSupport {

    private ResourceId resourceId;
    private String status;

    public Resource(ResourceId resourceId, String status) {
        this.resourceId = resourceId;
        this.status = status;
    }

}
