package synchronizedKeyword;

/*
 * 
 * 
 */
public class App2 {
	private int count = 0;

	public static void main(String[] args) {
		App2 app = new App2();
		app.doWork();
	}

	private void doWork() {

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 2; i++) {
					count++;
					System.out.println("t1 is running. Count is: " + count);
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
					System.out.println("t2 is running. Count is: " + count);
				}
			}
		});

		Thread t3 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 6; i++) {
					try {
						Thread.sleep(500);
						count++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("t3 is running. Count is: " + count);
				}
			}
		});

		Thread t4 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 8; i++) {
					try {
						Thread.sleep(500);
						count++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("t4 is running. Count is: " + count);
				}
			}
		});
		
		/*
		 * extends the execution time of t3 so t1 and t2 can finish 1st
		 */

		try {
			t4.start();
			t3.start();
			t1.start();
			t2.start();
			System.out.println("Count is: " + count); // this statement doesn't wait for t1, t2, t3 to finish executing
			t3.join();
			System.out.println("Count is: " + count); // waits for t3, but t1 & t2 finish earlier, while t4 takes longer to finish
			t4.join();
			System.out.println("Count is: " + count); // the final result
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
