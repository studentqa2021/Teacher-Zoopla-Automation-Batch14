package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseConfig {
	Properties pr;

	public String getData(String data) {

		try {
			File file = new File("./Config.properties");
			FileInputStream fis = new FileInputStream(file);

			pr = new Properties();
			pr.load(fis);

			System.out.println(pr.getProperty(data));
		} catch (Exception e) {

			e.printStackTrace();
		}

		return pr.getProperty(data);
	}

	
}// class end
