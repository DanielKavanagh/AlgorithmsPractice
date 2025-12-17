package HashMaps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LRUCacheTest {
    @Test
    public void basicCacheTest() {
        LRUCache cut = new LRUCache(2);
        cut.put(1,1);
        cut.put(2, 2);

        Assertions.assertEquals(1, cut.get(1));
        Assertions.assertEquals(2, cut.get(2));

        // Try getting a key that doesn't exist
        Assertions.assertEquals(-1, cut.get(50));
    }

    @Test
    public void basicCacheEvictionTest() {
        LRUCache cut = new LRUCache(1);
        cut.put(1,1);
        Assertions.assertEquals(1, cut.get(1));

        cut.put(2, 2);
        // Check that the previous node is no longer found
        Assertions.assertEquals(-1, cut.get(1));
        // Check that the new node is found
        Assertions.assertEquals(2, cut.get(2));
    }

    @Test
    public void cacheOrderingTest() {
        LRUCache cut = new LRUCache(2);
        cut.put(1,1);
        cut.put(2,2);

        cut.get(1);

        // Overflow the cache. Key 2 is LRU, make sure it is removed, not 1.
        cut.put(3, 3);
        Assertions.assertEquals(-1, cut.get(2));
    }
}