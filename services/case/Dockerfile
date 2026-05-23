FROM eclipse-temurin:25-jdk
LABEL authors="JPedro"

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew clean build -x test

EXPOSE 8084

ENTRYPOINT ["java","-jar","build/libs/case-0.0.1-SNAPSHOT.jar"]