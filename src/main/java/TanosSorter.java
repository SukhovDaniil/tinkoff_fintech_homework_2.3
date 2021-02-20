import java.util.Arrays;

public class TanosSorter {
    /** Вставляет в диапозон главного массива значения из диапазона
     * массива-донора
     * стартовые индексы - включительно
     * конечные - не включительно
     */
    public static void insertArray(int[] mainArray, int mainStartIndex,
                                   int mainEndIndex, int[] donorArray,
                                   int donorStartIndex, int donorEndIndex) {
        /*Условия ненулевого основного массива и ненулевого диапазона,
        * в который будут вставляться значения*/
        boolean mainArrayNotNull = mainArray.length > 0;
        boolean mainRangeNotNull = ((mainEndIndex - mainStartIndex) + 1) > 0;

        /*Условия ненулевого массива-донора и ненулевого диапазона
        * вставляемых значений*/
        boolean donorArrayNotNull = donorArray.length > 0;
        boolean donorRangeNotNull = ((donorEndIndex - donorStartIndex) + 1) > 0;

        if ((mainArrayNotNull && mainRangeNotNull) && (donorArrayNotNull && donorRangeNotNull)){
            int mainCount = mainStartIndex;
            int donorCount = donorStartIndex;

            /*Стартовый индекс - включительно, конечный индекс - не включительно*/
            while ((mainCount < mainEndIndex) && (donorCount < donorEndIndex)){
                mainArray[mainCount] = donorArray[donorCount];
                mainCount++;
                donorCount++;
            }
        }
    }

    /** Вычисление среднего арифметического элементов целочисленного массива */
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

    /**
     * Проверяет на одинаковость все элементы массива целых чисел
     * true - все одинаковые
     * false - хоть один отличается
     * стартовый индекс - включительно
     * конечный - не включительно
     */
    public static boolean allSame(int[] inputArray, int startIndex,
                                  int endIndex) {
        if (inputArray != null) {
            for (int i = startIndex; i < endIndex - 1; i++) {
                if (inputArray[i] != inputArray[i + 1]) {
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * Сортирует диапазон в массиве "на месте"
     * стартовый индекс - включительно
     * конечный - не включительно
     */
    public static void sort(int[] inputArray, int startIndex, int endIndex) {
        int arrayRangeLength = (endIndex - startIndex);

        if (arrayRangeLength > 1 && !allSame(inputArray, startIndex, endIndex)) {
            int[] bufferArray = Arrays.copyOfRange(inputArray, startIndex, endIndex);
            int countFromStart = startIndex;
            int countFromEnd = endIndex - 1;
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
            sort(inputArray, startIndex, countFromStart);
            sort(inputArray, countFromEnd + 1, endIndex);
        }
    }

    /** Возвращает отсоритрованный массив */
    public static int[] returnSort(int[] inputArray) {
        if (inputArray.length <= 1 || allSame(inputArray, 0, inputArray.length)) {
            return Arrays.copyOf(inputArray, inputArray.length);
        } else {
            int[] outputArray = new int[inputArray.length];
            double average = averageOfArray(inputArray);
            int countFromStart = 0;
            int countFromEnd = inputArray.length - 1;

            for (int i :
                    inputArray) {
                if (i > average) {
                    outputArray[countFromEnd] = i;
                    countFromEnd--;
                } else {
                    outputArray[countFromStart] = i;
                    countFromStart++;
                }
            }

            /*сортируем левую часть массива*/
            int[] leftRange = Arrays.copyOfRange(outputArray, 0, countFromStart);
            leftRange = returnSort(leftRange);

            /*сортируем правую часть массива*/
            int[] rightRange = Arrays.copyOfRange(outputArray, countFromEnd + 1, outputArray.length);
            rightRange = returnSort(rightRange);

            /*вставляем отсортированные части в возвращаемый массив*/
            insertArray(outputArray, 0, countFromStart, leftRange, 0, leftRange.length);
            insertArray(outputArray, countFromEnd + 1, outputArray.length, rightRange, 0, rightRange.length);

            return outputArray;
        }
    }

    public static void main(String[] args) {
        int[] array = {34, 5, 456, -3, 452, 0, 0, 5443, 7, 43, 23, 5, 35, 900, 6, 78, 0, 454, 35, 67, 89, -78946, 898, 76};
        int[] sortedArray = returnSort(array);
        sort(array, 0, array.length);

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");

        for (int i:
             sortedArray) {
            System.out.print(i + " ");
        }

    }
}


