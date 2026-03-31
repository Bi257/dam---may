FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
# Copy file app.jar đã được đặt tên cố định từ bước build
COPY --from=build /target/app.jar app.jar
EXPOSE 8080
# Sử dụng shell form để biến ${PORT} của Render có thể truyền vào command
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]