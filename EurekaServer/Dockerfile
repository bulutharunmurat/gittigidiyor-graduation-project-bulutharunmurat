FROM openjdk:11
EXPOSE 8761
ADD EurekaServer/target/*.jar eurekaserver.jar
ENTRYPOINT ["java","-jar","/eurekaserver.jar"]