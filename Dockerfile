# Stage 1: Build the JAR
FROM maven:3.9.9-amazoncorretto-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the JAR
FROM amazoncorretto:17
WORKDIR /app
COPY --from=builder /app/target/java-fact-emailer-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]