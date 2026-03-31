# Stage 1: Build ứng dụng
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Chạy ứng dụng
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
# Copy file app.jar từ Stage build sang Stage chạy
COPY --from=build /app/target/app.jar app.jar
EXPOSE 8080
# Nhận biến môi trường PORT từ Render để tránh lỗi "No open ports detected"
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]