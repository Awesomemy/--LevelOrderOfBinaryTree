package test9;

import java.util.Deque;
import java.util.LinkedList;

//二叉树的最小深度
//最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//说明：叶子节点是指没有子节点的节点。
public class MinDepthOfBinaryTree {
    //思路也是记录深度,只不过判断在第一次遇到叶子结点时就要返回结果
    public int minDepth(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        if (root==null) {
            return 0;
        }
        que.offer(root);

        int depth = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            depth++;

            for (int i = 0; i < len; i++) {
                TreeNode node = que.poll();
                if (node.left==null && node.right==null) {
                    return depth;
                }
                if (node.left!=null) {
                    que.offer(node.left);
                }
                if (node.right!=null) {
                    que.offer(node.right);
                }
            }
        }
        return depth;
    }
}
