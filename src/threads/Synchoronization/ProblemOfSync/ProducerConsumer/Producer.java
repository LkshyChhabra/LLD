package threads.Synchoronization.ProblemOfSync.ProducerConsumer;

import java.util.Queue;

public class Producer implements Runnable {

  Queue<Object> queue;
  int capacity;

  Producer(Queue<Object> queue, int capacity) {
    this.queue = queue;
    this.capacity = capacity;
  }

  @Override
  public void run() {
    if(queue.size()>capacity){
      System.out.println(queue.size() + "-> Producer");
    }
    if(queue.size()<capacity){
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      queue.add(new Object());
    }
  }
}
