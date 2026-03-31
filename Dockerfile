# Stage 2: Chạy ứng dụng
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app

# Copy file từ stage build sang thư mục hiện tại (/app)
COPY --from=build /app/target/app.jar app.jar

EXPOSE 8080

# SỬA DÒNG NÀY: Bỏ chữ "target/" đi vì file hiện đã nằm ngay tại /app/app.jar
ENTRYPOINT java -Dserver.port=${PORT:-8080} -jar app.jar