import jenkins.model.*
import org.jenkinsci.plugins.configfiles.maven.*
import org.jenkinsci.plugins.configfiles.maven.security.*


def configStore = Jenkins.instance.getExtensionList('org.jenkinsci.plugins.configfiles.GlobalConfigFiles')[0];

println("Setting maven settings xml");

def serverCreds = new ArrayList();
def testServer = [
  'serverId': 'test',
  'credentialId': 'defaultCredentials'
];
def serverCredentialMapping = new ServerCredentialMapping(testServer.serverId, testServer.credentialId);
serverCreds.add(serverCredentialMapping);

def testSettings = [
  'configId': 'default_settings',
  'configName': 'Default maven settings.xml',
  'configComment': 'Global Maven Settings',
  'configContent': '''<settings>
  <localRepository>/.m2/repository</localRepository>
</settings>''',
];
def configId =  'default_settings';
def configName = 'Default maven settings.xml';
def configComment = 'Global Maven Settings';
def configContent  = '''<settings>
<!-- your maven settings goes here -->
</settings>''';

def globalConfig = new GlobalMavenSettingsConfig(
  testSettings.configId,
  testSettings.configName,
  testSettings.configComment,
  testSettings.configContent,
  true,
  serverCreds
);
configStore.save(globalConfig);

println("maven settings complete");
