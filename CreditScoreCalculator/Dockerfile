FROM openjdk:15
EXPOSE 8080
ADD target/*.jar application.jar
ENTRYPOINT ["java","-jar","/application.jar"]