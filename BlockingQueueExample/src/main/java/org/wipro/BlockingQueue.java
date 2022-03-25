package org.wipro;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueue {

	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> bqueue = new ArrayBlockingQueue<Integer>(4);
	        
		Producer p1 = new Producer(bqueue);
        Consumer c1 = new Consumer(bqueue);
  
        Thread pThread = new Thread(p1);
        Thread cThread = new Thread(c1);
  
     
        pThread.start();
        cThread.start();
	    }

	}


