package neetcode.tree;

public class MaximumPathSum {

  public static void main(String arg[]) {
    TreeNode node = new TreeNode(-10);
    node.left = new TreeNode(9);


    node.right = new TreeNode(20);
    node.right.left = new TreeNode(15);
    node.right.right = new TreeNode(7);
    System.out.println(getMaxSumPath(node));
  }

  public static int getMaxSumPath(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return node.val + Math.max(getMaxSumPath(node.left), getMaxSumPath(node.right));
  }
}
