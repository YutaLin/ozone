/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ozone.recon.codegen;

import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;
import org.jooq.meta.TableDefinition;
import org.jooq.tools.StringUtils;

/**
 * Generate Table classes with a different name from POJOS to improve
 * readability, loaded at runtime.
 */
public class TableNamingStrategy extends DefaultGeneratorStrategy {
  @Override
  public String getJavaClassName(Definition definition, Mode mode) {
    if (definition instanceof TableDefinition && mode == Mode.DEFAULT) {
      StringBuilder result = new StringBuilder();

      result.append(StringUtils.toCamelCase(
          definition.getOutputName()
              .replace(' ', '_')
              .replace('-', '_')
              .replace('.', '_')
      ));

      result.append("Table");
      return result.toString();
    } else {
      return super.getJavaClassName(definition, mode);
    }
  }
}
