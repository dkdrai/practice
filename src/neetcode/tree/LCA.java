package neetcode.tree;

public class LCA {

  public static void main(String ar[]) {
    LCA lca = new LCA();
    TreeNode root = new TreeNode(1);
    TreeNode p = new TreeNode(2);
    TreeNode q = new TreeNode(3);
    root.left = p;
    System.out.println(lca.lowest_common_ancestor(root, p, q));
    System.out.println(lca.lowest_common_ancestor(root, p, q).val);
  }

  private TreeNode ans;

  public LCA() {
    // Variable to store LCA node.
    this.ans = null;
  }

  private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

    // If reached the end of a branch, return false.
    if (currentNode == null) {
      return false;
    }

    // Left Recursion. If left recursion returns true, set left = 1 else 0
    int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

    // Right Recursion
    int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

    // If the current node is one of p or q
    int mid = (currentNode == p || currentNode == q) ? 1 : 0;

    // If any two of the flags left, right or mid become True
    if (mid + left + right >= 2) {
      this.ans = currentNode;
    }

    // Return true if any one of the three bool values is True.
    return (mid + left + right > 0);
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // Traverse the tree
    this.recurseTree(root, p, q);
    return this.ans;
  }


  public static TreeNode lowest_common_ancestor(TreeNode curr,TreeNode node1,TreeNode node2){

    if(curr==null){// if the curr node is NULL return NULL because we have reached the leaf
      return null;
    }else if(curr==node1 || curr==node2){// if the current node is either node1 or node2, return the current node.
      return curr;
    }
    TreeNode left_subtree = lowest_common_ancestor(curr.left,node1,node2);
    TreeNode right_subtree = lowest_common_ancestor(curr.right,node1,node2);

    if(left_subtree!=null && right_subtree!=null){// if the curr node has node1 and node2 in it's left subtree and right subtree. Return the current node
      return curr;
    }else if(left_subtree!=null){//return the left subtree
      return left_subtree;
    }else if (right_subtree != null){
      return right_subtree;//otherwise return the right subtree.
    }
    return null;
  }

}
