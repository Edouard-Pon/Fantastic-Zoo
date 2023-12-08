# Fantastic Zoo Simulator

## Introduction

This is a University project created for educational purposes. The goal of this project is to create a simple zoo simulator with JavaFX.

## Requirements
- Maven
- Java 21
- JavaFX 21

## How to run
```bash
mvn clean javafx:run
```

## In case of problems
If you have any problems with running this project because of Java version, you can change it in pom.xml file. Just change the version of JavaFX plugin and Java version in properties.  

We tested this project on Java 21 and everything worked fine.

We tested this project on Java 20, and we had to make this changes to make it work:
- In Enclosure.java file we had to comment line 57 and uncomment line 58, ``.getFirst()`` is not available in Java < 21
- In case of problems with Tests, you can run the project using this command: ``mvn -DskipTests=true javafx:run``
