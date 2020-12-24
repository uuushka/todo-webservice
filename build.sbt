name := "todo-webservice"

version := "0.1"

scalaVersion := "2.13.4"

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.1" cross CrossVersion.full)

//circe
val circeVersion = "0.12.3"

// for @JsonCodec
scalacOptions ++= Seq("-Ymacro-annotations")

libraryDependencies += "org.typelevel" %% "cats-core" % "2.1.1"
libraryDependencies += "org.typelevel" %% "cats-effect" % "2.3.0-M1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

resolvers += Resolver.sonatypeRepo("snapshots")

val http4sVersion = "0.21.14"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion,
  "org.http4s" %% "http4s-circe" % http4sVersion,
  "org.postgresql" % "postgresql" % "42.2.2",
  "org.scalatest" %% "scalatest" % "3.2.3" % Test,
  "com.dimafeng" %% "testcontainers-scala-postgresql" % "0.38.7" % Test,
  "com.dimafeng" %% "testcontainers-scala-scalatest" % "0.38.7" % Test,
  "com.typesafe.slick" %% "slick" % "3.3.3"
)

libraryDependencies += "com.codecommit" %% "cats-effect-testing-scalatest" % "0.5.0" % Test