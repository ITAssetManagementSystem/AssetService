# =========================
# Stage 1: Build
# =========================
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /build

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests


# =========================
# Stage 2: Runtime
# =========================
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Run as non-root (production safe)
RUN useradd -m appuser
USER appuser

COPY --from=builder /build/target/asset-service-1.0.0.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","app.jar"]
