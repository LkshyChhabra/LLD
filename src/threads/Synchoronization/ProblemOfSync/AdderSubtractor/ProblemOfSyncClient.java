package threads.Synchoronization.ProblemOfSync.AdderSubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProblemOfSyncClient {
//  public static void main(String[] args) throws InterruptedException {
public void client() throws InterruptedException {
    Counter c = new Counter();
    Adder adder = new Adder(c);
    Subtractor subtractor = new Subtractor(c);
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
  }

}
