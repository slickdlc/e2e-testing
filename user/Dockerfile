FROM openjdk:17
VOLUME /tmp
EXPOSE 8060
ARG JAR_FILE=user-boot/target/user-boot-0.1.0-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]