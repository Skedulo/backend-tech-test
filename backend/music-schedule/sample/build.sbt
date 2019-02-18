import sbtassembly.AssemblyPlugin.defaultUniversalScript

name := "music-schedule"
version := "0.1"

val circeVersion = "0.9.3"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-java8" % circeVersion,

  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

mainClass in assembly := Some("com.skedulo.music.Scheduler")
assemblyOption in assembly := (assemblyOption in assembly).value.copy(prependShellScript = Some(defaultUniversalScript(shebang = false)))
