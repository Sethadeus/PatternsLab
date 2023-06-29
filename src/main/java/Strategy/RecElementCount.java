package Strategy;

import java.util.Arrays;

public class RecElementCount implements IStrategy {

    @Override
    public void count(int[] array) {

        Arrays.sort(array);

        countElements(array, 0, array.length - 1);
    }

    private static void countElements(int[] array, int start, int end) {
        if (start > end) {
            return;
        }

        int element = array[start];
        int count = 1;
        int i = start + 1;

        while (i <= end && array[i] == element) {
            count++;
            i++;
        }

        System.out.println("Элемент " + element + " встречается " + count + " раз(а).");

        countElements(array, i, end);
    }

}
