FROM maven:latest as build_backend
ENV LANG C.UTF-8
WORKDIR /app
COPY pom.xml /app/pom.xml
COPY src /app/src
COPY mvnw /app/mvnw
COPY mvnw.cmd /app/mvnw.cmd
RUN mvn clean package

# APP
FROM alpine

RUN apk add openjdk11
ENV JAVA_HOME="/usr/lib/jvm/java-11-openjdk/"
ENV PATH=$PATH:${JAVA_HOME}/bin
#Add Project Folder
ENV APP_PORT=8081
COPY --from=build_backend /app/target/roulette_casino-0.0.1-SNAPSHOT.jar /tmp/roulette/app.jar

EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-Xmx3000m","-jar","/tmp/roulette/app.jar"]