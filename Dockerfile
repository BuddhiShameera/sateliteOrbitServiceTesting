FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} satelite.jar
ENTRYPOINT ["java","-jar","/satelite.jar"]