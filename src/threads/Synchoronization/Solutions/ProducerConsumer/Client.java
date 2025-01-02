package threads.Synchoronization.Solutions.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class Client {
  public void client(){
    Queue<Object> queue = new ArrayBlockingQueue<>(10);
    int capacity = 5;
    Semaphore ps = new Semaphore(5);
    Semaphore cs = new Semaphore(0);
    for(int i=0;i<100000;i++){
      Producer producer = new Producer(queue, capacity, cs, ps, "p"+i);
      Thread t1 = new Thread(producer);
      t1.start();
      Consumer consumer = new Consumer(queue, capacity, cs, ps, "c"+i);
      Thread t2 = new Thread(consumer);
      t2.start();
    }
//    for(int i=0;i<1000;i++){
////      Consumer consumer = new Consumer(queue, capacity, cs, ps, "c"+i);
////      Thread t2 = new Thread(consumer);
////      t2.start();
//    }

  }
}



/* In producer Consumer Problem producer is adding and consumer is
removing the element from the queue, due to synchronization problem
consumer is removing object even if the queue is empty */