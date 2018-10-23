FROM jenkinsci/blueocean
LABEL author="mvlasaty23"

# fixing permissions for docker
USER root
RUN adduser jenkins docker

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false -Djenkins.CLI.disabled=true"
ENV JENKINS_HOST="localhost:8080/"

# adding scripts
COPY groovy/* /usr/share/jenkins/ref/init.groovy.d/

# automatically installing all plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

EXPOSE 8080 50000
