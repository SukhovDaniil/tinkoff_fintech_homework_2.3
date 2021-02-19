import java.util.Arrays;

public class TanosSorter {
    public static double averageOfArray(int[] inputArray) {
        double result = 0;

        if (inputArray.length > 0) {
            for (int j : inputArray) {
                result += j;
            }

            result = result / inputArray.length;
            return result;
        } else {
            return 0;
        }
    }

    public static boolean allSame(int[] inputArray, int startIndex, int endIndex) {
        if (inputArray != null) {
            for (int i = startIndex; i <= endIndex - 1; i++) {
                if (inputArray[i] != inputArray[i + 1]) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void sort(int[] inputArray, int startIndex, int endIndex) {
        int arrayRangeLength = ((endIndex - startIndex) + 1);

        if (arrayRangeLength > 1 && !allSame(inputArray, startIndex, endIndex)) {
            int[] bufferArray = Arrays.copyOfRange(inputArray, startIndex, endIndex + 1);
            int countFromStart = startIndex;
            int countFromEnd = endIndex;
            double average = averageOfArray(bufferArray);

            for (int i : bufferArray) {
                if (i > average) {
                    inputArray[countFromEnd] = i;
                    countFromEnd--;
                } else {
                    inputArray[countFromStart] = i;
                    countFromStart++;
                }
            }
            sort(inputArray, startIndex, --countFromStart);
            sort(inputArray, ++countFromEnd, endIndex);
        }
    }

    public static void main(String[] args) {
        int[] array = {34, 5, 456, -3, 452, 0, 0, 5443, 7, 43, 23, 5, 35, 900, 6, 78, 0, 454, 35, 67, 89, -78946, 898, 76};
        sort(array, 0, array.length - 1);

        for (int i : array) {
            System.out.print(i + " ");
        }

    }
}


