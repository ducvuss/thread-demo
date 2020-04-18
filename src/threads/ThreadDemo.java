package threads;

import java.util.Random;

public class ThreadDemo implements Runnable {
	String threadName;
	int time;
	Random r = new Random();
	
	public ThreadDemo(String threadName) {
		this.threadName = threadName;
		time = r.nextInt(999);
	}
	@Override
	public void run() {
		try {
			System.out.printf("%s is sleeping for %d\n", threadName, time);
			// thread refers to current thread object
			Thread.sleep(time);
			System.out.printf("%s is done sleeping\n", threadName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
