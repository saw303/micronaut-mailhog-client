package io.wangler.micronaut.mailhog;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client(id="mailhog")
public interface MailHogClient {

    @Get("/api/v2/messages")
    @Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_JSON})
    AllMessagesResponse findAllMessages();

    @Get("/api/v2/messages")
    @Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_JSON})
    AllMessagesResponse findAllMessages(@QueryValue(defaultValue = "0") int start, @QueryValue(defaultValue = "50") int end);
}
