package com.crm.MarketingandsalesTest;



import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.BusinessLib.CommonLib;
import com.crm.BusinessLib.Constant;
import com.crm.BusinessLib.Contactlib;
import com.crm.genriclib.Driver;
import com.crm.genriclib.Execllib;
import com.crm.genriclib.RepotLib;
import com.crm.genriclib.webdrivercommonlib;

public class ContactTest {
	
	Execllib elib ;
	webdrivercommonlib wclib ;
	CommonLib clib ;
	Contactlib conttst; 
	Logger logger ;
	Driver driver;
	
	@BeforeClass
	public void cofigBfrClass() throws Exception{
		Driver.setup("firefox");
		elib = new Execllib();
		wclib = new webdrivercommonlib();
		conttst = new Contactlib();
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
	public void CreateContactTest() throws InvalidFormatException, IOException{
		String ContactName = elib.getExeclData("Sheet1",1,2);
		wclib.waitForPageToLoad();
		conttst.CreateContact(ContactName);
		logger.info("contact created");
		String actualResult = wclib.GetTextofWebElementusingxpath("//div[@class='row-fluid']/span[contains(text() ,'Qspider')]");
		String actualResult1 = wclib.GetTextofWebElementusingxpath("//h4[@class='recordLabel pushDown']//span[text()='Qspider']");
		Assert.assertEquals(ContactName, actualResult,"Cotact is not verfied");
		logger.info("contact verified");
		Assert.assertEquals(ContactName, actualResult1,"Cotact is not verfied");
		logger.info("contact verified");
	
		elib.setExcelData("Sheet1",1,5,"Pass");
	}
	
	@Test(priority=2)
	public void ModifyContactTest() throws InvalidFormatException, IOException{
		
		String Firstname = elib.getExeclData("Sheet1",2, 2);
		String LastName = elib.getExeclData("Sheet1",2, 3);
		conttst.ModifyContact(Firstname, LastName);
		elib.setExcelData("Sheet1",2,5,"Pass");
	}
	
	@Test(priority=3)
	public void DeleteContact() throws InvalidFormatException, IOException{
		String FristName = elib.getExeclData("Sheet1",3, 2);
		String LastName = elib.getExeclData("Sheet1",3, 3);
		logger.info("data getting from excel");
		conttst.DeleteContact(FristName, LastName);
		logger.info("contact deleted");
		elib.setExcelData("sheet1",3, 5,"Pass");
		
		
	}
	
	@Test(priority=4)
	public void DuplicateContact() throws InvalidFormatException, IOException{
		String ContactName = elib.getExeclData("Sheet1",4,2);
		conttst.DuplicateContact(ContactName);
		wclib.waitForElemnetXpathPresent("//table[@class='table table-bordered listViewEntriesTable']");
		logger.info("duplicate contact created");
		elib.setExcelData("sheet1",4, 5,"Pass");
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
	public void ConfigAftrClass(){
		Driver.driver.close();
		logger.info("firefox closed");
	}
		
	}

