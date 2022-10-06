name := "jsonschemacompat"
organization := "me.daniyar"
organizationName := "Daniyar Itegulov"
version := "0.1.0"

scalaVersion := "3.2.0"

resolvers += "confluent-maven" at "https://packages.confluent.io/maven/"
libraryDependencies ++= Seq(
  "io.confluent" % "kafka-json-schema-provider" % "7.2.2",
  "org.scalatest" %% "scalatest" % "3.2.14" % Test
)

// Native packager
enablePlugins(JavaAppPackaging)
maintainer := "Daniyar Itegulov <ditegulov@gmail.com>"
packageSummary := "A micro-tool for checking JSON Schema compatibility"
Debian / name := "jsonschemacompat"
