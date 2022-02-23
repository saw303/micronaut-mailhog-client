package io.wangler.micronaut.mailhog

import io.micronaut.http.MediaType
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import javax.mail.Message
import javax.mail.Multipart
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMessage
import javax.mail.internet.MimeMultipart
import java.time.LocalDateTime

@MicronautTest
class MailHoqClientSpec extends Specification {

    @Inject
    MailHogClient client

    void "Client get injected"() {
        expect:
        client
    }

    void "Read messages"() {

        when:
        AllMessagesResponse responseBefore = client.findAllMessages()

        then:
        noExceptionThrown()

        when:
        sendEmail("Your request", "Dear Peter. Thank you for your email. Kind regards, Doreen")

        and:
        AllMessagesResponse response = client.findAllMessages()

        then:
        with(response) {
            total == responseBefore.total + 1
            start == responseBefore.start
            count == responseBefore.count + 1
            items.size() == total
        }

        and:
        with(response.items.first()) {
            id
            from.toEmail() == 'hello@you.ch'
            to.size() == 1
            to.first().toEmail() == 'you@yourdomain.org'
            cc.isEmpty()
            bcc.isEmpty()

            subject() == 'Your request'
            body() == 'Dear Peter. Thank you for your email. Kind regards, Doreen'

            mime.parts.first().mediaType().get() == MediaType.TEXT_PLAIN_TYPE

            raw.from == from.toEmail()
            raw.to == to.collect { it.toEmail() }
            raw.data
            raw.helo
        }

        when:
        MailHogItem item = client.findMessage(response.items.first().id)

        then:
        item == response.items.first()

        when:
        AllMessagesResponse search = client.searchMessages(MailHogClient.MessageKind.from, 'hello')

        then:
        with(search) {
            total == 1
            start == 0
            count == 1
            items.size() == total
        }

        when:
        client.deleteMessage(response.items.first().id)

        then:
        noExceptionThrown()

        when:
        client.findMessage(response.items.first().id)

        then: 'unfortunately MailHog return 200 and body null instead of 404 w/o a body'
        thrown(HttpClientResponseException)

        when:
        client.deleteMessages()

        and:
        response = client.findAllMessages()

        then:
        with(response) {
            total == 0
            start == 0
            count == 0
            items.isEmpty()
        }

    }

    private void sendEmail() {
        sendEmail("Test Message ${LocalDateTime.now()}", "This is a text")
    }

    private void sendEmail(String subject, String body) {
        Properties prop = new Properties()
        prop.put("mail.smtp.auth", false)
        prop.put("mail.smtp.host", "localhost")
        prop.put("mail.smtp.port", "1025")

        Session session = Session.getInstance(prop)

        Message message = new MimeMessage(session)
        message.setFrom("hello@you.ch")
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("you@yourdomain.org"))
        message.subject = subject

        MimeBodyPart bodyPart = new MimeBodyPart()
        bodyPart.setContent(body, "text/plain; charset=utf-8")

        Multipart part = new MimeMultipart()
        part.addBodyPart(bodyPart)
        message.setContent(part)

        Transport.send(message)
    }
}
