package threads.Synchoronization.Solutions.AddreSubtractor.Mutex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexClient {
//  public static void main(String[] args) throws InterruptedException {
public void client() throws InterruptedException {
    Counter c = new Counter();
    Lock lock = new ReentrantLock();
    Adder adder = new Adder(c, lock);
    Subtractor subtractor = new Subtractor(c, lock);
    ExecutorService es = Executors.newFixedThreadPool(2);
    es.submit(adder);
    es.submit(subtractor);
//    Thread t1 = new Thread(adder);
//
//    Thread t2 = new Thread(subtractor);
//    t1.start();
//    t2.start();

//    t1.join();
//    t2.join();

    Thread.sleep(1000);
    System.out.println(c.val);
    es.shutdown();
  }

}
