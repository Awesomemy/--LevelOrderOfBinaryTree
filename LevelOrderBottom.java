package test9;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
public class LevelOrderBottom {
    // 将层序遍历的结果反转即可(也可以在插入时选择头插)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        // 双端队列
        Deque<TreeNode> que = new LinkedList<>();

        if (root == null) {
            return list;
        }

        que.offerLast(root);
        while (!que.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();

            int levelSize = que.size();
            while (levelSize>0) {
                TreeNode peek = que.pollFirst();
                levelList.add(peek.val);

                if(peek.left!=null){
                    que.offerLast(peek.left);
                }
                if (peek.right!=null) {
                    que.offerLast(peek.right);
                }
                levelSize--;
            }
            list.add(levelList);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = list.size()-1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }
}
