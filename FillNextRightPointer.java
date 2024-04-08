package test9;

//填充每个结点的右指针

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class FillNextRightPointer {
    public Node1 connect(Node1 root) {
        Queue<Node1> que = new LinkedList<>();
        if (root == null) {
            return root;
        }
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            // 先单独把每层的第一个结点取出来
            Node1 cur = que.poll();
            if (cur.left != null) {
                que.offer(cur.left);
            }
            if (cur.right != null) {
                que.offer(cur.right);
            }

            for (int i = 1; i < size; i++) {
                Node1 next = que.poll();
                if (next.left != null) {
                    que.offer(next.left);
                }
                if (next.right != null) {
                    que.offer(next.right);
                }
                cur.next = next;
                cur = next;
            }
        }
        return root;
    }
}

class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {
    }

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
