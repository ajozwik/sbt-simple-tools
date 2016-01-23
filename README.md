# sbt-simple-tools

Simple sbt project to demonstrate how to create and pack simple sbt project with [sbt-pack plugin](https://github.com/xerial/sbt-pack).

For code formatting [sbt-scalariform](https://github.com/sbt/sbt-scalariform) is used.

For code quality run:

```
sbt scalastyle
sbt scapegoat
```

For continuum restart [sbt-revolver](https://github.com/spray/sbt-revolver)

Run
```
sbt ~reStart
```
When you change the code - the application will be restarted immediately.