package tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeBasicOperation {

    /**
     *  求二叉树中的节点个数迭代解法O(n)：基本思想同LevelOrderTraversal，
     *  即用一个Queue，在Java里面可以用LinkedList来模拟
     *  只是remove一个， count ++;
     *  但这个写法的好处是可以知道第K层有哪些节点
     *  所以如果需要知道K层的节点，而不仅仅是个数，那么可以使用下面的用法。
     */
    public static int getNodeNum(TreeNode root){

        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        int count = 0;
        while(!list.isEmpty()){
            TreeNode node = list.remove();
            count ++;
            if(node.left != null){
                list.add(node.left);
            }
            if(node.right != null){
                list.add(node.right);
            }
        }
        return count;

    }

    /**
     * 思路和上面的是一样的，区别在于，其实不用用两个list,一个就可以，因为判断使用的无非是两个
     * list的长度而已， 所以用两个整数技术，就可以减少避免空间消耗
     * @param root
     * @return
     */
    public static int getNodeNumStandard(TreeNode root){

        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        int depth = 0;
        int currentLevelNum = 1; //当前层节点个数
        int nextLevelNum = 0;    //下一层节点个数

        while(!list.isEmpty()){
            TreeNode node = list.remove();
            currentLevelNum--;
            if(node.left != null){
                list.add(node.left);
                nextLevelNum++;
            }
            if(node.right != null){
                list.add(node.right);
                nextLevelNum++;
            }
            if(currentLevelNum == 0){
                depth++;
                currentLevelNum = nextLevelNum;
                nextLevelNum = 0;
            }
        }
        return depth;
    }

    /**
     *  求二叉树第K层的节点个数   迭代解法：
     *  同getDepth的迭代解法
     *  这里K 从0开始算，如果从1开始算相当于下面解法算k-1层
     */
    public static int getNodeNumKthLevel(TreeNode root, int k){
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        int depth = 0;
        int currentLevelNum = 1;
        int nextLevelNum = 0;
        int count = 0;

        while(!list.isEmpty()){
            TreeNode node = list.remove();
            currentLevelNum--;
            count++;
            if(node.left != null){
                list.add(node.left);
                nextLevelNum++;
            }
            if(node.right != null){
                list.add(node.right);
                nextLevelNum++;
            }
            if(currentLevelNum ==0){
                if(depth == k){
                    return count;
                }
                depth++;
                currentLevelNum = nextLevelNum;
                nextLevelNum = 0;
                count = 0;
            }
        }
        return -1;
    }

    /**
     *  求二叉树中叶子节点的个数（迭代）
     *  还是基于Level order traversal
     */
    public static int getNodeNumLeaf(TreeNode root) {
        return 0;
    }

    /**
     * 判断两个二叉树是否相等
     * @param root1
     * @param root2
     * @return
     */
    public static Boolean isSame(TreeNode root1,TreeNode root2){
        return  true;
    }


        /**
         * 获取二叉树深度   答案不大看的懂，但意思明白，所以以自己可以理解的方式实现
         * 主要难度在于理清楚什么时候分层需要层数加一
         * 利用两个队列来实现
         * @param root
         * @return
         */
    public static int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int depth = 0;
        LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
        LinkedList<TreeNode> temp;
        currentLevel.add(root);
        while(!(currentLevel.size() == 0 && nextLevel.size() ==0)){
            TreeNode node = currentLevel.remove();
            if(node.left != null){
                nextLevel.add(node.left);
            }
            if(node.right != null){
                nextLevel.add(node.right);
            }
            if(currentLevel.size() == 0){
                depth ++;              //当前层遍历完成，深度加1
                temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;

            }
        }
        return depth;
    }

    public static void main(String[] arg){
        TreeNode node1 = new TreeNode("a");
        TreeNode node2 = new TreeNode("b");
        TreeNode node3 = new TreeNode("c");
        TreeNode node4 = new TreeNode("d");
        TreeNode node5 = new TreeNode("e");
        TreeNode node6 = new TreeNode("f");
        TreeNode node7 = new TreeNode("g");
        TreeNode node8 = new TreeNode("h");

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node6.right = node7;
        node7.right = node8;

        int result = getDepth(node1);
        System.out.println(result);
        int result2 = getNodeNumStandard(node1);
        System.out.println(result2);
        //System.out.println("next");
        //int count = getNodeNum(node1);
        System.out.println("next");
        int count =  getNodeNumKthLevel(node1,1);
        System.out.println(count);
    }

}
