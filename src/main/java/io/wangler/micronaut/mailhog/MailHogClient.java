package io.wangler.micronaut.mailhog;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client(id="mailhog")
public interface MailHogClient {

    @Get("/api/v2/messages")
    AllMessagesResponse findAllMessages();

    @Get("/api/v2/messages")
    AllMessagesResponse findAllMessages(@QueryValue(defaultValue = "0") int start, @QueryValue(defaultValue = "50") int end);
}
