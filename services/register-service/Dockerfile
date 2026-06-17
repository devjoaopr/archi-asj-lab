FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew
RUN ./gradlew clean build -x test --no-daemon

EXPOSE 8089

ENTRYPOINT ["java", "-jar", "build/libs/register-0.0.1-SNAPSHOT.jar"]