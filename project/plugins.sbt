ThisBuild / libraryDependencySchemes += "org.scala-lang.modules"            %% "scala-xml" % Version.Scheme.Always
addSbtPlugin("org.scalameta"     % "sbt-scalafmt"        % "2.5.6")
addSbtPlugin("com.typesafe.play" % "sbt-plugin"          % "2.9.10")
addSbtPlugin("com.github.sbt"    % "sbt-native-packager" % "1.11.7")
