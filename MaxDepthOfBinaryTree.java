package test9;

import java.util.Deque;
import java.util.LinkedList;

//二叉树的最大深度
//给定一个二叉树 root ，返回其最大深度(其实就是二叉树的层数)。
//二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        que.offer(root);

        int depth = 0;
        while (!que.isEmpty()) {
            depth++;
            int len = que.size();

            for (int i = 0; i < len; i++) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
        }
        return depth;
    }
}
