package com.crm.pageobjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class commonpageobjrepo {
	
	@FindBy(xpath ="//div[@class='contentHeader row-fluid']//span/button/strong")
	private WebElement savebtn;
	
	@FindBy(xpath ="//span[@class='btn-group']/button/strong[text()='More']")
	private WebElement Morebtn;
	
	public WebElement getConfirmationpopup() {
		return Confirmationpopup;
	}

	@FindBy(xpath ="//a[text()='Yes']")
	private WebElement Confirmationpopup;
	
	public WebElement getMorebtn() {
		return Morebtn;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getAlldropdownlink() {
		return Alldropdownlink;
	}

	@FindBy(xpath = "//div[@class='span9']/ul[4]/li/a")
	private WebElement Alldropdownlink;
	
	@FindBy(xpath ="//a[@id='menubar_item_right_Administrator']/strong")
	private WebElement Administratiorlink;
	
	@FindBy(xpath ="//a[@id='menubar_item_right_Administrator']/strong")
	private WebElement SignOutLink;

	public WebElement getAdministratiorlink() {
		return Administratiorlink;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
}
