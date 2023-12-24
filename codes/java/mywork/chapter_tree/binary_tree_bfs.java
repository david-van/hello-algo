/**
 * File: binary_tree_bfs.java
 * Created Time: 2022-11-25
 * Author: Krahets (krahets@163.com)
 */

package mywork.chapter_tree;

import utils.PrintUtil;
import utils.TreeNode;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class binary_tree_bfs {
    /* 层序遍历 */
    static List<Integer> levelOrder(TreeNode root) {
        //广度优先遍历通常借助“队列”来实现。
        // 队列遵循“先进先出”的规则，而广度优先遍历则遵循“逐层推进”的规则，两者背后的思想是一致的。实现代码如下：
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //进行数据的添加
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            result.add(node.val);
        }
        return result;
    }

    public static void main(String[] args) {
        /* 初始化二叉树 */
        // 这里借助了一个从数组直接生成二叉树的函数
        TreeNode root = TreeNode.listToTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println("\n初始化二叉树\n");
        PrintUtil.printTree(root);

        /* 层序遍历 */
        List<Integer> list = levelOrder(root);
        System.out.println("\n层序遍历的节点打印序列 = " + list);
    }
}
