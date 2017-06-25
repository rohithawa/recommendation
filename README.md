#Introduction
IN-FLIGHT MOVIE RECOMMENDATION (0.5-1 hour)

Build an in-flight entertainment system with on-demand movie streaming.
Users on longer flights like to start another movie right when their previous one ends, but they complain that the plane usually lands before they can see the ending.
So you're building a feature for choosing two movies whose total runtimes will equal the exact flight length.

Write a program that suggests movies for a flight.
The movie list can be a hardcoded array of movies (or loaded from a database)

Remember:
Threat all durations in minutes
Don't make your users watch the same movie twice
Make sure the movies suggested are as close as possible to the flight length, but never longer
Prioritize longer movies over shorter ones (longer movies are always better right)
Don't worry about genres

Examples:
Flight duration 92 min: The Shallows (87 min)
Flight duration 325 min: Suicide Squad (130 min) Jason Bourne (123 min) Batman: The Killing Joke (72 min)

Note:
JSON List of movies is provided


#CHECK BRACKETS
Package - au.com.recommendation

#Tools and Technologies
- java 8
- Maven
- junit
- jackson
- cobertura

#How to build the application
```
mvn clean install
```

#How to run the cobertura code coverage
```
mvn cobertura:cobertura
```

#How to view the cobertura report

Go to target/cobertura/index.html

#How to run the application
```
java -jar  target/recommendation-app.jar
```