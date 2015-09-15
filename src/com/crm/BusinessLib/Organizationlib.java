package com.crm.BusinessLib;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.crm.genriclib.Driver;
import com.crm.genriclib.webdrivercommonlib;
import com.crm.pageobjectRepository.Home;
import com.crm.pageobjectRepository.OrganizationPageObjRepo;
import com.crm.pageobjectRepository.commonpageobjrepo;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class Organizationlib extends webdrivercommonlib {
	OrganizationPageObjRepo org = PageFactory.initElements(Driver.driver, OrganizationPageObjRepo.class);
	commonpageobjrepo com = PageFactory.initElements(Driver.driver, commonpageobjrepo.class);
	Home home = PageFactory.initElements(Driver.driver,Home.class);
	
	public void CreateOrganization(String OrgName){
		com.getAlldropdownlink().click();
		waitForElemnetXpathPresent("//div[@class='dropdown-menu moreMenus']");
		home.getOrganizationLink().click();
		waitForPageToLoad();
		org.getOrgAddBtn().click();
		org.getOrgNameEdt().sendKeys(OrgName);
		com.getSavebtn().click();
		boolean flag =com.getConfirmationpopup().isDisplayed();
		if(flag){
			com.getConfirmationpopup().click();
		
		}
		else{
			com.getSavebtn().click();
		}
		
		waitForPageToLoad();
		
	}
	public void ModifyOrganization(String OrgName){
		String [] Orgname = OrgName.split(";");
		new Organizationlib().CreateOrganization(Orgname[0]);
		waitForPageToLoad();
		org.getOrgEditBtn().click();
		waitForPageToLoad();
		org.getOrgNameEdt().clear();
		org.getOrgNameEdt().sendKeys(Orgname[1]);
		com.getSavebtn().click();
		
	}
	
	public void AddOrganizationDocument(String OrgName , String DocumentName) throws IOException, InterruptedException{
		new Organizationlib().CreateOrganization(OrgName);
		waitForPageToLoad();
		com.getMorebtn().click();
		org.getOrgAddDocumentLink().click();
		waitForPageToLoad();
		org.getOrgDocumentNameEdt().sendKeys(DocumentName);
		org.getOrgDocumentFileAttachment().click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\ANKIT\\Desktop\\auto\\file.exe");
		Thread.sleep(1000);
		com.getSavebtn().click();
		waitForPageToLoad();
		
	}
	
}
