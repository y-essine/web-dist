FROM openjdk:8
EXPOSE 8088
ADD target/reservation-docker.jar reservation-docker.jar
ENTRYPOINT ["java","-jar","reservation-docker.jar"]