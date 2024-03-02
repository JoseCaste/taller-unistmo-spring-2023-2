FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=web-service/target/spring-module-arch.jar
COPY ${JAR_FILE} /app/spring-module-arch.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/spring-module-arch.jar"]