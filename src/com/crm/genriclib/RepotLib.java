package com.crm.genriclib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class RepotLib {
	public void Screenshots(String filename) throws IOException{
		EventFiringWebDriver edriver = new EventFiringWebDriver(Driver.driver);
	File img =	edriver.getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Workspace_selenium\\workspace\\Framework\\ScreenShot\\"+filename+".png");
		FileUtils.copyFile(img, file);
	}
}
