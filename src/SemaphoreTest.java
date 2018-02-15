import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


public class SemaphoreTest {
	
	static Semaphore pass = new Semaphore(5);
	
	public static void testSema() throws InterruptedException {
		
		if (pass.tryAcquire()) {
			
			pass.acquire();
			
			System.out.println("I am being worked");
			
			pass.release();
			
		} else {
			System.out.println("No pass !!");
			System.out.println(pass.availablePermits());
		}
		
	}
	
	public static void main(String[] args) {
		
		/*ExecutorService exec = Executors.newFixedThreadPool(10);
		
		for (int i = 0; i < 100; i++) {
			exec.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						testSema();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		} 
		
		exec.shutdown();*/
		
		Date date1 = new Date();
		System.out.println(date1);
		
			
	
		
	}

}
