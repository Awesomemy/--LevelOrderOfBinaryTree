package test9;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//N叉树的层序遍历
//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
//树的序列化输入是用层序遍历，每组子节点都由 null 值分隔。
public class LevelOrderOfNTree {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        Deque<Node> que = new LinkedList<>();

        if (root == null) {
            return resList;
        }

        que.offerLast(root);
        while (!que.isEmpty()) {
            int len = que.size();
            List<Integer> itemList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Node node = que.pollFirst();
                itemList.add(node.val);
                // 如果子结点列表为null或者为空就跳过本次循环
                if (node.children == null || node.children.size() == 0) {
                    continue;
                }
                for (Node childNode : node.children) {
                    que.offerLast(childNode);
                }
            }
            resList.add(itemList);
        }
        return resList;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}