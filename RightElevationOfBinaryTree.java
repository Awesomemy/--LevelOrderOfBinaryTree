package test9;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//二叉树的右视图
//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
public class RightElevationOfBinaryTree {
    // 层序遍历的时候，判断是否遍历到单层的最后面的元素，如果是，就放进result数组中，随后返回result就可以了
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        if (root == null) {
            return list;
        }

        que.offerLast(root);
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = que.pollFirst();
                if (node.left != null) {
                    que.offerLast(node.left);
                }
                if (node.right != null) {
                    que.offerLast(node.right);
                }
                if (i == len - 1) {
                    list.add(node.val);
                }
            }
        }
        return list;
    }
}
