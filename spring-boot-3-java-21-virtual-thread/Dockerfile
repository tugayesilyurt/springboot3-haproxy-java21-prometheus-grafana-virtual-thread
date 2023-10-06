
# For Java 21,
FROM openjdk:21-jdk
COPY target/spring-boot-3-java-21-virtual-thread-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","--enable-preview", "-jar", "app.jar"]