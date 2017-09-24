package services

import cucumber.runtime.ScenarioImpl
import org.openqa.selenium.WebDriver

class GlobalVars {

    private static WebDriver browser
    private static ScenarioImpl scenario
    private static String env

    static public void setDriver(WebDriver d){
        browser = d
    }

    static public void setScenario(ScenarioImpl s){
        scenario = s
    }

    static public void setEnv(String e){
        env = e
    }

    static public WebDriver getDriver(){
        return browser
    }

    static public ScenarioImpl getScenario(){
        return scenario
    }

    static public String getEnv(){
        return env
    }

}