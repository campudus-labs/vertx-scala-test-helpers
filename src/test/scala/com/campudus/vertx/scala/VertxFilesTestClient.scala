package com.campudus.vertx.scala

import org.vertx.java.core.AsyncResult
import com.campudus.vertx.scala.framework.TestClientBase

class VertxFilesTest extends TestClientBase {

  override def start() {
    super.start()

    // No modules needed for test
    tu.appReady();
  }

  override def stop() {
    super.stop();
  }

  def testFileCreate() {
    afterCreateFile { result => tu.testComplete }
  }

  def testFileDelete() {
    afterCreateFile { result =>
      vertx.fileSystem.delete("test.txt", true, {
        result: AsyncResult[Void] =>
          tu.testComplete
      })
    }
  }

  private def afterCreateFile(doNext: AsyncResult[Void] => Unit) {
    vertx.fileSystem.createFile("test.txt", {
      result: AsyncResult[Void] =>
        doNext(result)
    })
  }

}