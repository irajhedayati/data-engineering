organization := "ca.dataedu"

name := "data-engineering"

scalaVersion := "2.13.0"

maintainer := "hedayati"

lazy val rpmAppSettings = Seq(
  rpmVendor := "Hedayati",
  rpmRelease := sys.env.getOrElse("BUILD_NUMBER", "1"),
  rpmLicense := Some("FIXME"),
  packageArchitecture := "noarch",
  rpmBrpJavaRepackJars := true
)

lazy val dockerSettings = Seq(
  maintainer in Docker := "Iraj Hedayati <iraj.hedayati@gmail.com>",
  dockerUpdateLatest := true,
  dockerRepository := Some("index.docker.io/hedayati"),
  dockerEntrypoint ++= Seq("-Dhttp.port=80", "-Dplay.http.secret.key=8jPv+LKQZpiqG+x8r/sFXKjaftDWjYT7qF+Ua36/1AA=")
)

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .enablePlugins(JavaAppPackaging, DockerPlugin)
  .settings(dockerSettings)

libraryDependencies ++= Seq(
  "ca.dataedu" %% "savro" % "0.7.0",
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test,
  ("org.apache.avro" % "avro"          % "1.9.0").exclude("com.fasterxml.jackson.core", "jackson-core"),
  ("org.apache.avro" % "avro-tools"    % "1.9.0").exclude("com.fasterxml.jackson.core", "jackson-core"),
  ("org.apache.avro" % "avro-compiler" % "1.9.0").exclude("com.fasterxml.jackson.core", "jackson-core")
)
