package multithreading;

import java.util.stream.IntStream;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread myThread = new MyThread("My Thread 1");
		myThread.start();
		
		MyThread anotherThread = new MyThread("My Thread 2");
		anotherThread.start();
		

		Thread yourThread = new Thread(new YourThread("Your Thread 1"));
		yourThread.start();
		
		Thread yourAnotherThread = new Thread(new YourThread("Your Thread 2"));
		yourAnotherThread.start();
		
	}
}

// create thread from Thread superclass
class MyThread extends Thread {
	
	public MyThread(String name) {
		this.setName(name);
	}
	
	public void run() {
		IntStream
		.range(0,10)
		.forEach(x -> {
			System.out.println(this.getName() + "-" + x);
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}

// create thread from Runnable interface
class YourThread implements Runnable {
	
	
	private String name;

	public YourThread(String name) {
		this.name = name;
	}
	
	public void run() {
		IntStream
		.range(0,10)
		.forEach(x -> {
			System.out.println(name + "-" + x);
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}

