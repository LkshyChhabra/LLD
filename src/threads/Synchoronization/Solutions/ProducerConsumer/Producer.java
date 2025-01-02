package threads.Synchoronization.Solutions.ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

  Queue<Object> queue;
  int capacity;
  Semaphore ps;
  Semaphore cs;
  String name;

  Producer(Queue<Object> queue, int capacity, Semaphore cs, Semaphore ps, String name) {
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
//        ps.acquire();

        queue.add(new Object());
        if(queue.size()>capacity)
        System.out.println(name + " has added the object and now queue has -> "+queue.size());
//        cs.release();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

    }

}
