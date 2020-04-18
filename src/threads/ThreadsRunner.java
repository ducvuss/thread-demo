package threads;

public class ThreadsRunner {

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadDemo("one"));
		Thread t2 = new Thread(new ThreadDemo("two"));
		Thread t3 = new Thread(new ThreadDemo("three"));
		Thread t4 = new Thread(new ThreadDemo("four"));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
