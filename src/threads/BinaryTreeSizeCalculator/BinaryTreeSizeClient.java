package threads.BinaryTreeSizeCalculator;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BinaryTreeSizeClient {
  public void client() throws ExecutionException, InterruptedException {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.right.right = new Node(31);
    root.right.right.right = new Node(32);
    root.left.left = new Node(4);
    root.left.left.left = new Node(5);
    root.left.left.left.left = new Node(6);
    root.left.left.left.left.left = new Node(7);

    ExecutorService es = Executors.newFixedThreadPool(10);

    BinaryTreeHeightCalculator bthc = new BinaryTreeHeightCalculator(root,es);
    Future<Integer> bthcPromise = es.submit(bthc);
    int treeHeight = bthcPromise.get();
    System.out.println(treeHeight);
  }

}
