package io.wangler.micronaut.mailhog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Mime {

    @JsonProperty("Parts")
    private List<Part> parts = new ArrayList<>();
}
