FROM openjdk:11
EXPOSE 8888
WORKDIR /myapp
COPY /target/configserver-0.0.1-SNAPSHOT.jar /myapp/configserver-0.0.1-SNAPSHOT.jar
#ADD /target/bhar20293715img.jar bhar20293715img.jar
ENTRYPOINT ["java", "-jar", "configserver-0.0.1-SNAPSHOT.jar"]
