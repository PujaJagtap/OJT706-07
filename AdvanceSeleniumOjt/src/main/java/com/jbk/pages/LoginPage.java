package com.jbk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.jbk.object_repository.LoginObjectRepo;

public class LoginPage extends LoginObjectRepo{
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public void correctData() {
		email.sendKeys("kiran@gmail.com");
		pass.sendKeys("123456");
		button.click();
	}

}