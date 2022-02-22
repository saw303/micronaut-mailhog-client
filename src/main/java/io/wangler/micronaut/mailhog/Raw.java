package io.wangler.micronaut.mailhog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Raw {

    @JsonProperty("From")
    private String from;
    @JsonProperty("To")
    private List<String> to = new ArrayList<>();
    @JsonProperty("Data")
    private String data;
    @JsonProperty("Helo")
    private String helo;
}
