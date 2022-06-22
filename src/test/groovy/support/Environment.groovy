package support

class Environment {
    private static String defaultEnv
    private static String selectedEnv = null
    private static ArrayList<String> availableEnvironments

    static void setEnvs(ArrayList<String> newEnvs) {
        availableEnvironments = newEnvs
    }

    static void setDefaultEnv(String newDefaultEnv) {
        defaultEnv = newDefaultEnv
    }

    static String getEnvironment() {
        if (selectedEnv == null) {
            String consoleEnv = System.getProperty("env")
            if (consoleEnv == null) {
                println "Environment not sent. Going to use default: ${defaultEnv}"
                selectedEnv = defaultEnv
            } else if (!envIsAvailable(consoleEnv)) {
                println "Environment sent in parameter is not available. Sent: ${consoleEnv}"
                println "Going to use default: ${defaultEnv}"
                selectedEnv = defaultEnv
            } else {
                println "Selected env: ${consoleEnv}"
                selectedEnv = consoleEnv
            }
        }
        return selectedEnv
    }

    static String getDefaultEnv(){
        return defaultEnv
    }

    static ArrayList<String> getAvailableEnvironments(){
        return availableEnvironments
    }

    static boolean envIsAvailable(String desireEnv) {
        return availableEnvironments.contains(desireEnv);
    }

}

