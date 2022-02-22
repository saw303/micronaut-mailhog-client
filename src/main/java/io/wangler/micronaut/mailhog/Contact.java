package io.wangler.micronaut.mailhog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Contact {

    @JsonProperty("Relays")
    private List<String> relays = new ArrayList<>();
    @JsonProperty("Mailbox")
    private String mailbox;
    @JsonProperty("Domain")
    private String domain;
    @JsonProperty("Params")
    private String params;

    public String toEmail() {
        return getMailbox() + "@" + getDomain();
    }
}
