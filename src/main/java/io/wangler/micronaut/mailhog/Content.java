package io.wangler.micronaut.mailhog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Content {

    @JsonProperty("Headers")
    private Map<String, List<String>> headers = new HashMap<>();

    public String readSingleHeaderValue(String headerName) {
        List<String> values = getHeaders().get(headerName);

        if (values == null || values.isEmpty()) {
            return null;
        }

        return values.get(0);
    }

    public List<String> readHeaderValues(String headerName) {
        List<String> values = getHeaders().get(headerName);

        if (values == null || values.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableList(values);
    }
}
