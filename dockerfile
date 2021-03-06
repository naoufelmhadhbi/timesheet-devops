FROM openjdk:8-jdk-alpine
EXPOSE 8082
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app1.jar
ENTRYPOINT ["java","-jar","/app1.jar"]


#ARG MAVEN_VERSION=3.8.4-openjdk-8-slim
#ARG OPENJDK_VERSION=8-jre-slim

##stage de build

#FROM maven:${MAVEN_VERSION} AS todo_build
## copier des sources pour pouvoir les compiler à l'intérieur de conteneur
#COPY ./src  /home/app/src

#COPY pom.xml /home/app

#RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=true

##stage run

#FROM openjdk:${OPENJDK_VERSION} AS todo_api

#COPY --from=todo_build /home/app/target/*.jar /usr/local/lib/app.jar

#EXPOSE 8082

#CMD ["java","-jar","/usr/local/lib/app.jar"]
