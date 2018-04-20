package com.example.springhateoas706;

import java.io.Serializable;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(staticName = "of")
public class ResourceId implements Serializable {

    private final String id;

    public String toString() {
        return id;
    }

}
