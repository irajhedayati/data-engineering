val AvroVersion = "1.12.0"
val CirceVersion = "0.14.10"
val EnumeratumCirceVersion = "1.9.4"
val LogbackVersion = "1.5.15"
val ScalaLoggingVersion = "3.9.5"
val SttpVersion = "3.10.2"
val TapirVersion = "1.11.11"

lazy val root = (project in file("."))
  .settings(
    organization := "ca.dataedu",
    name := "data-engineering",
    scalaVersion := "2.13.15",
    maintainer := "hedayati",
    scalaBinaryVersion := "2.13",
    javacOptions ++= Seq("-source", "11", "-target", "11"),
    scalacOptions ++= Seq("-deprecation"),
    scalafmtOnCompile := true,
    useCoursier := false
  )
  .settings(
    libraryDependencies ++= Seq(
      "ca.dataedu"      %% "savro"            % "0.11.0",
      ("org.apache.avro" % "avro"             % AvroVersion).exclude("com.fasterxml.jackson.core", "jackson-core"),
      ("org.apache.avro" % "avro-tools"       % AvroVersion).exclude("com.fasterxml.jackson.core", "jackson-core"),
      ("org.apache.avro" % "avro-compiler"    % AvroVersion).exclude("com.fasterxml.jackson.core", "jackson-core"),
      "com.beachape"    %% "enumeratum-circe" % EnumeratumCirceVersion,
      "com.typesafe.scala-logging"    %% "scala-logging"           % ScalaLoggingVersion,
      "ch.qos.logback"                 % "logback-classic"         % LogbackVersion,
      "io.circe"                      %% "circe-generic"           % CirceVersion,
      "io.circe"                      %% "circe-parser"            % CirceVersion,
      "com.softwaremill.sttp.client3" %% "core"                    % SttpVersion,
      "com.softwaremill.sttp.client3" %% "circe"                   % SttpVersion,
      "com.softwaremill.sttp.tapir"   %% "tapir-core"              % TapirVersion,
      "com.softwaremill.sttp.tapir"   %% "tapir-json-circe"        % TapirVersion,
      "com.softwaremill.sttp.tapir"   %% "tapir-swagger-ui-bundle" % TapirVersion,
      "com.softwaremill.sttp.tapir"   %% "tapir-akka-http-server"  % TapirVersion,
      "com.google.cloud.functions"     % "functions-framework-api" % "1.1.0"
    )
  )
  .enablePlugins(JavaAppPackaging, DockerPlugin)
  .settings(
    Seq(
      Docker / maintainer := "Iraj Hedayati <iraj.hedayati@gmail.com>",
      dockerUpdateLatest := true,
      dockerBaseImage := "adoptopenjdk/openjdk11",
      dockerRepository := Some("index.docker.io/hedayati"),
      dockerExposedPorts := Seq(8080)
    )
  )
