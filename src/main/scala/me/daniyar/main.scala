package me.daniyar

import io.confluent.kafka.schemaregistry.json.JsonSchema

import java.nio.file.{Files, Path}
import scala.jdk.CollectionConverters.*
import scala.util.CommandLineParser

given scala.util.CommandLineParser.FromString[Path] with
  def fromString(s: String): Path =
    Path.of(s)

def checkCompatibility(prevSchemaPath: Path, nextSchemaPath: Path): Int =
  val prevSchema = new JsonSchema(Files.readString(prevSchemaPath))
  val nextSchema = new JsonSchema(Files.readString(nextSchemaPath))
  val errorMessages = nextSchema.isBackwardCompatible(prevSchema)
  if errorMessages.isEmpty then
    println("The schemas are backwards compatible")
    0
  else
    println("The schemas are NOT backwards compatible:")
    println(errorMessages.asScala.mkString("\n"))
    1

@main
def main(prevSchemaPath: Path, nextSchemaPath: Path): Unit =
  System.exit(checkCompatibility(prevSchemaPath, nextSchemaPath))
