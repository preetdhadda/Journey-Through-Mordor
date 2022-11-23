# Building the game 
Navigate to the root directory (with the pom.xml file) and type in the terminal:
<br>
```
mvn package
```
<br>

# Running the game
Type in the terminal: 
<br>
```
java -cp target/Phase-2-1.0.jar com.group21.app.Main
```
<br>

# Testing the game
Navigate to the root directory (with the pom.xml file) and type in the terminal:
<br>
```
mvn clean
mvn compile
mvn test
```

<br>

# Line Coverage
To check the line coverage, type in the terminal:
```
mvn package
```

Navigate to target->site->jacoco and open the index.html file





