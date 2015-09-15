package com.crm.MarketingandsalesTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.BusinessLib.CommonLib;
import com.crm.BusinessLib.Constant;
import com.crm.BusinessLib.Organizationlib;
import com.crm.genriclib.Driver;
import com.crm.genriclib.Execllib;
import com.crm.genriclib.RepotLib;
import com.crm.genriclib.webdrivercommonlib;
import com.crm.pageobjectRepository.OrganizationPageObjRepo;

public class OrganizationTest {
	Execllib elib ;
	webdrivercommonlib wclib ;
	CommonLib clib ;
	Organizationlib org; 
	Logger logger ;
	Driver driver;
	OrganizationPageObjRepo orgrepo;
	
	@BeforeClass
	public void cofigBfrClass() throws Exception{
		Driver.setup("firefox");
		elib = new Execllib();
		wclib = new webdrivercommonlib();
		org = new Organizationlib();
		clib = new CommonLib();
		orgrepo =PageFactory.initElements(Driver.driver,OrganizationPageObjRepo.class);
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
	
	/*@Test(priority=1)
	public void CreateOrganizationTest() throws InvalidFormatException, IOException{
		String orgName = elib.getExeclData("Sheet1",12,2);
		wclib.waitForPageToLoad();
		org.CreateOrganization(orgName);
		logger.info("Organization Created Successfully");
		String ActualOrgname = orgrepo.getOrgNameinfo().getText();
		Boolean Status = wclib.VerifyText(ActualOrgname,orgName);
		Assert.assertTrue(Status);
		String ActualOrginfo = orgrepo.getOrgInfo().getText();
		Boolean Status1 = wclib.VerifyText(ActualOrginfo,orgName);
		Assert.assertTrue(Status1);
		elib.setExcelData("Sheet1",12,5,"Pass");
	}
	
	@Test(priority=2)
	public void ModifyOrganizationTest() throws InvalidFormatException, IOException{
		String orgName = elib.getExeclData("Sheet1",13,2);
		wclib.waitForPageToLoad();
		org.ModifyOrganization(orgName);
		logger.info("Organization Modified successfully");
		String ActualOrgName =orgrepo.getOrgInfo().getText();
		String [] orgname = orgName.split(";");
		Boolean Status = wclib.VerifyText(ActualOrgName, orgname[1]);
		Assert.assertTrue(Status);
		logger.info("Organization Text is verified");
		elib.setExcelData("sheet1",13,5,"Pass");
	}*/
	
	@Test(priority=3)
	public void AddOrganizationDocumentTest() throws InvalidFormatException, IOException, InterruptedException{
		String orgName = elib.getExeclData("Sheet1",14,2);
		String DocumentName = elib.getExeclData("Sheet1",14,3);
		wclib.waitForPageToLoad();
		org.AddOrganizationDocument(orgName, DocumentName);
		logger.info("Document Attached Successfully");
		elib.setExcelData("Sheet1",14,5,"Pass");
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
