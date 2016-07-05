package com.thread.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadPropetiesFile {

	private Properties configProp = new Properties();
	public static void main(String[] args) {
		LoadPropetiesFile sample = new LoadPropetiesFile();
		sample.loadProps2();
		sample.sayHello();
	}
	public void loadProps1() {
		InputStream in = this.getClass().getResourceAsStream("/com/net/properties/config.properties");
		try {
			configProp.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadProps2() {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("com/net/resources/config.properties");
		try {
			configProp.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
public void sayHello() { System.out.println(configProp.getProperty("hello")); } }
