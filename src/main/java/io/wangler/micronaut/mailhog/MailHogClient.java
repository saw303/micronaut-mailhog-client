/*
 * Copyright 2022 Silvio Wangler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.wangler.micronaut.mailhog;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client(id = "mailhog")
public interface MailHogClient {

  @Get("/api/v2/messages")
  @Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_JSON})
  AllMessagesResponse findAllMessages();

  @Get("/api/v2/messages")
  @Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_JSON})
  AllMessagesResponse findAllMessages(
      @QueryValue(defaultValue = "0") int start, @QueryValue(defaultValue = "50") int end);

  @Get("/api/v1/messages/{id}")
  @Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_JSON})
  MailHogItem findMessage(String id);

  @Delete("/api/v1/messages/{id}")
  @Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_JSON})
  void deleteMessage(String id);

  @Delete("/api/v1/messages")
  @Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_JSON})
  void deleteMessages();

  @Get("/api/v2/search")
  @Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_JSON})
  AllMessagesResponse searchMessages(@QueryValue MessageKind kind, @QueryValue String query);

  enum MessageKind {
    containing,
    to,
    from
  }
}
