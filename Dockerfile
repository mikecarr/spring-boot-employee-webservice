FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="mcarr67@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Date/Time is set to UTC
RUN apk add --no-cache tzdata

ENV TZ=America/Los_Angeles

# The application's jar file
ARG JAR_FILE=target/spring-boot-webservice-1.0-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} spring-boot-webservice.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot-webservice.jar"]
