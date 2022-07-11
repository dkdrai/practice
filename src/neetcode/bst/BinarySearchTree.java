package neetcode.bst;

class TreeNode {

  TreeNode left, right;
  int val;

  public TreeNode(int val) {
    this.val = val;
  }

  public static void main(String args[]) {
    TreeNode treeNode = new TreeNode(10);
    treeNode.add(5);
    treeNode.add(15);
    treeNode.add(25);
    treeNode.add(7);
    treeNode.left.left = new TreeNode(50);
    treeNode.printInOrder();
    System.out.println(treeNode.find(8));
    System.out.println(treeNode.isBst(treeNode));
  }

  public void printInOrder() {
    if (this.left != null) {
      this.left.printInOrder();
    }
    System.out.println(this.val);
    if (this.right != null) {
      this.right.printInOrder();
    }
  }

  public void add(int value) {
    if (value < this.val) {
      if (this.left == null) {
        TreeNode node = new TreeNode(value);
        this.left = node;
      } else {
        this.left.add(value);
      }
    } else {
      if (this.right == null) {
        TreeNode node = new TreeNode(value);
        this.right = node;
      } else {
        this.right.add(value);
      }
    }
  }


  public boolean find(int value) {
    if (value == this.val) {
      return true;
    }
    if (value < this.val) {
      if (this.left == null) {
        return false;
      } else {
        return this.left.find(value);
      }
    } else {
      if (this.right == null) {
        return false;
      } else {
        return this.right.find(value);
      }
    }
  }

  public boolean isBst(TreeNode node){
    return isBstUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBstUtil(TreeNode node, int minvalue, int maxvalue) {
    if(node == null){
      return true;
    }
    if(node.val < minvalue || node.val > maxvalue){
      return false;
    }
    return isBstUtil(node.left, minvalue, node.val -1) && isBstUtil(node.right, node.val+1, maxvalue);
  }


}
