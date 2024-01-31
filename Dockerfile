FROM openjdk:11-jre-slim
COPY target/transport-backend.jar transport-backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "transport-backend.jar"]
