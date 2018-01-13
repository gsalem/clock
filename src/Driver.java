import java.util.Scanner;
public class Driver {
	
	public static void main(String [] args) {
		//System.out.println(System.currentTimeMillis()/1000);
		Clock m = new Clock(19,59,57);
		for (int i = 0; i < 5000; i++) {
		try {
			System.out.println(m);
			Thread.sleep(1000);
			m.incrementSeconds();
		}
		catch (Exception e) {
			
		}
		}
	
		m.setHours(10);
		System.out.println(m.getHours());
		System.out.println(m.getMinutes());
		System.out.println(m.getSeconds());
	}
}
	