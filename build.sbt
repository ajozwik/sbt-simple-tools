  import com.sksamuel.scapegoat.sbt.ScapegoatSbtPlugin.autoImport._
  import scalariform.formatter.preferences._

scalaVersion := "2.12.7"

organization := "pl.jozwik.demo"

name := "sbt-simple-tools"



scapegoatVersion in ThisBuild:= "1.3.8"


scalacOptions in ThisBuild ++= Seq(
  "-target:jvm-1.8",
  "-encoding", "UTF-8",
  "-deprecation", // warning and location for usages of deprecated APIs
  "-feature", // warning and location for usages of features that should be imported explicitly
  "-unchecked", // additional warnings where generated code depends on assumptions
  "-Xlint", // recommended additional warnings
  "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver
  "-Ywarn-value-discard", // Warn when non-Unit expression results are unused
  "-Ywarn-inaccessible",
  "-Ywarn-dead-code",
  "-language:reflectiveCalls",
  "-Ydelambdafy:method"
)

val `org.scalatest_scalatest` = "org.scalatest" %% "scalatest" % "3.0.5" % "test"

val `org.scalacheck_scalacheck` = "org.scalacheck" %% "scalacheck" % "1.14.0" % "test"

val `com.typesafe.scala-logging_scala-logging` = "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"

val `ch.qos.logback_logback-classic` = "ch.qos.logback" % "logback-classic" % "1.2.3"

lazy val root = projectName("root", new File(".")).settings(
  libraryDependencies ++= Seq(
    `org.scalatest_scalatest`,
    `org.scalacheck_scalacheck`,
    `com.typesafe.scala-logging_scala-logging`,
    `ch.qos.logback_logback-classic`
  ),
  packMain := Map("single" -> "pl.jozwik.demo.Main")
)
  .enablePlugins(PackPlugin)

def projectName(name: String, file: File): Project = Project(name, file).settings(
  publishArtifact in(Compile, packageDoc) := false,
  sources in(Compile, doc) := Seq.empty,
  scapegoatIgnoredFiles := Seq(".*/target/.*"),
  scalariformPreferences := scalariformPreferences.value
    .setPreference(AlignSingleLineCaseStatements, true)
    .setPreference(DoubleIndentConstructorArguments, true)
    .setPreference(DanglingCloseParenthesis, Preserve)
)
