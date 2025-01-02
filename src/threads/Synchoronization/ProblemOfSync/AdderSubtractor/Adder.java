package threads.Synchoronization.ProblemOfSync.AdderSubtractor;

public class Adder implements Runnable{
  Counter c;
  public Adder(Counter c){
    this.c = c;
  }
  @Override
  public void run() {
    for(int i=0;i<=100000;i++){
      c.val++;
    }
    System.out.println("Thread Adder ended "+Thread.currentThread().getName());
  }
}
