package com.thread.test;

class IncrementDisplay {

	int i;

	synchronized void increment() {
		i++;
		System.out.println("increment");
		this.notify();
	}

	synchronized void display() {
		System.out.println("value " + i);
		this.notify();
	}
}

class Increment extends Thread {
	IncrementDisplay id;

	public void setId(IncrementDisplay id) {
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
			synchronized (id) {
				id.increment();
				try {
					id.wait();
				} catch (InterruptedException e1) {

				}
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {

				}
			}

		}
	}

}

class Display extends Thread {
	IncrementDisplay id;

	public void setId(IncrementDisplay id) {
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
			synchronized (id) {
				try {

					Thread.sleep(1500);
				} catch (InterruptedException e) {

				}
				id.display();
				try {
					if (i != 10)
						id.wait();
				} catch (InterruptedException e1) {

				}
			}

		}
	}

}

public class Test {
	public static void main(String[] args) {
		IncrementDisplay idc = new IncrementDisplay();
		Increment i = new Increment();
		i.setPriority(10);
		i.setId(idc);
		Display d = new Display();
		d.setId(idc);
		i.start();
		d.start();
	}
}