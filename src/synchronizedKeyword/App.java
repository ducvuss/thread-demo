package synchronizedKeyword;
/*
 * 
 * 
 */
public class App {
	private int count = 0;
	
	public static void main(String[] args) {
		App app = new App();
		app.doWork();
	}

	private void doWork() {

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 2; i++) {
					count++;
					System.out.println("t1 is running");
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(200);
						count++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("t2 is running");
				}
			}
		});
		
		t1.start();
		t2.start();
		
		/*
		 * the join method pause the execution until the thread finishes executing
		 */
		try {
			System.out.println("Count is: " + count); // this statement doesn't wait for t1 & t2 to finish executing
			t1.join();
			System.out.println("Count is: " + count);  // this statement waits for t1 to complete but not t2
			t2.join();
			System.out.println("Count is: " + count); // this statement waits for both t1 & t2 to complete
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		/*
		 * extends the execution time of t3 so t1 and t2 can finish 1st
		 */

	}
	
	
}
