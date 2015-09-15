package com.crm.pageobjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadPageobjrepo {

	@FindBy(id="Leads_listView_basicAction_LBL_ADD_RECORD")
	private WebElement leadAddbtn;
	
	public WebElement getLeadAddbtn() {
		return leadAddbtn;
	}
	

	public WebElement getLeadLastNameEdt() {
		return LeadLastNameEdt;
	}

	@FindBy(id="Leads_editView_fieldName_lastname")
	private WebElement LeadLastNameEdt;
	
	@FindBy(id="Leads_detailView_basicAction_LBL_EDIT")
	private WebElement LeadEditEdt;
	
	@FindBy(xpath ="//form[@id='EditView']/table[1]/tbody/tr[1]/td[2]/div/span/div/a")
	private WebElement LeadfirstNameDropdownLink;
	
	@FindBy(xpath ="//form[@id='EditView']/table[1]/tbody/tr[1]/td[2]/div/span/div/div/ul/li[2]")
	private WebElement LeadfirstnamedropdownValue;
	
	@FindBy(id="Leads_editView_fieldName_firstname")
	private WebElement LeadFirstNameEdt;
	
	@FindBy(xpath ="//a[text()='Duplicate']")
	private WebElement LeadDuplicateLink;
	
	@FindBy(xpath ="//a[@class='quickLinks']/strong[text()='Leads List']")
	private WebElement LeadListLink;
	
	@FindBy(xpath ="//a[text()='Delete Lead']")
	private WebElement LeadDeleteLink;
	
	public WebElement getLeadDeleteLink() {
		return LeadDeleteLink;
	}


	public WebElement getLeadListLink() {
		return LeadListLink;
	}


	public WebElement getLeadDuplicateLink() {
		return LeadDuplicateLink;
	}


	public WebElement getLeadEditEdt() {
		return LeadEditEdt;
	}


	public WebElement getLeadfirstNameDropdownLink() {
		return LeadfirstNameDropdownLink;
	}


	public WebElement getLeadfirstnamedropdownValue() {
		return LeadfirstnamedropdownValue;
	}


	public WebElement getLeadFirstNameEdt() {
		return LeadFirstNameEdt;
	}
}
