package com.crm.genriclib;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class webdrivercommonlib {
	//Implict Wait statement Method
			public void waitForPageToLoad(){
				Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
	//Explict wait Statements Methods
			public void waitForElemnetXpathPresent(String xpath){
				WebDriverWait wait = new WebDriverWait(Driver.driver,20);
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
			}
			public void waitforLinknamePresent(String LinkName){
				WebDriverWait wait = new WebDriverWait(Driver.driver,20);
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(LinkName)));
			}
			public void waitforIDPresent(String IDName){
				WebDriverWait wait = new WebDriverWait(Driver.driver,20);
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(IDName)));
			}
			public void waitforClassName(String className){
				WebDriverWait wait = new WebDriverWait(Driver.driver,20);
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(className)));
	
			}
			public void waitforCssSelectorPresent(String CssSelector){
				WebDriverWait wait = new WebDriverWait(Driver.driver,20);
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CssSelector)));
			}
			public void waitforTagNamePresent(String TagName){
				WebDriverWait wait = new WebDriverWait(Driver.driver,20);
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(TagName)));
	
			}
			// Locator Methods with sendKeys Method
			public void classNameofWebElement(String className ,String SendKeys ){
				Driver.driver.findElement(By.className(className)).sendKeys(SendKeys);
			}
			public void cssSelectorofWebElement(String cssSelector , String SendKeys){
				Driver.driver.findElement(By.cssSelector(cssSelector)).sendKeys(SendKeys);
			}
			public void IDofWebElement(String id , String SendKeys){
				Driver.driver.findElement(By.id(id)).sendKeys(SendKeys);
			}
			public void linkTextofWebElement(String linkText , String SendKeys){
				Driver.driver.findElement(By.linkText(linkText)).sendKeys(SendKeys);
			}
			public void NameofWebElement(String name , String SendKeys){
				Driver.driver.findElement(By.name(name)).sendKeys(SendKeys);
			}
			public void LinkTextofWebElement(String linkText , String SendKeys){
				Driver.driver.findElement(By.partialLinkText(linkText)).sendKeys(SendKeys);
			}
			public void TagNameofWebElement(String name , String SendKeys){
				Driver.driver.findElement(By.tagName(name)).sendKeys(SendKeys);
			}
			public void XpathofWebElement(String xpath , String SendKeys){
				Driver.driver.findElement(By.xpath(xpath)).sendKeys(SendKeys);
			}
			// Locator Methods with Click
			public void clickonclassNameofWebElement(String className ){
				Driver.driver.findElement(By.className(className)).click();
			}
			public void clickoncssSelectorofWebElement(String cssSelector){
				Driver.driver.findElement(By.cssSelector(cssSelector)).click();
			}
			public void clickonIDofWebElement(String id){
				Driver.driver.findElement(By.id(id)).click();
			}
			public void clickonlinkTextofWebElement(String linkText){
				Driver.driver.findElement(By.linkText(linkText)).click();
			}
			public void clickonNameofWebElement(String name){
				Driver.driver.findElement(By.name(name)).click();
			}
			public void clickonLinkTextofWebElement(String linkText){
				Driver.driver.findElement(By.partialLinkText(linkText)).click();
			}
			public void clickonTagNameofWebElement(String name){
				Driver.driver.findElement(By.tagName(name)).click();
			}
			public void clickonXpathofWebElement(String xpath){
				Driver.driver.findElement(By.xpath(xpath)).click();
			}
			//get text methods
			public String GetTextofWebElementusingxpath(String xpath){
				return Driver.driver.findElement(By.xpath(xpath)).getText();
			}
			//methods for Bulk Elements
			public List<WebElement> GetBulkWebElementusingxpath(String xpath){
				 List<WebElement> lst =Driver.driver.findElements(By.xpath(xpath));
				return lst;
				
			}
			//keyboard Operation Methods
			public void KeyBoardOperation(String Symbol){
				Actions act = new Actions(Driver.driver);
				act.sendKeys(Keys.chord(Keys.CONTROL,Symbol)).perform();
			}
			//Verify Text Massage
			public boolean VerifyText(String ActualText , String ExpectedText){
				boolean flag = false;
				//String ActualText = Driver.driver.findElement(By.xpath(xpath)).getText();
				if(ExpectedText.equals(ActualText)){
					flag = true;
					System.out.println(ExpectedText +"Text Is Verified");
				}
				else{
					System.out.println(ExpectedText +"Text is not verified");
				}
				return flag;
			}
			
			//date Selector  Method
			public void dateSelector(String datexpath , String buttonXpath){
				webdrivercommonlib wclib = new webdrivercommonlib();
				while(true){
					try{
						wclib.clickonXpathofWebElement(datexpath);
						break;
					}
					catch(Exception e){
						wclib.clickonXpathofWebElement(buttonXpath);
						Driver.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					}
				}
				
			}
			
	}
			
