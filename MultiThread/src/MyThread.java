
public class MyThread extends Thread{
	private  int x = 0;
	boolean valueReady = true;
	@Override
	public void run() {
		/*add1();
		add2();
		System.out.println(x);*/

	}

	/*private void add1() {
		int z = 2;
		addParam(z);	
	}

	private void add2() {
		int y = 3;
		addParam(y);
		
	}

	private synchronized void addParam(int i) {
		x = x + i;
		if(!valueReady) System.out.println(valueReady);
	}
	*/
	public void incr() {
		synchronized (this ) {
		x++;
		}
	}
	
	public synchronized void getX() {
		System.out.println(x);
	}
}


class HelloThread {
	public static void main(String[] args) {
		//System.out.print("hi!");
		Thread[] t = new Thread[5];

		for (int i = 0; i < 5; i++) {
			t[i] = new Thread(new MyThread());

		}
		for (int i = 0; i < 5; i++) {
			t[i].start();

		}
		
		
	}
}
