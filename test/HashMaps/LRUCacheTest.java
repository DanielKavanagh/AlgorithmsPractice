package HashMaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LRUCacheTest {
    @Test
    public void basicCacheTest() {
        LRUCache cut = new LRUCache(2);
        cut.put(1,1);
        cut.put(2, 2);

        assertEquals(1, cut.get(1));
        assertEquals(2, cut.get(2));

        // Try getting a key that doesn't exist
        assertEquals(-1, cut.get(50));
    }

    @Test
    public void basicCacheEvictionTest() {
        LRUCache cut = new LRUCache(1);
        cut.put(1,1);
        assertEquals(1, cut.get(1));

        cut.put(2, 2);
        // Check that the previous node is no longer found
        assertEquals(-1, cut.get(1));
        // Check that the new node is found
        assertEquals(2, cut.get(2));
    }

    @Test
    public void cacheOrderingTest() {
        LRUCache cut = new LRUCache(2);
        cut.put(1,1);
        cut.put(2,2);

        cut.get(1);

        // Overflow the cache. Key 2 is LRU, make sure it is removed, not 1.
        cut.put(3, 3);
        assertEquals(-1, cut.get(2));
    }

    @Test
    public void remainingCapacityTest() {
        LRUCache cut = new LRUCache(2);

        cut.put(1, 1);
        assertEquals(1, cut.getRemainingCapacity());

        cut.put(1, 1);
        assertEquals(1, cut.getRemainingCapacity());
    }

    @Test
    public void getLeastRecentlyUsedTest() {
        LRUCache cut = new LRUCache(3);

        cut.put(1, 1);
        cut.put(2, 2);
        cut.put(3, 3);

        cut.get(1);

        assertEquals(2, cut.getLeastRecentlyUsed());
    }
}