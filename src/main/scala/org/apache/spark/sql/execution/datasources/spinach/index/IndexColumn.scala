/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.execution.datasources.spinach.index


/**
 * Identify a column for index definition, including column name and order
 */
private[sql] case class IndexColumn(columnName: String, isAscending: Boolean) {
  override def toString: String = quotedString

  def quotedString: String = s"`$columnName` ${if (isAscending) "ASC" else "DESC"}"

  def unquotedString: String = s"$columnName ${if (isAscending) "ASC" else "DESC"}"
}

private[sql] object IndexColumn {
  def apply(columnName: String, order: String): IndexColumn = order match {
    case "ASC" => new IndexColumn(columnName, true)
    case "DESC" => new IndexColumn(columnName, false)
  }

  def apply(columnName: String): IndexColumn = new IndexColumn(columnName, isAscending = true)
}