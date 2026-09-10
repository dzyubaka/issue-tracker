FROM eclipse-temurin:25
COPY build/libs/issue-tracker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
