package me.daniyar

import org.scalatest.*
import org.scalatest.flatspec.*
import org.scalatest.matchers.*

import java.nio.file.Path

class Negative extends AnyFlatSpec with should.Matchers {

  def resource(name: String): Path =
    Path.of(getClass.getResource(s"/$name").getPath)

  "Compatibility checker" should "report negative on a file with one less struct" in {
    checkCompatibility(resource("2.json"), resource("1.json")) should be (1)
  }
}
