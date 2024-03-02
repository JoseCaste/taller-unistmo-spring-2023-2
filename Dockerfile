FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY web-service/target/spring-module-arch.jar spring-module-arch.jar
ENTRYPOINT ["java","-jar","/spring-module-arch.jar"]