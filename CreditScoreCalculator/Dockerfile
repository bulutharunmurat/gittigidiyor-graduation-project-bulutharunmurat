FROM openjdk:11
EXPOSE 8080
ADD CreditScoreCalculator/target/*.jar creditscorecalculator.jar
ENTRYPOINT ["java","-jar","/creditscorecalculator.jar"]