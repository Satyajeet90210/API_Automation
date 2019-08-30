package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public Properties prop;
	public int RESPONSE_STATUS_CODE_SUCCESS =200;
	public TestBase(){
		try {
			 prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\WORK\\Script_WorkSpace\\API_Automation\\restAPI\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
