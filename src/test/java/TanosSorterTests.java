import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TanosSorterTests {
    @Test
    public void allPositiveValueTest() {
        int[] inputArray = {325, 51, 6512, 0, 16548, 654, 2, 2, 789798};
        int[] expectedArray = {0, 2, 2, 51, 325, 654, 6512, 16548, 789798};

        TanosSorter.sort(inputArray, 0, inputArray.length);

        Assertions.assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void someNegativeValueTest() {
        int[] inputArray = {15, 0, -97, 6542, -3, 89412, 5, 2, 2};
        int[] expectedArray = {-97, -3, 0, 2, 2, 5, 15, 6542, 89412};

        TanosSorter.sort(inputArray, 0, inputArray.length);

        Assertions.assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void allNegativeValueTest() {
        int[] inputArray = {-1, -798, -2, -45, -354984, -1000, -45};
        int[] expectedArray = {-354984, -1000, -798, -45, -45, -2, -1};

        TanosSorter.sort(inputArray, 0, inputArray.length);

        Assertions.assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void allSameValueTest() {
        int[] inputArray = {15, 15, 15, 15, 15, 15};
        int[] expectedArray = {15, 15, 15, 15, 15, 15};

        TanosSorter.sort(inputArray, 0, inputArray.length);

        Assertions.assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void emptyArrayTest() {
        int[] inputArray = {};
        int[] expectedArray = {};

        TanosSorter.sort(inputArray, 0, inputArray.length);

        Assertions.assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void oneMaxIntValue() {
        int[] inputArray = {98, 654, 0, 12, 7987, 5, 32, 2147483647, 98, 0, 1054};
        int[] expectedArray = {0, 0, 5, 12, 32, 98, 98, 654, 1054, 7987, 2147483647};

        TanosSorter.sort(inputArray, 0, inputArray.length);

        Assertions.assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void oneMinIntValue() {
        int[] inputArray = {-98, -654, 0, 12, 7987, 5, 32, -2147483648, 98, 0, 1054};
        int[] expectedArray = {-2147483648, -654, -98, 0, 0, 5, 12, 32, 98, 1054, 7987};

        TanosSorter.sort(inputArray, 0, inputArray.length);

        Assertions.assertArrayEquals(expectedArray, inputArray);
    }
}
