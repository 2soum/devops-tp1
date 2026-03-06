FROM eclipse-temurin:17-jre
VOLUME /tmp
EXPOSE 8080
ADD ./build/libs/Hello-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
