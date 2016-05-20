FROM java:8

ADD build/libs/deploy-api.jar deploy.jar

ENTRYPOINT ["java", "-jar", "/deploy.jar"]
