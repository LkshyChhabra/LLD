package threads.Synchoronization.Solutions.ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

  Queue<Object> queue;
  int capacity;
  Semaphore ps;
  Semaphore cs;
  String name;

  Consumer(Queue<Object> queue, int capacity, Semaphore cs, Semaphore ps, String name) {
    this.queue = queue;
    this.capacity = capacity;
    this.ps = ps;
    this.cs = cs;
    this.name = name;
  }

  @Override
  public void run() {

    try {
      Thread.sleep(100);
//      cs.acquire();

      queue.remove();
//      if(queue.size()>capacity)
//      System.out.println(name + " has removed the object and now queue has -> "+queue.size());
//      ps.release();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    }

}
