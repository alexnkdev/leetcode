object Solution {

  def findTilt(root: TreeNode): Int = {
    findNodeTilt(root) + findNodeTilt(root.left) + findNodeTilt(root.right)  
  }

  def findNodeTilt(root: TreeNode): Int = {
    root match {
      case null => 0
      case node => Math.abs(sumValues(node.left) - sumValues(node.right))
    }
  }

  def sumValues(root: TreeNode): Int = {
    root match {
      case null => 0
      case node => node.value
    }
  }

}
