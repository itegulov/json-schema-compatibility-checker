package me.daniyar

import org.scalatest.*
import org.scalatest.flatspec.*
import org.scalatest.matchers.*

import java.nio.file.Path

class Positive extends AnyFlatSpec with should.Matchers {

  def resource(name: String): Path =
    Path.of(getClass.getResource(s"/$name").getPath)

  "Compatibility checker" should "report positive on the same file" in {
    checkCompatibility(resource("1.json"), resource("1.json")) should be (0)
  }

  it should "report positive on a file with an extra struct" in {
    checkCompatibility(resource("1.json"), resource("2.json")) should be (0)
  }
}
