FROM openjdk:11-slim as build
MAINTAINER thaisc98
# Add the application's jar to the container
COPY target/booking-0.0.1-SNAPSHOT.jar booking-0.0.1-SNAPSHOT.jar
#execute the application
ENTRYPOINT ["java","-jar","/booking-0.0.1-SNAPSHOT.jar"]