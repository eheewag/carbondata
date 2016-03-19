<<<<<<< HEAD
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.huawei.datasight.carbon.testsuite.aggquery

import org.scalatest.BeforeAndAfter
import org.apache.spark.sql.common.util.QueryTest
import org.apache.spark.sql.common.util.CarbonHiveContext._
import org.apache.spark.sql.Row

/**
 * Test Class for aggregate query on Integer datatypes
 * @author N00902756
 *
 */
class IntegerDataTypeTestCase extends QueryTest with BeforeAndAfter {
  
  import org.apache.spark.sql.common.util.CarbonHiveContext.implicits._
  
  before
  {
	  sql("CREATE CUBE integertypecube DIMENSIONS (empno Integer, workgroupcategory Integer, deptno Integer, projectcode Integer) MEASURES (attendance Integer) OPTIONS (PARTITIONER [PARTITION_COUNT=1])")
	  sql("LOAD DATA fact from './TestData/data.csv' INTO CUBE integertypecube PARTITIONDATA(DELIMITER ',', QUOTECHAR '\"')")
  }
  test("select empno from integertypecube") {
    checkAnswer(
      sql("select empno from integertypecube"),
      Seq(Row(11),Row(12),Row(13),Row(14),Row(15),Row(16),Row(17),Row(18),Row(19),Row(20)))
  }
  after
  {
	  sql("drop cube integertypecube")
  }
=======
package com.huawei.datasight.carbon.testsuite.aggquery

import org.scalatest.BeforeAndAfter
import org.apache.spark.sql.common.util.QueryTest
import org.apache.spark.sql.common.util.CarbonHiveContext._
import org.apache.spark.sql.Row

/**
 * Test Class for aggregate query on Integer datatypes
 * @author N00902756
 *
 */
class IntegerDataTypeTestCase extends QueryTest with BeforeAndAfter {
  
  import org.apache.spark.sql.common.util.CarbonHiveContext.implicits._
  
  before
  {
	  sql("CREATE CUBE integertypecube DIMENSIONS (empno Integer, workgroupcategory Integer, deptno Integer, projectcode Integer) MEASURES (attendance Integer) OPTIONS (PARTITIONER [PARTITION_COUNT=1])")
	  sql("LOAD DATA fact from './TestData/data.csv' INTO CUBE integertypecube PARTITIONDATA(DELIMITER ',', QUOTECHAR '\"')")
  }
  test("select empno from integertypecube") {
    checkAnswer(
      sql("select empno from integertypecube"),
      Seq(Row(11),Row(12),Row(13),Row(14),Row(15),Row(16),Row(17),Row(18),Row(19),Row(20)))
  }
  after
  {
	  sql("drop cube integertypecube")
  }
>>>>>>> Moved test cases
}