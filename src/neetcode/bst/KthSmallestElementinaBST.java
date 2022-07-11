package neetcode.bst;

//230. Kth Smallest Element in a BST
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementinaBST {

  public static void main(String ar[]){
    KthSmallestElementinaBST bst = new KthSmallestElementinaBST();
    TreeNode rooot = new TreeNode(3);
    rooot.left = new TreeNode(1);
    rooot.right = new TreeNode(4);
    rooot.left.right = new TreeNode(2);
    System.out.println(bst.kthSmallest(rooot, 2));
  }

  int value = 0;
  int count = 0;
  public int kthSmallest(TreeNode root, int k) {
    inorder(root, k);
    return value;
  }

  public void inorder(TreeNode root, int k){
    if(root == null){
      return;
    }

    inorder(root.left, k);
    count ++;
    if(k == count){
      value = root.val;
    }
    inorder(root.right, k );
  }
}
