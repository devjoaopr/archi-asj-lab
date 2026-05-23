FROM eclipse-temurin:25-jdk
LABEL authors="JPedro"

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew clean build -x test

EXPOSE  8083

ENTRYPOINT ["java","-jar","build/libs/customer-0.0.1-SNAPSHOT.jar"]