package test9;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//二叉树的层平均值
//给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
public class LevelAverageOfBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        if (root == null) {
            return result;
        }

        que.offerLast(root);
        while (!que.isEmpty()) {
            int len = que.size();
            double sum = 0.0;
            for (int i = 0; i < len; i++) {
                TreeNode node = que.pollFirst();
                sum += node.val;
                if (node.left != null) {
                    que.offerLast(node.left);
                }
                if (node.right != null) {
                    que.offerLast(node.right);
                }
            }
            result.add(sum / len);
        }
        return result;
    }
}
