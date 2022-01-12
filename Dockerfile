FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} echo.jar
ENTRYPOINT ["java", "-jar", "echo.jar"]