# vertx-scala-test-helpers

Provides a non-runnable module with Vert.x helpers for Scala are useful for test classes.

The newest version is found at the [campudus/vertx-scala-test-helpers GitHub repository][https://github.com/campudus/vertx-scala-test-helpers].

## Dependencies

This module needs the [Vert.x Gradle plugin][https://github.com/vert-x/gradle-plugin] to build.

Should be available in the maven repository as `org.vert-x:gradle-plugin:1.3.0-SNAPSHOT`.

It also needs the [com.campudus.vertx-scala-core-helpers-v0.5][https://github.com/campudus/vertx-scala-core-helpers] module.

## Installation

In your own modules, you need to include this module in your `mod.json` by adding: `"includes" : "com.campudus.vertx-scala-test-helpers-v0.5".

## Usage

For TestClasses, extend `com.campudus.vertx.scala.framework.TestClientBase`.

If you don't extend one of this class, but still want to use the implicits, either extend the trait `com.campudus.vertx.scala.VertxScalaHelpers` or use `import com.campudus.vertx.scala.VertxScalaHelpers._` to import the implicits from its companion object.
