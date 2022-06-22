package config

import groovy.json.JsonSlurper
import org.junit.Assert
import support.Environment

class Configuration {
    static final String configFile = "src/test/groovy/config/config.json";

    static boolean loadEnvironments() {
        def jsonFile = new File(configFile)
        def parsedJson = new JsonSlurper().parseText(jsonFile.text)
        if (parsedJson != null){
            String newDefaultEnv = parsedJson.defaultEnvironment
            Environment.setDefaultEnv(newDefaultEnv)
            ArrayList<String> environments = parsedJson.environments
            Environment.setEnvs(environments)
            return true
        }
        else {
            return false
        }
    }

    static void loadAllConfigs() {
        Assert.assertTrue("Failed to load environments values from file.", loadEnvironments());
    }

    static void main(String[] args) {
        loadAllConfigs()
        println Environment.availableEnvironments
        println Environment.defaultEnv
    }

}
