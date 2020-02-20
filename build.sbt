name := """data-engineering"""
organization := "ca.dataedu"

version := "2.0"

scalaVersion := "2.13.0"

maintainer := "hedayati"

import com.typesafe.sbt.packager.rpm.RpmPlugin.autoImport.RpmConstants._
lazy val rpmAppSettings = Seq(
  rpmVendor := "Hedayati",
  rpmRelease := sys.env.getOrElse("BUILD_NUMBER", "1"),
  rpmLicense := Some("FIXME"),
  packageArchitecture := "noarch",
  rpmBrpJavaRepackJars := true
)

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .enablePlugins(JavaAppPackaging, RpmPlugin)
  .settings(rpmAppSettings)


libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
libraryDependencies += "org.apache.avro"        % "avro"                % "1.9.0" exclude("com.fasterxml.jackson.core", "jackson-core")
libraryDependencies += "org.apache.avro"        % "avro-tools"          % "1.9.0" exclude("com.fasterxml.jackson.core", "jackson-core")
libraryDependencies += "org.apache.avro"        % "avro-compiler"       % "1.9.0" exclude("com.fasterxml.jackson.core", "jackson-core")
