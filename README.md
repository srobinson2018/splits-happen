_This project is based on [splits-happen](https://github.com/VarenTech/splits-happen)._

#Summary

This Java project scores a bowling game given a String representing the result of each roll. In addition to providing the final score, the frame score is also displayed.

#Usage
To use this application, build using:

`mvn clean package`

Once built, navigate to the jar in the target directory and run with any number of game scores using:

` java -jar splits-happen-1.0-SNAPSHOT.jar {gameScore1} {gameScore2} ...`

#Testing

Tests are included which test the provided cases plus a few additional cases. The following scenarios are tests:

* `"XXXXXXXXXXXX"` (Result: 300)
* `"9-9-9-9-9-9-9-9-9-9-"` (Result: 90)
* `"5/5/5/5/5/5/5/5/5/5/5"` (Result: 150)
* `"X7/9-X-88/-6XXX81"` (Result: 167)
* `"--------------------"` (Result: 0)
* `"------------------X--"` (Result: 10)


To run the application's tests use:

`mvn clean test`

#Notes

* I added this project to GitHub after completion as I did not know the preferred method of delivery. So I unfortunately do not have a solid history of commits to show my progress.
* I chose Java for this project mainly because it is the most popular programming language, but could have produced a project in Kotlin, Scala, Go, or Python.
* For the purpose of following the projects specifications, this application always assumes a full set of rolls. If this were a "live" bowling match, minor changes would be required to produce live, roll-by-roll scores.