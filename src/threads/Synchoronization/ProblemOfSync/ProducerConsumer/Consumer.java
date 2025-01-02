package threads.Synchoronization.ProblemOfSync.ProducerConsumer;

import java.util.Queue;

public class Consumer implements Runnable {

  Queue<Object> queue;
  int capacity;

  Consumer(Queue<Object> queue, int capacity) {
    this.queue = queue;
    this.capacity = capacity;
  }

  @Override
  public void run() {
    if(queue.size()>capacity || queue.size()<0){
      System.out.println(queue.size() + "-> Consumer");
    }

    if (queue.size() > 0) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      queue.remove();
    }
  }
}
