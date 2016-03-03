FROM tomcat:8-jre8

# Remove default wars
RUN rm -rf $CATALINA_HOME/webapps/*

# Add classpath
RUN echo "CLASSPATH=$CATALINA_HOME/libs" >> $CATALINA_HOME/bin/setenv.sh

# Copy dependencies
COPY deploy-web/target/deploy-web/WEB-INF/lib/* $CATALINA_HOME/libs/

# Add war file as base war
ADD deploy-web/target/deploy-web.war $CATALINA_HOME/webapps/ROOT.war
