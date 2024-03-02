FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=web-service/target/spring-module-arch.jar
ADD ${JAR_FILE} spring-module-arch.jar
ENTRYPOINT ["java","-jar","/spring-module-arch.jar"]