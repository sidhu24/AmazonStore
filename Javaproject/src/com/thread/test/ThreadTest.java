package com.thread.test;

class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println("hello");
		display();
	}
	synchronized void display()
	{
		//try {
			//this.notify();
			//wait();
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		System.out.println("i am in......");
	}
}

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
MyThread mt=new MyThread();
mt.setPriority(1);
mt.start();

		synchronized (mt) {
			System.out.println("before main thread...........");
			mt.wait();
			
			System.out.println("after main thread..........");
			//mt.notify();
			//mt.wait();
			System.out.println(".........main thread completed..........");
		}
	}

}
