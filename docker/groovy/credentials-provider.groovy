import jenkins.model.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*

println("Setting credentials")

def defaultUser = new File("/run/secrets/test-user").text.trim();
def defaultPassword = new File("/run/secrets/test-pass").text.trim();
def credentials = [
  'username':defaultUser,
  'password':defaultPassword,
  'description':'Default Credentials'
];

def domain = Domain.global();
def user = new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL, 'defaultCredentials', credentials.description, credentials.username, credentials.password);

def store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore();
store.addCredentials(domain, user);
