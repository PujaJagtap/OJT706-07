package com.tests;

import org.testng.annotations.Test;

public class DemoTest2 {

	@Test(groups = "regression")
	public void login() {
		System.out.println("login");
	}

	@Test(groups = "sanity")
	public void dashboard() {
		System.out.println("dashboard");
	}

	@Test(groups = "regression")
	public void user() {
		System.out.println("user");
	}

	@Test(groups = "sanity")
	public void logout() {
		System.out.println("logout");
	}
}
