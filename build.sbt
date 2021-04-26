name := "AutomationProject"

version := "0.1"

scalaVersion := "2.13.5"

idePackagePrefix := Some("org.eleven")

val json4s = "org.json4s" % "json4s-native_2.11" % "3.7.0-M16"
val ScalaFX = "org.scalafx" %% "scalafx" % "16.0.0-R22"

libraryDependencies ++= Seq(
    json4s, ScalaFX
)