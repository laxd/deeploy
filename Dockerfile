FROM tomcat

RUN rm -rf /usr/local/tomcat/webapps/*
ADD deploy-web/target/deploy-web.war /usr/local/tomcat/webapps/ROOT.war


