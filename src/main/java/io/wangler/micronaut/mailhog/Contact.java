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
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@Serdeable
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
