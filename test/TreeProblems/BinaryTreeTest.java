package TreeProblems;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {

    BinaryTree cut = new BinaryTree();

    @Test
    public void testMaximumDepth() {
        assertEquals(4, cut.maximumDepth(basicBinaryTree()));
    }

    @Test
    public void testMinimumDepth() {
        assertEquals(2, cut.minimumDepth(basicBinaryTree()));
    }

    @Test
    public void testLevelOrderTraversal() {
        assertEquals(levelOrderResult(), cut.printLevelOrder(basicBinaryTree()));
    }

    @Test
    public void testNullTreeLevelOrder() {
        assertEquals(Collections.emptyList(), cut.printLevelOrder(null));
    }

    private TreeNode basicBinaryTree() {
        return new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(5, null, null),
                        new TreeNode(6, null, null)),
                new TreeNode(3,
                        new TreeNode(4,
                                new TreeNode(7,
                                        null,
                                        null),
                                null),
                        null)
        );
    }

    private List<List<Integer>> levelOrderResult() {
        return
                List.of(
                        List.of(1),
                        List.of(2, 3),
                        List.of(5, 6, 4),
                        List.of(7)
                );
    }
}