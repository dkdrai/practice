package neetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

  public static void main(String ar[]){
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    System.out.println(levelOrder(root));
    System.out.println(levelOrderQueue(root));
  }

  //102. Binary Tree Level Order Traversal
  //https://leetcode.com/problems/binary-tree-level-order-traversal/
  public static List<List<Integer>> levelOrderQueue(TreeNode root) {
    List<List<Integer>> finalList = new ArrayList<>();
    if(root == null){
      return finalList;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      int count = queue.size();
      List<Integer> list = new ArrayList<>();
      for(int i =0; i<count; i++){
        TreeNode node = queue.poll();
        list.add(node.val);
        if(node.left!= null){
          queue.add(node.left);
        }
        if(node.right != null){
          queue.add(node.right);
        }
      }
      finalList.add(list);
    }
    return finalList;
  }


  //102. Binary Tree Level Order Traversal
  //https://leetcode.com/problems/binary-tree-level-order-traversal/
  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> finalList = new ArrayList<>();
    if (root == null) {
      return finalList;
    }
    int depth = maxDepth(root);
    for(int i =0; i<depth; i++){
      List<Integer> list = new ArrayList<>();
      levelOrderUtil(root, list, i);
      finalList.add(list);
    }
    return finalList;
  }

  public static void levelOrderUtil(TreeNode root, List<Integer> list, int level) {
    if(level == 0 && root != null){
      list.add(root.val);
      return;
    }
    if(root == null){
      return;
    }
    levelOrderUtil(root.left, list, level-1);
    levelOrderUtil(root.right, list, level-1);
  }

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}
