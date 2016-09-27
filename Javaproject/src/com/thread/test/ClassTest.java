package com.thread.test;

import java.io.ObjectInputStream.GetField;

public class ClassTest {

	int a = 10;

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Class<?> cls = Class.forName("com.thread.test.ClassTest");
		displayDetails(cls);
		// ClassTest ct=(ClassTest) cls.newInstance();
		// System.out.println(ct.a);
		Class<?> cs=getCurrentClass();
		System.out.println(((ClassTest)cs.newInstance()).a);
	}

	static void displayDetails(Class<?> cls) throws InstantiationException,
			IllegalAccessException {
		ClassTest ct = (ClassTest) cls.newInstance();
		System.out.println(ct.a);
		System.out.println("added comments");
	}

	static Class<?> getCurrentClass() {
		return ClassTest.class;
	}
}
