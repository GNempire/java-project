public class MyRunnable implements Runnable{
	private int first;
	private int last;
	private int result;
	private static int rrr;
	public MyRunnable(int first,int last){
		this.first=first;
		this.last=last;
		result=0;
	}
	public void run() {
		try {
			for(int i=first;i<=last;i++){
				result+=i;
			}
			rrr+=result;
			System.out.println(first+" ~ "+last+" = "+result);
		} catch(Exception e) {
		System.out.println(e);
		}
	}
	public static void main(String [] args) throws InterruptedException {
		MyRunnable myr1= new MyRunnable(1,25);
		MyRunnable myr2= new MyRunnable(26,50);
		MyRunnable myr3= new MyRunnable(51,75);
		MyRunnable myr4= new MyRunnable(76,100);
		Thread thr1 = new Thread(myr1);
		thr1.start();
		thr1.join();
		Thread thr2 = new Thread(myr2);
		thr2.start();
		thr2.join();
		Thread thr3 = new Thread(myr3);
		thr3.start();
		thr3.join();
		Thread thr4 = new Thread(myr4);
		thr4.start();
		thr4.join();
		System.out.println("total = "+rrr);
	}
}
