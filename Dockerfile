FROM java:8

ADD deploy-web/build/libs/deploy-web.jar deploy.jar

ENTRYPOINT ["java", "-jar", "/deploy.jar"]
