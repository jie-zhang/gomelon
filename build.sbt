name := "gomelon"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)     

libraryDependencies += "org.mongodb" %% "casbah" % "2.6.3"

libraryDependencies +="com.novus" %% "salat" % "1.9.5"

play.Project.playScalaSettings

routesImport += "se.radley.plugin.salat.Binders._"

templatesImport += "org.bson.types.ObjectId"

