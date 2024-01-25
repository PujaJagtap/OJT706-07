package com.jbk.object_repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginObjectRepo {
	@FindBy(id = "email")
	public WebElement email;
	@FindBy(id = "password")
	public WebElement pass;
	@FindBy(xpath = "//button")
	public WebElement button;
	
}