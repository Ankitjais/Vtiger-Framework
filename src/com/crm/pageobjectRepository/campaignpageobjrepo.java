package com.crm.pageobjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class campaignpageobjrepo {
	@FindBy(id="Campaigns_listView_basicAction_LBL_ADD_RECORD")
	private WebElement campaignsAddbtn;
	
	@FindBy(id="Campaigns_editView_fieldName_campaignname")
	private WebElement campiagnsNameEdt;
	
	@FindBy(xpath="//form[@id='EditView']//tbody/tr[1]/td[4]/div/span/div/a[@class='chzn-single']")
	private WebElement campaignsAssignTodropdown;
	
	@FindBy(xpath="//form[@id='EditView']//tbody/tr[1]/td[4]/div/span/div/div/ul/li[4]")
	private WebElement campaignsAssignTodropdownvalue;
	
	@FindBy(xpath ="//span[@class='add-on relatedPopup cursorPointer']/i")
	private WebElement productSearchbtn;
	@FindBy(xpath ="//tr[td[text()='₹35,000.00']]/td[1]/a[text()='HPLaptops']")
	private WebElement CreatedProductName;
	
	@FindBy(xpath ="//span[@class='add-on']/i[@class='icon-calendar']")
	private WebElement campaignexpectedclosedatecalender;
	
	@FindBy(id="Campaigns_detailView_basicAction_LBL_EDIT")
	private WebElement campaignsEditbtn;
	
	public WebElement getCampaignsStatusdropdown() {
		return CampaignsStatusdropdown;
	}
	
	@FindBy(xpath ="//a[text()='Delete Campaign']")
	private WebElement Campaignsdeletelink;
	
	public WebElement getCampaignsdeletelink() {
		return Campaignsdeletelink;
	}

	@FindBy(xpath ="//form[@id='EditView']/table[1]/tbody/tr[2]/td[2]/div/span/div/div/ul/li[3]")
	private WebElement CampaignsStatusdropdownvalue;

	public WebElement getCampaignsStatusdropdownvalue() {
		return CampaignsStatusdropdownvalue;
	}
	@FindBy(xpath="//form[@id='EditView']/table[1]/tbody/tr[2]/td[2]/div/span/div/a")
	private WebElement CampaignsStatusdropdown;

	public WebElement getCampaignsEditbtn() {
		return campaignsEditbtn;
	}

	public WebElement getCampaignexpectedclosedatecalender() {
		return campaignexpectedclosedatecalender;
	}

	public WebElement getCreatedProductName() {
		return CreatedProductName;
	}

	public WebElement getCampaignsAddbtn() {
		return campaignsAddbtn;
	}

	public WebElement getCampiagnsNameEdt() {
		return campiagnsNameEdt;
	}

	public WebElement getCampaignsAssignTodropdown() {
		return campaignsAssignTodropdown;
	}

	public WebElement getCampaignsAssignTodropdownvalue() {
		return campaignsAssignTodropdownvalue;
	}

	public WebElement getProductSearchbtn() {
		return productSearchbtn;
	}
}
