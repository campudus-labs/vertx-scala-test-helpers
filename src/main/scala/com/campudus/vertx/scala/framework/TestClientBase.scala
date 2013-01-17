package com.campudus.vertx.scala.framework

import java.util.concurrent.atomic.AtomicInteger
import org.vertx.java.testframework.TestUtils
import com.campudus.vertx.scala.VertxScalaHelpers
import org.vertx.java.core.logging.impl.LoggerFactory

trait TestClientBase extends org.vertx.java.testframework.TestClientBase with VertxScalaHelpers {
  implicit def enhancedToRegularTestUtils(en: EnhancedTestUtils): TestUtils = en.tu

  class EnhancedTestUtils(n: Int, val tu: TestUtils) {
    val numberOfTests = new AtomicInteger(math.max(n, 1))
    def testComplete(): Unit = testComplete {}
    def testComplete(fn: => Unit): Unit = if (numberOfTests.decrementAndGet == 0) {
      fn
      tu.testComplete
    }
  }

  def asyncTests(i: Int)(fn: EnhancedTestUtils => Unit)(implicit tu: TestUtils) = fn(new EnhancedTestUtils(i, tu))
}

object TestClientBase {
  private val log = LoggerFactory.getLogger(classOf[TestClientBase])
}