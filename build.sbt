name := """backproc-scala"""
organization := "com.zkres"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"
resolvers += "softprops-maven" at "http://dl.bintray.com/content/softprops/maven"
libraryDependencies += "me.lessis" %% "base64" % "0.2.0"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.zkres.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.zkres.binders._"
