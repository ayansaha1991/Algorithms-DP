

public class ProducerConsumerExecutors {
	
	public static void main(String[] args) throws InterruptedException {
		
		final Processor proc = new Processor();
		
		Thread prodcuer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					proc.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread consumer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					proc.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		prodcuer.start();
		consumer.start();
		
		prodcuer.join();
		consumer.join();
		
	}
	
}
