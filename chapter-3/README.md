# Chapter 3: RSocket in Microservices Architecture

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

## download and build the Alibaba Rsocket broker from the github repository https://github.com/alibaba/alibaba-rsocket-broker 

After building the project, run the following command from the root directory

```
java -jar alibaba-broker-server/target/alibaba-rsocket-broker.jar
 
```
Alibaba broker dashboard will be available by the next URL http://localhost:9998

Now, use the curl or web browser https://jwt.alibroker.info to get the corresponding JWT token, and then set it as rsocket.jwt-token attribute value in the **application.properties** file.

Build the **chapter-3** project as follows: 

```
./gradlew build 
```

Deploy the broker responder by the following command:

```
java -jar broker-responder/build/libs/broker-responder-0.0.1-SNAPSHOT.jar 
```
controller will be available at http://localhost:8181/

You can test the responder service through Alibaba Broker Dashboad. Click the menu Service Testing, complete the following fields:
1. Service name : com.blu.rsocket.MessageService
2. Method name: getMessage
and click the **invoke** button.

Deploy the Requester service as follows:

```
java -jar broker-requester/build/libs/broker-requester-0.0.1-SNAPSHOT.jar
```

Invoke the REST API through your favorite browser as shown below:

```
http://localhost:8182/getMessage
```
## Loadbalancing
1) First start one Responder by the following command : ``` java -jar broker-responder/build/libs/broker-responder-0.0.1-SNAPSHOT.jar ```
2) Change the port rsocket port and the http server port on file /broker-responder/src/main/resources/application.properties as follows:
rsocket.port=42254
server.port=8184
3) rebuild the project with command ```./gradlew build```
4) Start an another instance of the Responder by the following command : ``` java -jar broker-responder/build/libs/broker-responder-0.0.1-SNAPSHOT.jar ```

If everything goes fine, you should have one more RsocketBrokerResponder registered on RSocket broker. 

Now, invoke the REST API through your favorite browser as you did before: 

```
http://localhost:8182/getMessage
```
RSocket broker will round-robin the requestes between two responders. Check the log on console for getting confirm. 