package com.crm.pageobjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
	
	
	
	@FindBy(xpath ="//div[@id='topMenus']//div/ul[4]/li/div/div[1]/span[3]/label[2]/a")
	private WebElement prodctlink;
	
	@FindBy(xpath ="//div[@id='topMenus']//div/ul[4]/li/div/div[1]/span[1]/label[1]/a")
	private WebElement campaignslink;
	
	@FindBy(xpath ="//div[@id='topMenus']//div/ul[4]/li/div/div[1]/span[1]/label[2]/a")
	private WebElement Leadlink;

	@FindBy(xpath ="//div[@id='topMenus']//div/ul[4]/li/div/div[1]/span[1]/label[4]/a")
	private WebElement OrganizationLink;
	
	@FindBy(xpath ="//div[@id='topMenus']//div/ul[4]/li/div/div[1]/span[1]/label[5]/a")
	private WebElement OppourtunitiesLink;
	
	@FindBy(xpath ="//div[@id='topMenus']//div/ul[4]/li/div/div[1]/span[1]/label[6]/a")
	private WebElement QuotesLink;
	
	@FindBy(xpath ="//div[@id='topMenus']//div/ul[4]/li/div/div[1]/span[1]/label[7]/a")
	private WebElement InvoiceLink;
	
	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}





	public WebElement getOppourtunitiesLink() {
		return OppourtunitiesLink;
	}





	public WebElement getQuotesLink() {
		return QuotesLink;
	}





	public WebElement getInvoiceLink() {
		return InvoiceLink;
	}





	public WebElement getLeadlink() {
		return Leadlink;
	}





	public WebElement getCampaignslink() {
		return campaignslink;
	}





	public WebElement getProdctlink() {
		return prodctlink;
		
	}
	
	

	
	
}
