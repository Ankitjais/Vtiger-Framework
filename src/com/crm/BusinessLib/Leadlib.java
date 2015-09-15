package com.crm.BusinessLib;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.crm.genriclib.Driver;
import com.crm.genriclib.webdrivercommonlib;
import com.crm.pageobjectRepository.Home;
import com.crm.pageobjectRepository.LeadPageobjrepo;
import com.crm.pageobjectRepository.commonpageobjrepo;



public class Leadlib {
	
	webdrivercommonlib wclib = new webdrivercommonlib();
	Home home = PageFactory.initElements(Driver.driver, Home.class);
	commonpageobjrepo com = PageFactory.initElements(Driver.driver, commonpageobjrepo.class);
	LeadPageobjrepo lead =PageFactory.initElements(Driver.driver, LeadPageobjrepo.class);
	
	
	public void CreateLead(String LeadLastName){
	
		com.getAlldropdownlink().click();
		wclib.waitForElemnetXpathPresent("//div[@class='dropdown-menu moreMenus']");
		home.getLeadlink().click();
		wclib.waitForPageToLoad();
		lead.getLeadAddbtn().click();
		wclib.waitForPageToLoad();
		lead.getLeadLastNameEdt().sendKeys(LeadLastName);
		com.getSavebtn().click();
	}
	
	public void ModifyLead(String LeadFirstName ,String LeadLastName){
		new Leadlib().CreateLead(LeadLastName);
		wclib.waitForPageToLoad();
		lead.getLeadEditEdt().click();
		wclib.waitForPageToLoad();
		lead.getLeadfirstNameDropdownLink().click();
		lead.getLeadfirstnamedropdownValue().click();
		lead.getLeadFirstNameEdt().sendKeys(LeadFirstName);
		com.getSavebtn().click();
		
	}
	public void DeleteLead(String LeadFirstname , String LeadLastname){
		new Leadlib().ModifyLead(LeadFirstname, LeadLastname);
		wclib.waitForPageToLoad();
		com.getMorebtn().click();
		lead.getLeadDeleteLink().click();
		com.getConfirmationpopup().click();
		wclib.waitForElemnetXpathPresent("//div[@class='listViewEntriesDiv contents-bottomscroll']");
	
	}
	public void DuplicateLead(String LeadLastName){
		new Leadlib().CreateLead(LeadLastName);
		wclib.waitForPageToLoad();
		com.getMorebtn().click();
		lead.getLeadDuplicateLink().click();
		wclib.waitForPageToLoad();
		com.getSavebtn().click();
		wclib.waitForPageToLoad();
		lead.getLeadListLink().click();
		wclib.waitForPageToLoad();
		List<WebElement> lst =wclib.GetBulkWebElementusingxpath("//table[@class='table table-bordered listViewEntriesTable']/tbody/tr/td[3]");
		int count =0;
		for(int i =1 ; i<lst.size();i++){
			 String duplicatename = ((WebElement) lst.get(i)).getText();
			if(LeadLastName.equals(duplicatename)){
				count++;
			}
			else{
				System.out.println("Duplicate Leads is not created");
			}
		}
			System.out.println(count+" "+"duplicate Leads is created");
		
	}
}
