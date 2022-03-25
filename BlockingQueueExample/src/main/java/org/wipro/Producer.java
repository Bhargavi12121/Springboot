package org.wipro;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	BlockingQueue<Integer> obj;
	  
    public Producer(BlockingQueue<Integer> obj)
    {
        this.obj = obj;
    }
  
    @Override 
    public void run()
    {
        for (int i = 1; i <= 4; i++) {
            try {
                obj.put(i);
                System.out.println("Produced " + i);
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
