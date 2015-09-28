FROM tomcat

# Remove default wars
RUN rm -rf $CATALINA_HOME/webapps/*

# Add setenv.sh to set up classpath
COPY setenv.sh $CATALINA_HOME/bin/

# Copy dependencies
COPY deploy-web/target/deploy-web/WEB-INF/lib/* $CATALINA_HOME/libs/

ADD deploy-web/target/deploy-web.war $CATALINA_HOME/webapps/ROOT.war
