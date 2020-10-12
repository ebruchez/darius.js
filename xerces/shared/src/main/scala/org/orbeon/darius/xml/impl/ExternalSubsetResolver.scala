/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.orbeon.darius.xml.impl

import java.io.IOException

import org.orbeon.darius.xml.xni.XNIException
import org.orbeon.darius.xml.xni.grammars.XMLDTDDescription
import org.orbeon.darius.xml.xni.parser.XMLEntityResolver
import org.orbeon.darius.xml.xni.parser.XMLInputSource

/**
 * This interface extends `XMLEntityResolver` providing
 * a method to resolve external subsets for documents which do not
 * explicitly provide one. The application can register an object that
 * implements this interface with the parser configuration. If registered,
 * it will be queried to locate an external subset when none is provided,
 * even for documents that do not contain DOCTYPE declarations. If the
 * registered external subset resolver does not provide an external subset
 * for a given document, it should return `null`.
 */
trait ExternalSubsetResolver extends XMLEntityResolver {

  /**
   * Locates an external subset for documents which do not explicitly
   * provide one. If no external subset is provided, this method should
   * return `null`.
   *
   * @param grammarDescription a description of the DTD
   *
   * @throws XNIException Thrown on general error.
   * @throws IOException  Thrown if resolved entity stream cannot be
   *                      opened or some other i/o error occurs.
   */
  def getExternalSubset(grammarDescription: XMLDTDDescription): XMLInputSource
}