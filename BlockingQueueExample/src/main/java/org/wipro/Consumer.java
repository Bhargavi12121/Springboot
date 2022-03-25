package org.wipro;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue<Integer> obj;
	  
    int taken = -1;
  
    public Consumer(BlockingQueue<Integer> obj)
    {
        this.obj = obj;
    }
  
    @Override 
    public void run()
    {
        while (true) {
            try {
                taken = obj.take();
                System.out.println("Consumed " + taken);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
