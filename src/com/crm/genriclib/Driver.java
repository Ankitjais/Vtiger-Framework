package com.crm.genriclib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
	public static WebDriver driver ;
	
    public static void setup(String browser) throws Exception{
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("firefox")){
        //create firefox instance
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver","D:\\webdriverSoftware\\chromedriver_win32\\chromedriver.exe");
            //create chrome instance
            driver = new ChromeDriver();
        }
            else if(browser.equalsIgnoreCase("IE driver")){
            	System.setProperty("webdriver.ie.driver","D:\\webdriverSoftware\\IEDriverServer_Win32_2.45.0\\IEDriverServer.exe");
            	driver = new InternetExplorerDriver();
            
        }else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
	}

}
