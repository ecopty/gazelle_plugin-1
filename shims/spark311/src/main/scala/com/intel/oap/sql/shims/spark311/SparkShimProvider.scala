/*
 * Copyright 2020 Intel Corporation
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

package com.intel.oap.sql.shims.spark311

import com.intel.oap.sql.shims.{SparkShims, SparkShimDescriptor}

object SparkShimProvider {
  // The shim layer for spark 3.1.1 is also workable for 3.1.2 & 3.1.3.
  val SPARK311_DESCRIPTOR = SparkShimDescriptor(3, 1, 1)
  val SPARK312_DESCRIPTOR = SparkShimDescriptor(3, 1, 2)
  val SPARK313_DESCRIPTOR = SparkShimDescriptor(3, 1, 3)
  val DESCRIPTOR_STRINGS =
    Seq(s"$SPARK311_DESCRIPTOR", s"$SPARK312_DESCRIPTOR", s"$SPARK313_DESCRIPTOR")
  val DESCRIPTOR = SPARK311_DESCRIPTOR
}

class SparkShimProvider extends com.intel.oap.sql.shims.SparkShimProvider {
  def createShim: SparkShims = {
    new Spark311Shims()
  }

  def matches(version: String): Boolean = {
    SparkShimProvider.DESCRIPTOR_STRINGS.contains(version)
  }
}
