package com.crm.BusinessLib;

import org.openqa.selenium.support.PageFactory;





import com.crm.genriclib.Driver;
import com.crm.genriclib.webdrivercommonlib;
import com.crm.pageobjectRepository.commonpageobjrepo;
import com.crm.pageobjectRepository.contactpagerepo;


public class Contactlib {
	
	webdrivercommonlib wclib = new webdrivercommonlib();
	contactpagerepo cntpgrp = PageFactory.initElements(Driver.driver, contactpagerepo.class);
	commonpageobjrepo compgobrp = PageFactory.initElements(Driver.driver, commonpageobjrepo.class);
	
	public void CreateContact(String ContactName){
		
		cntpgrp.getContactlink().click();
		cntpgrp.getAddcontactbtn().click();
		wclib.waitForPageToLoad();
		cntpgrp.getContactlastnameedt().sendKeys(ContactName);
		compgobrp.getSavebtn().click();
		
	}

	
	public void ModifyContact(String Fristname ,String Lastname){
		new Contactlib().CreateContact(Lastname);
		wclib.waitForPageToLoad();
		cntpgrp.getContactEditbtn().click();
		wclib.waitForPageToLoad();
		cntpgrp.getFirstnamedropdown().click();
		cntpgrp.getFirstNamedropdownvalue().click();
		cntpgrp.getFirstNameEdt().sendKeys(Fristname);
		compgobrp.getSavebtn().click();
		
		
	}
	public void DeleteContact(String FirstName , String LastName){
		Contactlib contst = new Contactlib();
		contst.ModifyContact(FirstName ,LastName);
		compgobrp.getMorebtn().click();
		compgobrp.getMorebtn();
		cntpgrp.getDeletecontactlink().click();
		compgobrp.getConfirmationpopup().click();
		wclib.waitForElemnetXpathPresent("//div[@class='listViewEntriesDiv contents-bottomscroll']");
	}
	
	public void DuplicateContact(String Lastname){
		Contactlib contst = new Contactlib();
		contst.CreateContact(Lastname);
		compgobrp.getMorebtn().click();
		cntpgrp.getContactduplicatelink().click();
		compgobrp.getSavebtn().click();
		wclib.waitForPageToLoad();
		cntpgrp.getContactlistlink().click();
	}
}
		/*wclib.waitForPageToLoad();
		cntpgrp.getContactlistlink();
		wclib.waitForPageToLoad();
		List lst =(List) cntpgrp.getContacttablelastnamelist();
	int count =0;	
	for(int i =1 ; i<lst.size(); i++){
			String CreateContact= ((WebElement) lst.get(i)).getText();
			if(Lastname.equals(CreateContact)){
				count++;
				}
			else
			{
				System.out.println("Duplicate contact is not created");
			}
		}
			System.out.println(count+"" +"duplicate contact is created");
		}
	}
*/
