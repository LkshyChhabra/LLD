package threads.BinaryTreeSizeCalculator;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class BinaryTreeHeightCalculator implements Callable<Integer> {
  Node root;
  ExecutorService es;
  public BinaryTreeHeightCalculator(Node root, ExecutorService es){
    this.root = root;
    this.es = es;
  }
  @Override
  public Integer call() throws Exception {
    if(root==null)return 0;
    if(root.left == null && root.right == null)return 1;
    BinaryTreeHeightCalculator left = new BinaryTreeHeightCalculator(root.left, es);
    BinaryTreeHeightCalculator right = new BinaryTreeHeightCalculator(root.right, es);
    Future<Integer> leftHeightPromise = es.submit(left);
    Future<Integer> rightHeightPromise = es.submit(right);

    int leftHeight = leftHeightPromise.get();
    int rightHeight = rightHeightPromise.get();

    return 1 + Math.max(leftHeight, rightHeight);
  }
}
