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
import io.micronaut.http.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.Data;

@Data
public class Part {
  @JsonProperty("Headers")
  private Map<String, List<String>> headers = new HashMap<>();

  @JsonProperty("Body")
  private String body;

  @JsonProperty("Size")
  private long size;

  @JsonProperty("MIME")
  private Mime mime;

  public Optional<MediaType> mediaType() {
    if (headers.containsKey("Content-Type")) {
      return Optional.of(new MediaType(headers.get("Content-Type").get(0)));
    }
    return Optional.empty();
  }
}
