import java.util.concurrent.CountDownLatch;


public class CountDownLatchTest {

	private CountDownLatch latch;

	public CountDownLatchTest() {
		this.latch = new CountDownLatch(2);
	}

	public void test() throws InterruptedException {

		System.out.println("Started !");
		latch.await();
		System.out.println("Came back to life");
	}

	public void releaseLatch() throws InterruptedException {

		latch.countDown();
		Thread.sleep(2000);
		latch.countDown();
		Thread.sleep(2000);
		System.out.println("Released");
	}

	public static void main(String[] args) throws InterruptedException {

		final CountDownLatchTest test = new CountDownLatchTest();
		
		
		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					test.test();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					test.releaseLatch();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		th1.start();
		th2.start();
		
		
		th1.join();
		th2.join();
		

	}
}
