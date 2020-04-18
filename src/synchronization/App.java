package synchronization;

import java.util.Scanner;

public class App {
	
	// main also running on its own thread
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Proccessor proc1 = new Proccessor();
		proc1.start();
		
		System.out.println("Press return to stop ...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		proc1.shutdown();

	}

}

class Proccessor extends Thread {
	/*
	 * volatile - avoid caching issue of running var
	 * 
	 * caching issue can cause running to stay true, eventhough shutdown() is executed
	 * */
	private volatile boolean running = true;
	
	public void run() {

		while(running) {
			System.out.println("thread is running...");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		running = false;
	}
}
