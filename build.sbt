ThisBuild / scalaVersion := "2.13.6"
ThisBuild / organization := "xyz.jeboria"

val circeVersion = "0.14.1"

lazy val root = (project in file("."))
  .settings(
    name := "Functional Blockchain",
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser"
    ).map(_ % circeVersion)
  )
