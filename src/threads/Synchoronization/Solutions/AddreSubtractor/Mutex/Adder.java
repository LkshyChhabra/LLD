package threads.Synchoronization.Solutions.AddreSubtractor.Mutex;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
  Counter c;
  Lock lock;
  public Adder(Counter c, Lock lock){
    this.c = c;
    this.lock = lock;
  }
  @Override
  public void run() {
    for(int i=0;i<=100000;i++){
      lock.lock();
      c.val++;
      lock.unlock();
    }
    System.out.println("Thread Adder ended "+Thread.currentThread().getName());
  }
}
