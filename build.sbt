name := """vp-io-test"""

version := "1.0.0"

scalaVersion := "2.11.11"

scalacOptions := Seq(
  "-Ypartial-unification"
)

libraryDependencies ++= Seq(
  "org.apache.spark"            %% "spark-core"                  % "2.2.0" % "provided",
  "org.apache.spark"            %% "spark-hive"                  % "2.2.0" % "provided",
  "org.locationtech.geotrellis" %% "geotrellis-spark"            % "1.2.0-SNAPSHOT",
  "org.locationtech.geotrellis" %% "geotrellis-s3"               % "1.2.0-SNAPSHOT",
  "org.locationtech.geotrellis" %% "geotrellis-vector"           % "1.2.0-SNAPSHOT",
  "org.locationtech.geotrellis" %% "geotrellis-vectortile"       % "1.2.0-SNAPSHOT",
  "com.azavea"                  %% "vectorpipe"                  % "1.0.0",
  "org.apache.hadoop"           %  "hadoop-aws"                  % "2.8.1",
  "org.typelevel"               %% "cats"                        % "0.9.0"
)

/* Allow `run` to be used with Spark code, while assembling fat JARs w/o Spark bundled */
run in Compile := Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run)).evaluated
runMain in Compile := Defaults.runMainTask(fullClasspath in Compile, runner in(Compile, run)).evaluated
