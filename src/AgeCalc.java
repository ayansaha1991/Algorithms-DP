
public class AgeCalc {

	
	public static void main(String[] args) {
		
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ;
		
		int d1 = 23, d2 = 25;
		int m1 = 1, m2 = 1;
		int y1 = 2018, y2 = 2017;
		
		int dd = d1 - d2 ;
		int dm = m1 - m2 ;
		int dy = y1 - y2 ;
		
		if (dm < 0) {
			dy = dy - 1;
			dm = 12 - (m2 - m1) ;
		} else if (dm == 0) {
			
		}
		
		if (dd < 0) {
			dm = dm - 1;
			if (dm < 0) {
				dm = 0;
				dy = dy -1;
			}
			
			int prevMon = dm -1;
			
			if (prevMon < 1) {
				prevMon = 12;
			}
			
			dd = (days[prevMon] - d2) + d1; 
		} 
		
		System.out.println("Years : " + dy + " Months : " + dm + " Days : " + dd);
		
	}
}
