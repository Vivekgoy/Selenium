package com.actitime.test;


import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.pom.ActitimeLoginPage;

@Test
public class ActitimeLoginTest extends BaseTest{

	public void login() throws Exception{
		ActitimeLoginPage login = new ActitimeLoginPage(driver);
		login.loginMethod();
	}
}
