package com.crm.BusinessLib;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.support.PageFactory;

import com.crm.genriclib.Driver;
import com.crm.genriclib.webdrivercommonlib;
import com.crm.pageobjectRepository.Home;
import com.crm.pageobjectRepository.campaignpageobjrepo;
import com.crm.pageobjectRepository.productpageobjrepo;
import com.crm.pageobjectRepository.commonpageobjrepo;



public class Campaignslib {
	
	webdrivercommonlib wclib = new webdrivercommonlib();
	Home home = PageFactory.initElements(Driver.driver, Home.class);
	productpageobjrepo pro = PageFactory.initElements(Driver.driver, productpageobjrepo.class);
	commonpageobjrepo com = PageFactory.initElements(Driver.driver, commonpageobjrepo.class);
	campaignpageobjrepo cam = PageFactory.initElements(Driver.driver, campaignpageobjrepo.class);
	
	
	public void CreateProduct(String ProductName ,String Price){
		com.getAlldropdownlink().click();
		wclib.waitForElemnetXpathPresent("//div[@class='dropdown-menu moreMenus']");
		home.getProdctlink().click();
		wclib.waitForPageToLoad();
		pro.getProductAddbtn().click();
		wclib.waitForPageToLoad();
		pro.getProductLastNameEdt().sendKeys(ProductName);
		pro.getProductActivecheckbox().click();
		pro.getProductsalestartcalendericon().click();
		wclib.dateSelector("//table[thead[tr[th[a[span[text()='May, 2015']]]]]]/tbody[2]/tr[5]/td[4]/a/span","//div[@class='datepickerContainer']//table[@class='datepickerViewDays']/thead/tr[1]/th[3]/a/span");
		pro.getProductpriceEdt().sendKeys(Price);
		com.getSavebtn().click();
	}
	public void CreateCampaigns(String productName,String CampaignName ,String Price){
		new Campaignslib().CreateProduct(productName ,Price);	
		wclib.waitForElemnetXpathPresent("//form[@id='detailView']");
		com.getAlldropdownlink().click();
		wclib.waitForPageToLoad();
		home.getCampaignslink().click();
		wclib.waitForPageToLoad();
		cam.getCampaignsAddbtn().click();
		wclib.waitForPageToLoad();
		cam.getCampiagnsNameEdt().sendKeys(CampaignName);
		cam.getCampaignsAssignTodropdown().click();
		cam.getCampaignsAssignTodropdownvalue().click();
		cam.getProductSearchbtn().click();
		Set<String> str = Driver.driver.getWindowHandles();
		Iterator<String> itr  = str.iterator();
		String Parent_id = itr.next();
		String child_id = itr.next();
		Driver.driver.switchTo().window(child_id);
		cam.getCreatedProductName().click();
		Driver.driver.switchTo().window(Parent_id);
		cam.getCampaignexpectedclosedatecalender().click();
		String xpath = "//table[thead[tr[th[a[span[text()='July, 2015']]]]]]//tbody[2]/tr[4]/td[7]/a/span";
		wclib.dateSelector(xpath,"//div[@class='datepickerContainer']//table[@class='datepickerViewDays']/thead/tr[1]/th[3]/a/span");
		com.getSavebtn().click();
	}
	public void ModifyCampaigns(String productName ,String campaignsName ,String price){
		new Campaignslib().CreateCampaigns(productName, campaignsName, price);
		wclib.waitForElemnetXpathPresent("//div[@class='contents']");
		cam.getCampaignsEditbtn().click();
		wclib.waitForPageToLoad();
		cam.getCampaignsStatusdropdown().click();
		cam.getCampaignsStatusdropdownvalue().click();
		com.getSavebtn().click();
		
	}
	public void deleteCampaigns(String productName ,String campaignsName ,String price){
		new Campaignslib().CreateCampaigns(productName, campaignsName, price);
		wclib.waitForPageToLoad();
		com.getMorebtn().click();
		cam.getCampaignsdeletelink().click();
		com.getConfirmationpopup().click();
		wclib.waitForElemnetXpathPresent("//table[@class='table table-bordered listViewEntriesTable']");
		
	}
}