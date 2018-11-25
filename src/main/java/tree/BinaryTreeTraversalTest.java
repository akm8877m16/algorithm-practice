package tree;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class BinaryTreeTraversalTest {

    /**
     *  测试一下二叉树后续遍历  左右根
     */
    /**
     * 后序遍历递归解法
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
     */
    public static void postorderTraversalRec(TreeNode root) {
       if(root == null) {
           return;
       }
        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.println(root.val);
    }
    /**
     *  后序遍历迭代解法
     */
    public static void postorderTraversal(TreeNode root){

        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            output.add(temp);
            if(temp.left != null){
                stack.push(temp.left);
            }
            if(temp.right != null){
                stack.push(temp.right);
            }
        }
        while(!output.isEmpty()){
            System.out.println(output.pop().val);
        }


    }



    public static void main(String[] arg){
        TreeNode node1 = new TreeNode("a");
        TreeNode node2 = new TreeNode("b");
        TreeNode node3 = new TreeNode("c");
        TreeNode node4 = new TreeNode("d");
        TreeNode node5 = new TreeNode("e");
        TreeNode node6 = new TreeNode("f");

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        postorderTraversalRec(node1);
        System.out.println("next");
        postorderTraversal(node1);

    }

}


