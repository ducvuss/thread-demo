package multithreading;

import java.util.stream.IntStream;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread myThread = new MyThread();
		myThread.start();
		
		MyThread anotherThread = new MyThread();
		anotherThread.start();
	}
	
	

}


class MyThread extends Thread {
	public void run() {
		IntStream
		.range(0,10)
		.forEach(x -> {
			System.out.println(x);
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
