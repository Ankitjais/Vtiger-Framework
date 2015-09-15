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








import com.crm.BusinessLib.Campaignslib;
import com.crm.BusinessLib.CommonLib;
import com.crm.BusinessLib.Constant;
import com.crm.genriclib.Driver;
import com.crm.genriclib.Execllib;
import com.crm.genriclib.RepotLib;
import com.crm.genriclib.webdrivercommonlib;



public class CompaignsTest {
	Execllib elib = new Execllib();
	webdrivercommonlib wclib;
	CommonLib clib;
	Campaignslib camtst;
	Logger logger;
	
	
	@BeforeClass
	public void cofig() throws Exception{
		
		Driver.setup("firefox");
		 elib = new Execllib();
		 wclib = new webdrivercommonlib();
		 clib = new CommonLib();
		camtst = new Campaignslib();
		logger = Logger.getLogger("CampaignModuleTest");
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
	public void CreateCampaign() throws InvalidFormatException, IOException{
		String productName =elib.getExeclData("Sheet1",5,2);
		String campaignName =elib.getExeclData("Sheet1",5,3);
		String price =elib.getExeclData("Sheet1",5,4);
		wclib.waitForPageToLoad();
		logger.info("getting compaign test data");
		camtst.CreateCampaigns(productName, campaignName ,price);
		logger.info("campaign created");
		elib.setExcelData("sheet1",5,5,"Pass");
	}
	
	@Test(priority=2)
	public void ModifyCampaigns() throws InvalidFormatException, IOException{
		String productName =elib.getExeclData("Sheet1",6,2);
		String campaignName =elib.getExeclData("Sheet1",6,3);
		String price =elib.getExeclData("Sheet1",6,4);
		logger.info("getting compaign test data");
		wclib.waitForPageToLoad();
		camtst.ModifyCampaigns(productName, campaignName, price);
		logger.info("campaign Modify");
		elib.setExcelData("sheet1",6,5,"Pass");
	}
	@Test(priority=3)
	public void DeleteCampaigns() throws InvalidFormatException, IOException{
		String productName =elib.getExeclData("Sheet1",7,2);
		String campaignName =elib.getExeclData("Sheet1",7,3);
		String price =elib.getExeclData("Sheet1",7,4);
		logger.info("getting compaign test data");
		wclib.waitForPageToLoad();
		camtst.deleteCampaigns(productName, campaignName, price);
		logger.info("campaign Deleted");
		elib.setExcelData("sheet1",7,5,"Pass");
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
