# record + lombok + groovy == compilation error

Simple reproducer.

Call: `./mvnw test-compile` with JDK 17 to get:

```
[ERROR] Failed to execute goal org.codehaus.gmavenplus:gmavenplus-plugin:1.13.1:compileTests (default) on project record-lombok-groovy: Error occurred while calling a method on a Groovy class from classpath.: InvocationTargetException: startup failed:
[ERROR] .../record-lombok-groovy/src/test/groovy/info/solidsoft/reproducer/groovy/recordlombokgroovy/ReproducerClass.groovy: -1: Cannot specify duplicate annotation on the same member : lombok.NonNull
[ERROR]  @ line -1, column -1.
```
