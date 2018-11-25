package tree;

import java.util.Stack;

public class BinaryTreeTraversal {

    /**
     *  测试一下二叉树后续遍历  左右根
     */
    /**
     * 后序遍历递归解法
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
     */
    public static void postorderTraversalRec(TreeNode root) {
        if (root == null)
            return;
        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }
    /**
     *  后序遍历迭代解法
     */
    public static void postorderTraversal(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack =new Stack<TreeNode>();  // 第一个stack用于添加node和它的左右孩子
        Stack<TreeNode> output =new Stack<TreeNode>(); // 第二个stack用于翻转第一个stack输出

        TreeNode cur = root;
        stack.push(cur);
        while(!stack.isEmpty()){  // 确保所有元素都被翻转转移到第二个stack
            cur = stack.pop();    // 把栈顶元素添加到第二个stack
            output.push(cur);

            if(cur.left!=null)    // 把栈顶元素的左孩子和右孩子分别添加入第一个stack
                stack.push(cur.left);
            if(cur.right!=null)
                stack.push(cur.right);
        }

        while(!output.isEmpty()){    // 遍历输出第二个stack，即为后序遍历
            cur = output.pop();
            System.out.print(cur.val+" ");
        }
    }



    public static void main(String[] arg){
            TreeNode node1 = new TreeNode("*");
            TreeNode node2 = new TreeNode("-");
            TreeNode node3 = new TreeNode("+");
            TreeNode node4 = new TreeNode("5");
            TreeNode node5 = new TreeNode("3");
            TreeNode node6 = new TreeNode("4");

            node1.left = node2;
            node1.right = node3;
            node2.left = node4;
            node3.left = node5;
            node3.right = node6;
            postorderTraversalRec(node1);

    }

}


// 建立二叉树节点类
class TreeNode{
    String val;
    TreeNode left;
    TreeNode right;
    public TreeNode( String val){
        this.val = val;
    }
}

