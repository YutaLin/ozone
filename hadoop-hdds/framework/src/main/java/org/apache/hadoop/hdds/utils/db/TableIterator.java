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

package org.apache.hadoop.hdds.utils.db;

import java.io.Closeable;
import java.util.Iterator;

/**
 * To iterate a {@link Table}.
 *
 * @param <KEY> The key type to support {@link #seek(Object)}.
 * @param <T> The type to be iterated.
 */
public interface TableIterator<KEY, T> extends Iterator<T>, Closeable {
  @Override
  void close() throws RocksDatabaseException;

  /**
   * seek to first entry.
   */
  void seekToFirst();

  /**
   * seek to last entry.
   */
  void seekToLast();

  /**
   * Seek to the specific key.
   *
   * @param key - Bytes that represent the key.
   * @return VALUE.
   */
  T seek(KEY key) throws RocksDatabaseException, CodecException;

  /**
   * Remove the actual value of the iterator from the database table on
   * which the iterator is working on.
   */
  void removeFromDB() throws RocksDatabaseException, CodecException;

}
