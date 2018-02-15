
public class MinQ<Key>  {
	
	private int N;
	private Key[] pq;
	
	public MinQ(int intialCapacity) {
		pq = (Key[]) new Object[intialCapacity + 1] ;
		N = 0;
	}
	
	public MinQ() {
		this(1);
	}
	
	public void insert(Key key) {
		pq[++N] = key;
		swim(N);
	}
	
	private void swim(int k) {
		
		while( k > 1 && greater(k/2, k)) {
			exch(k, k/2);
			k = k/2;
		}
	}

	private void exch(int k, int i) {

		int swap = (int) pq[k]; 
		pq[k] = pq[i];
	}

	private boolean greater(int i, int k) {
		return (i > k);
	}

	public static void main(String[] args) {
		
		int[] input = { 10, 20, 30 };
		MinQ<Integer> pq = new MinQ<Integer>();
		
		for (int key : input) {
			pq.insert(key);
		}
		
	}

	
}
