package com.crm.pageobjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class contactpagerepo {
	
	@FindBy(xpath ="//div[@class='span9']/ul[1]/li[5]/a/strong")
	private WebElement contactlink;
	
	
	@FindBy(id = "Contacts_listView_basicAction_LBL_ADD_RECORD")
	private WebElement Addcontactbtn;
	
	@FindBy(id ="Contacts_editView_fieldName_lastname")
	private WebElement contactlastnameedt;

	@FindBy(id ="Contacts_detailView_basicAction_LBL_EDIT")
	private WebElement contactEditbtn;
	
	@FindBy(xpath ="//form[@id='EditView']//tbody/tr[1]/td[2]/div/span/div/a")
	private WebElement Firstnamedropdown;
	
	@FindBy(xpath ="//form[@id='EditView']//tbody/tr[1]/td[2]/div/span/div/div/ul/li[2]")
	private WebElement FirstNamedropdownvalue;
	
	@FindBy(id ="Contacts_editView_fieldName_firstname")
	private WebElement FirstNameEdt;
	
	@FindBy(xpath ="//a[text()='Delete Contact']")
	private WebElement deletecontactlink;
	
	@FindBy(xpath ="//a[text()='Duplicate']")
	private WebElement contactduplicatelink;
	
	@FindBy(xpath ="//a[@class='quickLinks']/strong[text()='Contacts List']")
	private WebElement contactlistlink;
	
	public WebElement getContactlistlink() {
		return contactlistlink;
	}

	@FindBys(value ={@FindBy(xpath ="//table[@class='table table-bordered listViewEntriesTable']/tbody/tr/td[3]")})
	private WebElement contacttablelastnamelist;

	public WebElement getContacttablelastnamelist() {
		return contacttablelastnamelist;
	}



	public WebElement getContactduplicatelink() {
		return contactduplicatelink;
	}

	@FindBy(xpath ="//span[@class='btn-group listViewMassActions']/button/strong[text()='Actions']")
	private WebElement Actionbar;
	
	public WebElement getActionbar() {
		return Actionbar;
	}
	
	@FindBy(xpath ="//a[text()='Delete']")
	private WebElement ActionbarDeltelink;
	
	public WebElement getActionbarDeltelink() {
		return ActionbarDeltelink;
	}

	

	public WebElement getDeletecontactlink() {
		return deletecontactlink;
	}

	public WebElement getContactEditbtn() {
		return contactEditbtn;
	}

	public WebElement getFirstnamedropdown() {
		return Firstnamedropdown;
	}

	public WebElement getFirstNamedropdownvalue() {
		return FirstNamedropdownvalue;
	}

	public WebElement getFirstNameEdt() {
		return FirstNameEdt;
	}

	public WebElement getAddcontactbtn() {
		return Addcontactbtn;
	}

	public WebElement getContactlastnameedt() {
		return contactlastnameedt;
	}
	public WebElement getContactlink() {
		return contactlink;
	}

}