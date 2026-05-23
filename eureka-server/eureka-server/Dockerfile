FROM eclipse-temurin:25-jdk
LABEL authors="JPedro"

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew clean build -x test

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "build/libs/eureka-server-0.0.1-SNAPSHOT.jar"]