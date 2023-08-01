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

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@Serdeable
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
