# Chapter 2: Getting Started with RSocket

## Core concepts of the RSocket.

## Setting up a basic RSocket application : Hello World.

## Build the project 

We recommend a workstation with the following configurations for working with the repository:

| № | Name   | Value                                                   |
|---|--------|---------------------------------------------------------|
| 1 | JDK    | openjdk 17 or above                                     |
| 2 | OS     | Linux, MacOS (11.8.3 and above), Windows Vista SP2 and above |
| 3 | Network | No restriction                                          |
| 4 | RAM    | Minimum 4GB of RAM                                      |
| 5 | CPU    | Minimum 2 core                                          |
| 5 | IDE    | Eclipse, IntelliJ Idea, NetBeans or JDeveloper          |
| 6 | Gradle | Gradle 7.8                                              |

Run the following command from the directory named **chapter-2**

```
./gradlew build 
```
or (at these moments its works;-) )

```
./gradlew responder:run 
```
Run the RSC client with the following command:

```
java -jar ./rsc-0.4.2.jar --debug --request --data "{\"origin\":\"Client\",\"interaction\":\"Request\"}" --route request-response tcp://localhost:7007 
```
Run the Java RSocket requester (client) with the following command:

```
java -jar ./requester/build/libs/requester.jar or ./gradlew requester:run 
```

Invoke the REST API through your favorite browser as shown below:

```
http://localhost:8080/request-response
```

## RSocket communication patterns by examples:
1. request/response;
2. fire-and-forget;
3. and streaming interactions.