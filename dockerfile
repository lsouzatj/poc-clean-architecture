FROM openjdk:19-jdk
WORKDIR /app
COPY ./target/clean-0.0.1-SNAPSHOT.jar app.jar
COPY . .
EXPOSE 8020
ENTRYPOINT java -jar app.jar