import java.util.LinkedList;

public class Processor {

	private LinkedList<Integer> list = new LinkedList<>();
	private final int LIMIT = 10;
	Object lock = new Object();

	int value = 0;

	public void producer() throws InterruptedException {

		while (true) {

			synchronized (lock) {

				while (list.size() == LIMIT) {
					lock.wait();
				}

				list.add(++value);
				System.out.println("Data added : " + value);
				lock.notify();
			}
		}

	}

	public void consumer() throws InterruptedException {

		while (true) {

			synchronized (lock) {

				while (list.size() == 0) {
					lock.wait();
				}

				Thread.sleep(2000);

				System.out.println(" Data removed : " + list.removeFirst());
				lock.notify();
			}
		}

	}
}
