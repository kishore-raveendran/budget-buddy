FROM eclipse-temurin:21-jdk-alpine as builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/sms-forwarder.jar sms-forwarder.jar
ENTRYPOINT ["java","-jar","sms-forwarder.jar"]
