package TreeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    public int maximumDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maximumDepth(root.left);
        int right = maximumDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public int minimumDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minimumDepth(root.left);
        int right = minimumDepth(root.right);

        return Math.min(left, right) + 1;
    }

    public List<List<Integer>> printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> order = new ArrayList<>();

        if (root == null) {
            return order;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // Define a queue size because we're adding the next level's nodes
            // to the queue during the for loop.
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);

                // Checks if the left/right children exist, if so we add them to the queue
                // for the next time we execute the for loop.
                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            order.add(level);
        }

        return order;
    }
}
