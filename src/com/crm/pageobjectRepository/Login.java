package com.crm.pageobjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	@FindBy(id ="username")
	private WebElement username;
	
	@FindBy(id ="password")
	private WebElement passward;
	
	@FindBy(xpath ="//button[text()='Sign in']")
	private WebElement Loginbtn;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassward() {
		return passward;
	}

	public WebElement getLoginbtn() {
		return Loginbtn;
	}
	
}
