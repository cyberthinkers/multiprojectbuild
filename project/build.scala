import sbt._
import sbt.Keys._

import org.scalajs.sbtplugin._
//import ScalaJSPlugin.autoImport._
import org.scalajs.sbtplugin.cross._
//import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import org.scalajs.sbtplugin.cross.CrossProject
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import org.scalajs.sbtplugin.cross.CrossType

object MultiprojectBuild extends Build {

lazy val globalSettings =
	Seq(organization := "com.example",
		version := "0.1.0",
		scalaVersion := "2.11.6")
		
lazy val root =
	Project(id = "multiproject_root", base = file("."))
	.settings(globalSettings: _*)
	.aggregate(sharedsjs, sharedjvm, jvm, sjs)
	.dependsOn(jvm, sjs)

lazy val sharedsjs =
	Project(id = "multiproject_sharedsjs", base = file("sharedsjs"))
	.enablePlugins(ScalaJSPlugin)
	.settings(globalSettings: _*)
	
lazy val sharedjvm =
	Project(id = "multiproject_sharedjvm", base = file("sharedjvm"))
	.settings(globalSettings: _*)
	.settings(unmanagedSourceDirectories in Compile += file("d:/cyberthinkers-dev/multiprojectbuild/sharedsjs") / "src")
	.dependsOn(sharedsjs)

lazy val jvm =
	Project(id = "multiproject_jvm", base = file("jvm"))
	.settings(globalSettings: _*)
	.dependsOn(sharedjvm)

lazy val sjs =
	Project(id = "multiproject_js", base = file("sjs"))
	.enablePlugins(ScalaJSPlugin)
	.settings(globalSettings: _*)
	.settings(libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0")
	.dependsOn(sharedsjs)
}