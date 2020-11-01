#source image: create a docker image on the base of a openjdk:11-jre-slim-buster image:
FROM openjdk:11-jre-slim-buster
#app package: define the variable JAR_FILE and copy the file it points to the app.jar path in the container:
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
#launch command: indicate the command to be called at the start of the application:
ENTRYPOINT ["java","-jar","/app.jar"]
#exposed port:
EXPOSE 8080

#To build the docker image and to tag it as "marzenakaa:myapp", run the command:
# > docker build --build-arg JAR_FILE=build/libs/*.jar -t marzenakaa:myapp .
# where:
# "swaggerCodegen-0.0.1-SNAPSHOT.jar" - jar file
# "marzenakaa:myapp" - a tag, under which the application is to be built
# "." - source catalog from which the package is to be built (here: it's the actual catalog)

#To run the app:
# > docker run -P marzenakaa:myapp - automatic publication of all ports (documented by the EXPOSE command). In this case the application will run on a random port, which can be viewed with the command docker ps.
# or > docker run -p 9090:8080 marzenakaa:myapp - specification of needed ports and their mapping to our system. In this case the application will run on localhost:9090.