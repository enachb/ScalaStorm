name := "scala-storm"

version := "0.2.1"

// If you comment this out, SBT 0.10 will default to Scala 2.8.1
scalaVersion := "2.9.1"

// sbt defaults to <project>/src/test/{scala,java} unless we put this in
unmanagedSourceDirectories in Test <<= Seq( baseDirectory( _ / "test" ) ).join

unmanagedSourceDirectories in Compile <<= Seq( baseDirectory( _ / "examples" ),
                                               baseDirectory( _ / "dsl")).join

resolvers ++= Seq("clojars" at "http://clojars.org/repo/",
                  "clojure-releases" at "http://build.clojure.org/releases")

libraryDependencies ++= Seq("storm" % "storm" % "0.6.0"
)

publishMavenStyle := true

publishTo := Some("Qf Ext Snapshots" at "http://repo.quantifind.com/content/repositories/ext-releases/")

publishArtifact in packageDoc := false

//defaultMavenRepository := "http://repo.quantifind.com/content/repositories/ext-snapshots/"

// This is to prevent error [java.lang.OutOfMemoryError: PermGen space]
javaOptions += "-XX:MaxPermSize=1024m"

javaOptions += "-Xmx2048m"

// When doing sbt run, fork a separate process.  This is apparently needed by storm.
fork := true

// set Ivy logging to be at the highest level - for debugging
ivyLoggingLevel := UpdateLogging.Full

// Aagin this may be useful for debugging
logLevel := Level.Info

