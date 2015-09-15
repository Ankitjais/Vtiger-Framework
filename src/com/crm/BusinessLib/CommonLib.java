package com.crm.BusinessLib;

import org.openqa.selenium.support.PageFactory;





import com.crm.genriclib.Driver;
import com.crm.genriclib.webdrivercommonlib;
import com.crm.pageobjectRepository.Login;



public class CommonLib {
	webdrivercommonlib wclib = new webdrivercommonlib();
	Login login = PageFactory.initElements(Driver.driver, Login.class);
	
	public void LogIn(String username ,String Passward){
		login.getUsername().sendKeys(username);
		login.getPassward().sendKeys(Passward);
		login.getLoginbtn().click();
	}
	public void LogOut(){
		wclib.clickonXpathofWebElement("//a[@id='menubar_item_right_Administrator']/strong");
		wclib.clickonXpathofWebElement("//a[text()='Sign Out']");
	}
	public void clickdropdown(){
		wclib.clickonXpathofWebElement("//div[@class='span9']/ul[4]/li/a");
		wclib.waitForElemnetXpathPresent("//div[@class='dropdown-menu moreMenus']");
	}
	
}
