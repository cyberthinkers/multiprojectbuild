import sbt._
import sbt.Keys._

import org.scalajs.sbtplugin._
import ScalaJSPlugin.autoImport._
import org.scalajs.sbtplugin.cross
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object MultiprojectBuild extends Build {

lazy val commonSettings =
	Seq(organization := "com.example",
		version := "0.1.0",
		scalaVersion := "2.11.5")

lazy val shared = 
	Project(id = "multiproject_shared", base = file("shared")).
	enablePlugins(ScalaJSPlugin).
	settings(commonSettings: _*)

lazy val jvm =
	Project(id = "multiproject_jvm", base = file("jvm")).
	settings(commonSettings: _*).
	dependsOn(shared)

lazy val js =
	Project(id = "multiproject_js", base = file("js")).
	enablePlugins(ScalaJSPlugin).
	settings(commonSettings: _*).
	settings(libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0").
	dependsOn(shared)
}