
public class Contesters {
	public static void main(String [] args) {
		StringBuffer sb = new StringBuffer();
		
		ContesterThread c1 = new ContesterThread(sb);
		ContesterThread c2 = new ContesterThread(sb);
		
		c1.start();
		c2.start();
		
		try {
			c1.join();
			c2.join();
		}catch(InterruptedException e) {
			System.err.println("Managed exceptions are unforgivably stupid");
		}
		System.out.println(sb);
	}
}
