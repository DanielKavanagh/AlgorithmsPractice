package GenericProblems;

import com.google.gson.FormattingStyle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

class BoxTest {
    private static final Logger logger = LoggerFactory.getLogger(BoxTest.class);
    private final Gson gson = new GsonBuilder()
            .setFormattingStyle(FormattingStyle.PRETTY)
            .serializeNulls()
            .create();

    Box<Integer> boxInt = new Box<>();
    Box<ComplexTestClass<String, List<Integer>>> boxComplex = new Box<>();
    Box<BasicTestClass> boxBasic = new Box<>();

    @Test
    public void basicBox() {
        boxInt.set(100);
        logger.info(gson.toJson(boxInt));
    }

    @Test
    public void complexBox() {
        boxComplex.set(new ComplexTestClass<>(10,
                new Box<>("Hello"),
                new Box<>(List.of(1,2,3)
                )));

        logger.info(gson.toJson(boxComplex));
    }

    @Test
    public void simpleBox() {
        boxBasic.set(new BasicTestClass(
                10,
                "Hello",
                new int[]{1,2}
        ));

        logger.info(gson.toJson(boxBasic));
    }
}

class BasicTestClass {
    private Integer property1;
    private String property2;
    private int[] property3;

    public BasicTestClass(Integer property1, String property2, int[] property3 ) {
        this.property1 = property1;
        this.property2 = property2;
        this.property3 = property3;
    }
}

class ComplexTestClass<T1, T2> {
    private Integer property1;
    private Box<T1> innerBox1;
    private Box<T2> innerBox2;

    public ComplexTestClass(Integer property1, Box<T1> innerBox1, Box<T2> innerBox2) {
        this.property1 = property1;
        this.innerBox1 = innerBox1;
        this.innerBox2 = innerBox2;
    }
}