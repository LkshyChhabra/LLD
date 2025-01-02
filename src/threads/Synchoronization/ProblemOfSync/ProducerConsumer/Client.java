package threads.Synchoronization.ProblemOfSync.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Client {
  Queue<Object> queue = new LinkedList<>();
  int capacity = 5;

  public void client(){
    Producer producer = new Producer(queue, capacity);
    Consumer consumer = new Consumer(queue, capacity);

    for(int i=0;i<1000;i++){
      Thread t1 = new Thread(producer);
      Thread t2 = new Thread(consumer);
      t1.start();
      t2.start();
    }
  }
}



/* In producer Consumer Problem producer is adding and consumer is
removing the element from the queue, due to synchronization problem
consumer is removing object even if the queue is empty */