package neetcode.tree;

//199. Binary Tree Right Side View
//https://leetcode.com/problems/binary-tree-right-side-view/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int count = queue.size();
      for (int i = 0; i < count; i++) {
        TreeNode node = queue.poll();
        if (i == 0) {
          result.add(node.val);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
        if (node.left != null) {
          queue.add(node.left);
        }
      }
    }
    return result;
  }
}
