# micronaut-mailhog-client
A simple micronaut http client for MailHog (https://github.com/mailhog/MailHog)


## Configure it

Configure the Micronaut client to access your MailHog.

````yaml
micronaut:
  http:
    services:
      mailhog:
        url: http://localhost:8025
````

## Use it

This is how you can read all the messages.

````java

@Singleton
public class MyService {
    @Inject
    private MailHogClient client;
    
    
    void runTheService() {

        // request all mails within MailHog.
        AllMessagesResponse responseBefore = client.findAllMessages();
    }
}
````
