import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public class Solution {
      List<List<Integer>> result = new ArrayList();
      public List<List<Integer>> levelOrder(TreeNode root) {
          Queue<TreeNode> queue = new LinkedList<>();
          if(root == null){
              return null;
          }
          queue.add(root);
          while(!queue.isEmpty()){
              int len = queue.size();
              List<Integer> list = new ArrayList<Integer>();
              for(int i = 0 ; i < len ; i ++){
                  TreeNode cur = queue.remove();
                  list.add(cur.val);
                  if(cur.left != null){
                      queue.add(root.left);
                  }
                  if(cur.right != null){
                      queue.add(root.right);
                  }
              }
              result.add(list);

          }
          return result;
      }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution s = new Solution();
        List<List<Integer>> res = s.levelOrder(root);
        System.out.println(res);
    }
}