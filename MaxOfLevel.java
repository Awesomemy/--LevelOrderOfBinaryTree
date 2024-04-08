package test9;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//在每个树行中找最大值
//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
public class MaxOfLevel {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        if (root == null) {
            return result;
        }

        que.offerLast(root);
        while (!que.isEmpty()) {
            int len = que.size();
            int max = que.peekFirst().val;

            for (int i = 0; i < len; i++) {
                TreeNode node = que.pollFirst();
                if (max < node.val) {
                    max = node.val;
                }
                if (node.left != null) {
                    que.offerLast(node.left);
                }
                if (node.right != null) {
                    que.offerLast(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
