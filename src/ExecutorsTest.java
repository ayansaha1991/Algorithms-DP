import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {

	public static void main(String[] args) {
		
		ExecutorService exe = Executors.newFixedThreadPool(2);
		exe.submit(new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println("Inventory, " + Thread.currentThread().getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		exe.submit(new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println("Location, " + Thread.currentThread().getName());
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		exe.shutdown();
	}

}
