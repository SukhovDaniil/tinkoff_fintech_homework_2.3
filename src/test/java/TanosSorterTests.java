import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TanosSorterTests {
    @Test
    public void allPositiveValueTest(){
        int[] inputArray = {325, 51, 6512, 0, 16548, 654, 2, 2, 789798};
        int[] expectedArray = {0, 2, 2, 51, 325, 654, 6512, 16548, 789798};

        TanosSorter.sort(inputArray, 0, inputArray.length - 1);

        Assertions.assertArrayEquals(expectedArray, inputArray);
    }

    /*@Test
    public void someNegativeValueTest(){
        int[] inputArray = {};
        int[] expectedArray = {};


    }

    @Test
    public void allNegativeValueTest(){
        int[] inputArray = {};
        int[] expectedArray = {};


    }

    @Test
    public void allSameValueTest(){
        int[] inputArray = {};
        int[] expectedArray = {};


    }

    @Test
    public void emptyArrayTest(){
        int[] inputArray = {};
        int[] expectedArray = {};


    }

    @Test
    public void arrayOfStringTest(){
        int[] inputArray = {};
        int[] expectedArray = {};


    }*/
}
