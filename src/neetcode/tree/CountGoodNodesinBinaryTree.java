package neetcode.tree;

////1448. Count Good Nodes in Binary Tree
//https://leetcode.com/problems/count-good-nodes-in-binary-tree/

public class CountGoodNodesinBinaryTree {

  public int goodNodes(TreeNode root) {

    if(root == null){
      return 0;
    }
    return  getGood(root, Integer.MIN_VALUE);
  }

  public int getGood(TreeNode root, int max){
    if(root == null){
      return 0;
    }
    if(root.val >= max){
      return 1 + getGood(root.left, root.val) + getGood(root.right, root.val);
    }else{
      return getGood(root.left, max) + getGood(root.right, max);
    }
  }
}
