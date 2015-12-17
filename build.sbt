import sbt.Project.projectToRef

lazy val clients = Seq(client)
lazy val scalaV = "2.11.7"

lazy val server = (project in file(".")).settings(
  scalaVersion := scalaV,
  scalaJSProjects := clients,
  pipelineStages in Assets := Seq(scalaJSProd, digest, gzip),
  pipelineStages := Seq(scalaJSProd, uglify, digest, gzip),
  resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases",
  libraryDependencies ++= Seq(
    "org.webjars" % "jquery" % "2.1.4",
    "org.webjars" %% "webjars-play" % "2.4.0-1",
    specs2 % Test
  )
).enablePlugins(PlayScala).
  aggregate(clients.map(projectToRef): _*)

lazy val client = (project in file("client")).settings(
  scalaVersion := scalaV,
  persistLauncher := true,
  persistLauncher in Test := false,
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.2",
    "be.doeraene" %%% "scalajs-jquery" % "0.8.1"
  ),
  scalaJSStage in Global := FastOptStage
).enablePlugins(ScalaJSPlugin, ScalaJSPlay)

scalaJSStage in Global := FastOptStage

// loads the Play project at sbt startup
onLoad in Global := (Command.process("project server", _: State)) compose (onLoad in Global).value