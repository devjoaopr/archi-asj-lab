FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew build -x test

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "build/libs/notification-api-0.0.1-SNAPSHOT.jar"]