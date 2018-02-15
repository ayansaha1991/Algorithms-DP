import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Singleton {

	private static Singleton INSTANCE = null; 
	
	private Singleton() {
	}
	
	public static Singleton getInst() {
		
		if (INSTANCE == null) {
			synchronized (Singleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton();
				}
			}
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		service.execute(new Runnable() {
			
			@Override
			public void run() {
				
				for (int i = 0; i < 1000; i++) {
					System.out.println(Singleton.getInst());
				}
			}
		});
		
		service.shutdown();
		
	}
}
