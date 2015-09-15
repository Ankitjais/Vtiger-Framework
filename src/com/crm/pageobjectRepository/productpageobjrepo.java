package com.crm.pageobjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productpageobjrepo {
	@FindBy(id ="Products_listView_basicAction_LBL_ADD_RECORD")
	private WebElement productAddbtn;
	
	@FindBy(id="Products_editView_fieldName_productname")
	private WebElement productNameEdt;
	
	@FindBy(id="Products_editView_fieldName_discontinued")
	private WebElement productActivecheckbox;
	
	@FindBy(xpath ="//form[@id='EditView']/table[1]/tbody/tr[2]/td[4]/div/span/div/div/span/i")
	private WebElement productsalestartcalendericon;
	
	@FindBy(id ="Products-editview-fieldname-unit_price")
	private WebElement productpriceEdt;
	
	@FindBy(xpath="//table[thead[tr[th[a[span[text()='May, 2015']]]]]]/tbody[2]/tr[5]/td[4]/a/span")
	private WebElement productsalestartdatepath;

	public WebElement getProductsalestartdatepath() {
		return productsalestartdatepath;
	}

	public WebElement getProductAddbtn() {
		return productAddbtn;
	}

	public WebElement getProductLastNameEdt() {
		return productNameEdt;
	}

	public WebElement getProductActivecheckbox() {
		return productActivecheckbox;
	}

	public WebElement getProductsalestartcalendericon() {
		return productsalestartcalendericon;
	}

	public WebElement getProductpriceEdt() {
		return productpriceEdt;
	}
}
