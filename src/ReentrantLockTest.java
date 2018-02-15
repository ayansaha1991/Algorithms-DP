import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLockTest {

	private static int value = 0;
	private static Lock lock = new ReentrantLock();
	static Condition cond = lock.newCondition();
	
	public static void increment() {
		
		lock.lock();

		for (int i = 0; i < 10000; i++) {
			value++;
		}
		
		lock.unlock();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				increment();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				increment();
			}
		});
		
		t1.start();
		t2.start();
		
		
		t1.join();
		t2.join();
		
		System.out.println(value);
	}
	
}
