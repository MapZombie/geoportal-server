/*
 * Copyright 2015 Esri, Inc..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.esri.gpt.control.cart;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * "/try" response
 * @author Esri, Inc.
 */
public class TryResponse {
  private final Set<String> accepted = new HashSet<String>();
  private final Set<String> rejected = new HashSet<String>();

  public Set<String> getAccepted() {
    return Collections.unmodifiableSet(accepted);
  }

  public Set<String> getRejected() {
    return Collections.unmodifiableSet(rejected);
  }
  
  public void accept(String key) {
    rejected.remove(key);
    accepted.add(key);
  }
  
  public void reject(String key) {
    accepted.remove(key);
    rejected.add(key);
  }
  
  public void add(String key, boolean accept) {
    if (accept)
      accept(key);
    else
      reject(key);
  }
}