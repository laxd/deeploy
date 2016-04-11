FROM java:8

ADD build/libs/deploy-web.jar deploy.jar

ENTRYPOINT ["java", "-jar", "/deploy.jar"]
