package com.utilities;

import java.io.FileReader;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("file:///C:/Users/PUSHKRAJ/Downloads/Selenium%20Softwares/Selenium%20Softwares/Offline%20Website/index.html");
		Properties p = new Properties();
		p.load(fr);
		
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("testurl"));
	}
} 