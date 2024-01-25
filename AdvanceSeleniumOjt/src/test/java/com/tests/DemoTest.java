package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {
	@Test(priority = 0)
	public void login() {
		System.out.println("login");
	}

	@Test(priority = 1, dependsOnMethods = "login")
	public void dashboard() {
		System.out.println("dashboard");
		Assert.assertTrue(true);
	}

	@Test(priority = 2, dependsOnMethods = "dashboard", alwaysRun = true)
	public void user() {
		System.out.println("user");
	}

}
