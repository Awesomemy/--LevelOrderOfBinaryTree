package test9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树的层序遍历
public class LevelOrderTraversing {
    public List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //checkFun01(root,0);
        checkFun(root);
        return resList;
    }

    //借助队列
    public void checkFun(TreeNode node){
        if (node==null) {
            return;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = que.size();

            while (len>0) {
                TreeNode tempNode = que.poll();
                itemList.add(tempNode.val);
                if (tempNode.left!=null) {
                    que.offer(tempNode.left);
                }
                if (tempNode.right!=null) {
                    que.offer(tempNode.right);
                }
                len--;
            }

            resList.add(itemList);
        }
    }

    //DFS--递归方式
    //递归的方式并不是按层填充元素的,而是按子树(也就是深度优先)填充的,理解上不是很直观
//    public void checkFun01(TreeNode node, Integer deep) {
//        if (node == null) return;
//        deep++;
//
//        if (resList.size() < deep) {
//            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
//            List<Integer> item = new ArrayList<Integer>();
//            resList.add(item);
//        }
//        resList.get(deep - 1).add(node.val);
//
//        checkFun01(node.left, deep);
//        checkFun01(node.right, deep);
//    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){

    }
    TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}