FROM openjdk:11
EXPOSE 9098
WORKDIR /myapp
COPY /target/Student-0.0.1-SNAPSHOT.jar /myapp/Student-0.0.1-SNAPSHOT.jar
#ADD /target/bhar20293715img.jar bhar20293715img.jar
ENTRYPOINT ["java", "-jar", "Student-0.0.1-SNAPSHOT.jar"]
