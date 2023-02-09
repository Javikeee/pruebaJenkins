FROM openjdk:19

COPY target/tutorials-1.0.0.jar /tutorialsapp.jar

CMD ["java", "-jar", "/tutorialsapp.jar"]