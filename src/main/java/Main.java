import java.util.Scanner;
public class Main{
    public int findTilt(TreeNode root) {
        int res = 0;
        if(root == null){
            return res;
        }
        res = res + Math.abs(sum(root.left) - sum(root.right));
        res = res + findTilt(root.left) + findTilt(root.right);
        return res;
    }
    private int sum(TreeNode node){
        int res = 0;
        if(node == null){
            return 0;
        }
        res = res + node.val;
        if(node.left != null){
            res = res + sum(node.left);
        }
        if(node.right != null){
            res = res + sum(node.right);
        }
        return res;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        Main m = new Main();
        int res = m.findTilt(root);
        System.out.println(res);
    }
}
