FROM openjdk:17

WORKDIR /usrapp/bin

ENV PORT=8080

COPY /target/classes /usrapp/bin/target/classes
COPY /target/propertyManager-0.0.1-SNAPSHOT.jar app.jar

CMD ["java","-jar","app.jar"]