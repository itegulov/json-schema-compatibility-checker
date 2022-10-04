ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.0"

resolvers += "confluent-maven" at "https://packages.confluent.io/maven/"

libraryDependencies ++= Seq(
  "io.confluent" % "kafka-json-schema-provider" % "7.2.2",
  "org.scalatest" %% "scalatest" % "3.2.14" % Test
)

lazy val root = (project in file("."))
  .settings(
    name := "json-schema-compatibility-checker"
  )
