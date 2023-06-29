package Strategy;

import java.util.*;

public class MapElementCount implements IStrategy{
    @Override
    public void count(int[] array) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : array) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println("Элемент " + entry.getKey() + " встречается " + entry.getValue() + " раз(а).");
        }
    }
}
