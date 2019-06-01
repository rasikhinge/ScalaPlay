name := """play-ground"""
organization := "com.scalaplayground"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.2" % Test
libraryDependencies += "log4j" % "log4j" % "1.2.15" excludeAll(
  ExclusionRule(organization = "com.sun.jdmk"),
  ExclusionRule(organization = "com.sun.jmx"),
  ExclusionRule(organization = "javax.jms")
)
libraryDependencies += "joda-time" % "joda-time" % "2.10.2"


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.scalaplayground.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.scalaplayground.binders._"
