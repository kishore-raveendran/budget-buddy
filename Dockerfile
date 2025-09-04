FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/sms-forwarder.jar .
ENTRYPOINT ["java","-jar","sms-forwarder.jar"]
