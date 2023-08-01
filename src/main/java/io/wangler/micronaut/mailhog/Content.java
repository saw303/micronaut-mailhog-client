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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
@Serdeable
public class Content {

  @JsonProperty("Headers")
  private Map<String, List<String>> headers = new HashMap<>();

  public String readSingleHeaderValue(String headerName) {
    List<String> values = getHeaders().get(headerName);

    if (values == null || values.isEmpty()) {
      return null;
    }

    return values.get(0);
  }

  public List<String> readHeaderValues(String headerName) {
    List<String> values = getHeaders().get(headerName);

    if (values == null || values.isEmpty()) {
      return null;
    }
    return Collections.unmodifiableList(values);
  }
}
