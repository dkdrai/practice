package adtiya.verma.recursion.ibh;


import neetcode.tree.TreeNode;

public class HeighOfBinaryTree {

  static TreeNode root;

  public static void main(String ar[]) {
    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    //root.left.left.left = new TreeNode(5);
    System.out.println(height(root));
  }

  public static int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = height(root.left);
    int right = height(root.right);

    return 1 + Math.max(left, right);
  }

}
