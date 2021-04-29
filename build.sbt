name := "AutomationProject"

version := "0.1"

scalaVersion := "2.13.5"

idePackagePrefix := Some("org.eleven")

val argonaut = "io.argonaut" %% "argonaut" % "6.3.3"
val FontAwesomeFX = "de.jensd" % "fontawesomefx-fontawesome" % "4.7.0-9.1.2"
libraryDependencies ++= Seq(argonaut, FontAwesomeFX)

/*
//Determine OS Version of JFX Binaries
lazy val OS_Name = System.getProperty("os.name") match {
    case n if n.startsWith("Linux") => "linux"
    case n if n.startsWith("Mac")   => "mac"
    case n if n.startsWith("Windows")   => "win"
    case _ => throw new Exception("Unknown Platform!")
}

//Add JFX Libraries as OS Dependent
lazy val JFXPrefixes = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
lazy val JFXModuleIDs = JFXPrefixes.map(m =>
    "org.openjfx" % s"javafx-$m" % "16" classifier OS_Name)
libraryDependencies ++= JFXModuleIDs

 */