lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.fpineda.katas",
      scalaVersion := "2.13.3"
    )),
    name := "scalatest-example"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test
