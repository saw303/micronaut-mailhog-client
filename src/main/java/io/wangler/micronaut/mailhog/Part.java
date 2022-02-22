package io.wangler.micronaut.mailhog;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.http.MediaType;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Data
public class Part {
    @JsonProperty("Headers")
    private Map<String, List<String>> headers = new HashMap<>();
    @JsonProperty("Body")
    private String body;
    @JsonProperty("Size")
    private long size;
    @JsonProperty("MIME")
    private String mime;


    public Optional<MediaType> mediaType() {
        if (headers.containsKey("Content-Type")) {
            return Optional.of(new MediaType(headers.get("Content-Type").get(0)))  ;
        }
        return Optional.empty();
    }
}
