public class BadCounter {
    private int count = 0;
    /* invariant: count records the number of times nextCount() is invoked */
    public   synchronized  int nextCount() { // uncomment to fix
	int c = count;
	 Thread.yield();  // uncomment to increase chance of failure
	c = c + 1;
	count = c;
	return count;
    }
    public static void main(String args[]) throws InterruptedException {
	final BadCounter c = new BadCounter();
	Runnable r = new Runnable () {
		public void run() {
		    c.nextCount();
		}
	    };
	for (int i = 0; i<10000; i++) {
	    int curr = c.count;
	    Thread t1 = new Thread(r);
	    Thread t2 = new Thread(r);
	    t1.start();
	    t2.start();
	    t1.join();
	    t2.join();
	    if (curr+2 != c.count) {
		System.out.println("Failed!");
		System.out.println("curr is " + curr + " c.count is " + c.count);
		System.exit(1);
	    }
	}
	System.out.println("OK");
	System.out.println(" c.count is " + c.count);
    }
}
		
