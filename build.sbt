name := "kittens-high-on-catnip-example"

version := "0.1"

scalaVersion := "2.12.12"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.3.1",
  "org.typelevel" %% "kittens" % "2.2.1",
  "io.scalaland" %% "catnip" % "1.1.2",
  "org.scalatest" %% "scalatest-flatspec" % "3.2.2" % "test",
  "org.scalatest" %% "scalatest-shouldmatchers" % "3.2.2" % "test"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross sbt.CrossVersion.patch)
