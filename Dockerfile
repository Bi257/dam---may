# Stage 1: Build ứng dụng (Đặt tên là build)
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Chạy ứng dụng
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app

# Copy file .jar từ stage build vào thư mục /app hiện tại
COPY --from=build /app/target/app.jar app.jar

# Mở port 8080 (hoặc port do Render cấp)
EXPOSE 8080

# Chạy ứng dụng bằng Shell form để nhận biến môi trường PORT từ Render
ENTRYPOINT java -Dserver.port=${PORT:-8080} -jar app.jar