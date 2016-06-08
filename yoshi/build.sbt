name := """yoshi"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"


libraryDependencies += filters

//Declare dependencies

//Of course, first we’ll need to declare some dependencies to use slick,
// play-slick, and mysql - the chosen database for us. Add these 3 dependencies to your build.sbt
//Also, if you have a jdbc dependency declared in
// your build.sbt file, remove it, or it will cause some errors in the compilation.

libraryDependencies ++= Seq(
 // jdbc,
 // cache,
  //ws,
  //"org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0-RC1" % Test,
  "mysql" % "mysql-connector-java" % "5.1.34",
  "com.typesafe.play" %% "play-slick" % "2.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "2.0.0"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
