import io.confluent.kafka.schemaregistry.json.JsonSchema

import java.nio.file.{Files, Path}
import scala.util.CommandLineParser
import scala.jdk.CollectionConverters.*

given scala.util.CommandLineParser.FromString[Path] with
  def fromString(s: String): Path =
    Path.of(s)

@main
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
