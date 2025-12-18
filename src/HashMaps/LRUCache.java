package HashMaps;

import StringProblems.ValidAnagram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static final Logger logger = LoggerFactory.getLogger(LRUCache.class);

    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1, -1);

    int capacity;
    Map<Integer, ListNode> nodeMap = new HashMap<>();

    LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Add a specified node to the start of the list (after the dummy head node)
     * */
    private void addNode(ListNode newNode) {
        logger.debug("Adding list node: {}", newNode.toString());

        ListNode temp = head.next;
        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;
    }

    private void deleteNode(ListNode node) {
        logger.debug("Removing list node: {}", node.toString());
        ListNode prev = node.prev;
        ListNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        logger.debug("Getting key: {}", key);

        if (nodeMap.containsKey(key)) {
            ListNode node = nodeMap.get(key);

            logger.debug("Found node: {}", node.toString());

            // Remove then add the node to make it MRU
            nodeMap.remove(key);
            deleteNode(node);

            addNode(node);
            nodeMap.put(key, head.next);

            return node.val;
        }

        logger.debug("No node found for key: {}", key);

        return -1;
    }

    public void put(int key, int val) {
        logger.debug("Putting key: {}, with value: {}", key, val);

        if (nodeMap.containsKey(key)) {
            ListNode node = nodeMap.get(key);

            nodeMap.remove(key);
            deleteNode(node);
        }

        if (nodeMap.size() == capacity) {
            logger.debug("At cache capacity, removing LRU key: {}", tail.prev.toString());
            nodeMap.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new ListNode(key, val));
        nodeMap.put(key, head.next);
    }

    public int getRemainingCapacity() {
        return capacity - nodeMap.size();
    }

    public int getLeastRecentlyUsed() {
        return tail.prev.key;
    }
}

class ListNode {
    int key;
    int val;

    ListNode prev;
    ListNode next;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{key=" + key + ", val=" + val + "}";
    }
}
