package neetcode.tree;

public class Trees {

  public static void main(String args[]) {
    TreeNode depthTree = new TreeNode(1);
    depthTree.left = new TreeNode(2);
    System.out.println(diameterOfBinaryTree(depthTree));
  }

  //226. Invert Binary Tree
  //https://leetcode.com/problems/invert-binary-tree/description/
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    invertTree(root.left);
    invertTree(root.right);
    return root;
  }

  //104. Maximum Depth of Binary Tree
  //https://leetcode.com/problems/maximum-depth-of-binary-tree/
  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return -1;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

  //543. Diameter of Binary Tree
  //https://leetcode.com/problems/diameter-of-binary-tree/
  static int max = 0;

  public static int diameterOfBinaryTree(TreeNode root) {
    depthUtil(root);
    return max;
  }

  public static int depthUtil(TreeNode root) {
    if (root == null) {
      return -1;
    }
    int lheight = depthUtil(root.left);
    int rheight = depthUtil(root.right);
    max = Math.max(max, 2 + lheight + rheight);
    return 1 + Math.max(lheight, rheight);
  }

  //110. Balanced Binary Tree
  //https://leetcode.com/problems/balanced-binary-tree/
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int lheight = maxDepth(root.left);
    int rheight = maxDepth(root.right);
    return Math.abs(lheight - rheight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
  }

  //100. Same Tree
  //https://leetcode.com/problems/same-tree/
  public boolean isSameTree(TreeNode a, TreeNode b) {
    if (a == null && b == null) {
      return true;
    }
    if (a != null && b != null) {
      return (a.val == b.val
          && isSameTree(a.left, b.left)
          && isSameTree(a.right, b.right));
    }
    return false;
  }

  //572. Subtree of Another Tree

  //https://leetcode.com/problems/subtree-of-another-tree/
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) return false;
    if (isSame(s, t)) return true;
    return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  private boolean isSame(TreeNode s, TreeNode t) {
    if (s == null && t == null) return true;
    if (s == null || t == null) return false;

    if (s.val != t.val) return false;

    return isSame(s.left, t.left) && isSame(s.right, t.right);
  }


  //236. Lowest Common Ancestor of a Binary Tree
  //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || root == p || root == q){
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if( left != null && right != null){
      return root;
    }
    if(left != null){
      return left;
    }else{
      return right;
    }
  }

}
