package com.crm.MarketingandsalesTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;









import com.crm.BusinessLib.CommonLib;
import com.crm.BusinessLib.Constant;
import com.crm.BusinessLib.Leadlib;
import com.crm.genriclib.Driver;
import com.crm.genriclib.Execllib;
import com.crm.genriclib.RepotLib;
import com.crm.genriclib.webdrivercommonlib;


public class LeadTest {

	Execllib elib ;
	webdrivercommonlib wclib ;
	CommonLib clib;
	Logger logger;
	
	@BeforeClass
	public void cofig() throws Exception{
		Driver.setup("firefox");
		 elib = new Execllib();
		 wclib = new webdrivercommonlib();
		 clib = new CommonLib();
		logger = Logger.getLogger("ContactModuleTest");
		PropertyConfigurator.configure("log4j.properties");
		Driver.driver.get(Constant.Url);
		logger.info("firefox lunched");
		Driver.driver.manage().window().maximize();
	}
	
	
	@BeforeMethod
	public void Login() throws InvalidFormatException, IOException{
		logger.info("getting username and passward");
		clib.LogIn(Constant.username, Constant.passward);
		logger.info("login successfully");
	}
	@Test(priority=1)
	public void Createlead() throws InvalidFormatException, IOException{
		String LeadLastname = elib.getExeclData("Sheet1",8,2);
		logger.info("geeting create lead data from excel");
		wclib.waitForPageToLoad();
		new Leadlib().CreateLead(LeadLastname);
		logger.info("lead created");
		
		logger.info("lead created screenshots");
		elib.setExcelData("sheet1",8,5,"Pass");
		
	}
	@Test(priority=2)
	public void ModifyLead() throws InvalidFormatException, IOException{
		String LeadFirstname = elib.getExeclData("Sheet1",9,2);
		String LeadLastname = elib.getExeclData("Sheet1",9,3);
		logger.info("geeting create lead data from excel");
		wclib.waitForPageToLoad();
		new Leadlib().ModifyLead(LeadFirstname, LeadLastname);
		logger.info("Lead Modified");
		logger.info("Modify lead screenshot");
		elib.setExcelData("sheet1",9,5,"Pass");
	}
	@Test(priority=3)
	public void DeleteLead() throws InvalidFormatException, IOException{
		String LeadFirstname = elib.getExeclData("Sheet1",10,2);
		String LeadLastname = elib.getExeclData("Sheet1",10,3);
		logger.info("geeting delete lead data from excel");
		new Leadlib().DeleteLead(LeadFirstname, LeadLastname);
		logger.info("Lead Modified");
	
		logger.info("Delete lead screenshot");
		elib.setExcelData("sheet1",10,5,"Pass");
	}
	@Test(priority=4)
	public void DuplicateLead() throws InvalidFormatException, IOException{
		String LeadLastName = elib.getExeclData("Sheet1",11,2);
		logger.info("geeting create lead data from excel");
		new Leadlib().DuplicateLead(LeadLastName);
		logger.info("Lead Modified");
		
		logger.info("Modify lead screenshot");
		elib.setExcelData("sheet1",11,5,"Pass");
	}
	@AfterMethod
	public void logout(ITestResult t) throws IOException{
if(t.isSuccess()){
			
		}
		else{
			new RepotLib().Screenshots(t.getMethod().getMethodName());
		}
		clib.LogOut();
		wclib.waitForPageToLoad();
		logger.info("logout successfully");
	}
	
	@AfterClass
	public void Config(){
		Driver.driver.close();
		logger.info("firefox closed");
	}
}
