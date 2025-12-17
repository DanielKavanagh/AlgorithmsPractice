package GenericProblems;

import com.google.gson.FormattingStyle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {
    private static final Logger logger = LoggerFactory.getLogger(PairTest.class);
    private final Gson gson = new GsonBuilder()
            .setFormattingStyle(FormattingStyle.PRETTY)
            .serializeNulls()
            .create();

    @Test
    public void basicPair() {
        Pair<Integer, Integer> basicPair = new Pair<>(1, 2);

        assertEquals(1, basicPair.getFirst());
        assertEquals(2, basicPair.getSecond());
        assertInstanceOf(Integer.class, basicPair.getFirst());
        assertInstanceOf(Integer.class, basicPair.getSecond());

        logger.debug(gson.toJson(basicPair));
    }

    @Test
    public void complexPair() {
        Pair<Integer, Pair<String, Integer>> complexPair = new Pair<>();
        Pair<String, Integer> subPair = new Pair<>("test", 2);

        complexPair.setFirst(1);
        complexPair.setSecond(subPair);

        assertEquals(1, complexPair.getFirst());
        assertEquals(subPair, complexPair.getSecond());

        assertInstanceOf(Integer.class, complexPair.getFirst());
        assertInstanceOf(Pair.class, complexPair.getSecond());

    }
}