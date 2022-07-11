package neetcode.tree;

public class BinaryTreeMaximumPathSum {

  //124. Binary Tree Maximum Path Sum
  //https://leetcode.com/problems/binary-tree-maximum-path-sum/
  public static void main(String arg[]) {
    TreeNode node = new TreeNode(-10);
    node.left = new TreeNode(9);
    node.right = new TreeNode(20);
    node.right.left = new TreeNode(15);
    node.right.right = new TreeNode(7);
    System.out.println(maxPathSum(node));
  }

  static int max = 0;

  public static int maxPathSum(TreeNode root) {
    maxUtil(root);
    return max;
  }

  public static int maxUtil(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftSum = Math.max(0, maxUtil(root.left));
    int rightSum = Math.max(0, maxUtil(root.right));
    max = Math.max(root.val + leftSum + rightSum, max);
    return Math.max(root.val + leftSum, root.val + rightSum);
  }

}
