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

## Running MailHog using Docker Compose

The following `docker-compose.yml` allows you to run MailHog on your local machine. The SMTP is listening on port `1025` and the web interface is exposed on port `8025`.

```yaml
version: "3"
services:
  mail:
    image: mailhog/mailhog
    ports:
      - "127.0.0.1:8025:8025"
      - "127.0.0.1:1025:1025"
```

### Configuring MailHoq to persist its data in a MongoDB

This example below allows you to persist the email data in a MongoDB.

```yaml
version: "3"

services:
  mailhog:
    image: mailhog/mailhog
    depends_on:
      - mongodb
    ports:
      - "1025:1025"
      - "8025:8025"
    environment:
      - MH_STORAGE=mongodb
      - MH_MONGO_URI=mongodb:27017

  mongodb:
    image: mongo
    restart: always
    volumes:
      - ./mongodb:/data/db
```
