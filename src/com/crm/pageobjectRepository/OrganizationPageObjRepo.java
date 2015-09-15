package com.crm.pageobjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationPageObjRepo {
	@FindBy(id ="Accounts_listView_basicAction_LBL_ADD_RECORD")
	private WebElement OrgAddBtn;
	
	@FindBy(id="Accounts_editView_fieldName_accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(xpath ="//span[@class='add-on relatedPopup cursorPointer']/i")
	private WebElement OrgMemberOfSearchBtn;
	
	@FindBy(xpath ="//table[@class='table table-bordered listViewEntriesTable']/tbody/tr[1]/td[1]/a[text()='ats']")
	private WebElement OrgMemberOfValue;
	
	@FindBy(id="Accounts_detailView_basicAction_LBL_EDIT")
	private WebElement OrgEditBtn;
	
	@FindBy(xpath="//span[@class='row-fluid']/span/span")
	private WebElement OrgInfo;
	
	@FindBy(xpath="(//td[@class='fieldValue']/div/span)[1]")
	private WebElement OrgNameinfo;
	
	@FindBy(xpath="//a[text()='Delete Organization']")
	private WebElement OrgDeleteLink;
	
	@FindBy(xpath="//a[text()='Duplicate']")
	private WebElement OrgDuplicateLink;
	
	@FindBy(xpath="//a[text()='Add Document']")
	private WebElement OrgAddDocumentLink;
	
	@FindBy(id="Documents_editView_fieldName_notes_title")
	private WebElement OrgDocumentNameEdt;
	
	@FindBy(xpath ="//a[@class='quickLinks']/strong[text()='Organization List']")
	private WebElement OrgListLink;

	@FindBy(xpath ="//table[@class='table table-bordered blockContainer showInlineTable equalSplit']/tbody/tr[2]/td[2]/div/span/div/input")
	private WebElement OrgDocumentFileAttachment;
	
	public WebElement getOrgDocumentFileAttachment() {
		return OrgDocumentFileAttachment;
	}

	public WebElement getOrgAddBtn() {
		return OrgAddBtn;
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getOrgMemberOfSearchBtn() {
		return OrgMemberOfSearchBtn;
	}

	public WebElement getOrgMemberOfValue() {
		return OrgMemberOfValue;
	}

	public WebElement getOrgEditBtn() {
		return OrgEditBtn;
	}

	public WebElement getOrgInfo() {
		return OrgInfo;
	}

	public WebElement getOrgNameinfo() {
		return OrgNameinfo;
	}

	public WebElement getOrgDeleteLink() {
		return OrgDeleteLink;
	}

	public WebElement getOrgDuplicateLink() {
		return OrgDuplicateLink;
	}

	public WebElement getOrgAddDocumentLink() {
		return OrgAddDocumentLink;
	}

	public WebElement getOrgDocumentNameEdt() {
		return OrgDocumentNameEdt;
	}

	public WebElement getOrgListLink() {
		return OrgListLink;
	}
	

}
