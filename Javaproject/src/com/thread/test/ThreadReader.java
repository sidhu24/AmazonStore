package com.thread.test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ThreadReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		URL url=Thread.currentThread().getContextClassLoader().getResource("com/net/resources/config.properties");
	System.out.println(Thread.currentThread().getClass());
		
		//URL url= ThreadReader.class.getResource("/com/thread/test/test");
		Properties props=new Properties();
		props.load(url.openStream());
				System.out.println(props.getProperty("hai"));
				
				List<Object> l=new ArrayList<Object>();
				l.add(new Integer(4));
				System.out.println(l);
				
	}

}
