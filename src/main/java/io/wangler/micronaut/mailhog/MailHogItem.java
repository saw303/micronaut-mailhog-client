package io.wangler.micronaut.mailhog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class MailHogItem {

    @JsonProperty("ID")
    private String id;
    @JsonProperty("From")
    private Contact from;
    @JsonProperty("To")
    private List<Contact> to = new ArrayList<>();
    @JsonProperty("Cc")
    private List<Contact> cc = new ArrayList<>();
    @JsonProperty("Bcc")
    private List<Contact> bcc = new ArrayList<>();
    @JsonProperty("Content")
    private Content content;
    @JsonProperty("Created")
    private Instant created;
    @JsonProperty("MIME")
    private Mime mime;
    @JsonProperty("Raw")
    private Raw raw;

    public String subject() {
        return getContent().readSingleHeaderValue("Subject");
    }

    public String body() {
        List<Part> parts = getMime().getParts();

        if (parts.isEmpty()) {
            return null;
        }
        return parts.get(0).getBody();
    }
}
