FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY services/shared-events/ /shared-events/
COPY services/customer/ .

RUN chmod +x gradlew
RUN ./gradlew clean build -x test --no-daemon

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "build/libs/customer-0.0.1-SNAPSHOT.jar"]