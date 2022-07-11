package neetcode.tree;

public class BalancedTree {

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int lheight = maxDepth(root.left);
    int rheight = maxDepth(root.right);
    return Math.abs(lheight - rheight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
  }

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return -1;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}