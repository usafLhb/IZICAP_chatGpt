FROM maven:3.8.3-openjdk-17 AS build
RUN mkdir -p /ws
WORKDIR /ws
COPY pom.xml /ws
COPY src /ws/src
RUN mvn -f pom.xml -Dmaven.test.skip  clean package

FROM openjdk:17
COPY --from=build /ws/target/*.jar izicap.jar
#ADD target/*.jar app.jar
EXPOSE 8080
VOLUME /chatgpt/data
ENTRYPOINT ["java","-jar","izicap.jar"]










