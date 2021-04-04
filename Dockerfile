FROM openjdk:11-jdk-slim
WORKDIR /app
COPY target/test.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]