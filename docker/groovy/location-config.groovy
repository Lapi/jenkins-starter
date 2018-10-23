import jenkins.model.JenkinsLocationConfiguration

def host = System.getenv("JENKINS_HOST");
jlc = JenkinsLocationConfiguration.get();
jlc.setUrl('http://'+ host);
println('Set URL: '+jlc.getUrl());
