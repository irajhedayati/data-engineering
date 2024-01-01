organization := "ca.dataedu"

name := "data-engineering"

scalaVersion := "2.13.12"

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
  dockerBaseImage := "adoptopenjdk/openjdk11",
  dockerRepository := Some("index.docker.io/hedayati"),
  dockerEntrypoint ++= Seq("-Dhttp.port=80", "-Dplay.http.secret.key=8jPv+LKQZpiqG+x8r/sFXKjaftDWjYT7qF+Ua36/1AA=")
)

val CirceVersion = "0.14.6"
val EnumeratumCirceVersion = "1.7.3"
val LogbackVersion = "1.4.14"
val ScalaLoggingVersion = "3.9.5"
val SttpVersion = "3.9.1"
val TapirVersion = "1.9.2"

lazy val root = (project in file("."))
  .settings(
    libraryDependencies ++= Seq(
      "ca.dataedu" %% "savro" % "0.7.0",
      ("org.apache.avro" % "avro"          % "1.9.0").exclude("com.fasterxml.jackson.core", "jackson-core"),
      ("org.apache.avro" % "avro-tools"    % "1.9.0").exclude("com.fasterxml.jackson.core", "jackson-core"),
      ("org.apache.avro" % "avro-compiler" % "1.9.0").exclude("com.fasterxml.jackson.core", "jackson-core"),
      "com.beachape"                  %% "enumeratum-circe"        % EnumeratumCirceVersion,
      "com.typesafe.scala-logging"    %% "scala-logging"           % ScalaLoggingVersion,
      "ch.qos.logback"                % "logback-classic"          % LogbackVersion,
      "io.circe"                      %% "circe-generic"           % CirceVersion,
      "io.circe"                      %% "circe-parser"            % CirceVersion,
      "com.softwaremill.sttp.client3" %% "core"                    % SttpVersion,
      "com.softwaremill.sttp.client3" %% "circe"                   % SttpVersion,
      "com.beachape"                  %% "enumeratum-circe"        % EnumeratumCirceVersion,
      "com.softwaremill.sttp.tapir"   %% "tapir-core"              % TapirVersion,
      "com.softwaremill.sttp.tapir"   %% "tapir-json-circe"        % TapirVersion,
      "com.softwaremill.sttp.tapir"   %% "tapir-swagger-ui-bundle" % TapirVersion,
      "com.softwaremill.sttp.tapir"   %% "tapir-akka-http-server"  % TapirVersion
    )
  )
  .enablePlugins(JavaAppPackaging, DockerPlugin)
  .settings(dockerSettings)
  .settings(
    javacOptions ++= Seq("-source", "11", "-target", "11")
  )
