# ============================================================
# Stage 1 – BUILD
# ============================================================
FROM eclipse-temurin:25-jdk-noble AS builder

WORKDIR /app

# Copy dependency descriptors first (layer cache)
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline -q

# Copy source and build
COPY src/ src/
RUN ./mvnw package -DskipTests -q

# Extract layers for Spring Boot layered JAR
RUN java -Djarmode=layertools -jar target/*.jar extract --destination /app/extracted


# ============================================================
# Stage 2 – RUNTIME (JRE only, much smaller)
# ============================================================
FROM eclipse-temurin:25-jre-noble AS runtime

# Non-root user for security
RUN groupadd --system spring && useradd --system --gid spring spring

WORKDIR /app

# Copy layered content in cache-friendliness order
# (least → most frequently changed)
COPY --from=builder --chown=spring:spring /app/extracted/dependencies/           ./
COPY --from=builder --chown=spring:spring /app/extracted/spring-boot-loader/     ./
COPY --from=builder --chown=spring:spring /app/extracted/snapshot-dependencies/  ./
COPY --from=builder --chown=spring:spring /app/extracted/application/            ./

USER spring

EXPOSE 8080

# Health check – hits Spring Boot Actuator /actuator/health
HEALTHCHECK \
  --interval=30s \
  --timeout=5s \
  --start-period=60s \
  --retries=3 \
  CMD wget --no-verbose --tries=1 --spider \
      http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java", \
  "-XX:+UseContainerSupport", \
  "-XX:MaxRAMPercentage=75.0", \
  "org.springframework.boot.loader.launch.JarLauncher"]