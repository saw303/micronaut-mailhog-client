package io.wangler.micronaut.mailhog;

import lombok.Data;

import java.util.List;

@Data
public class Raw {

    private String from;
    private List<String> to;
    private String data;
    private String helo;
}
