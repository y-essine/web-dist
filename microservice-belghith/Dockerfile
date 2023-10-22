FROM openjdk:8
EXPOSE 8484
ADD target/review-docker.jar review-docker.jar
ENTRYPOINT ["java","-jar","review-docker.jar"]