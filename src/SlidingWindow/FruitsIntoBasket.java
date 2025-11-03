package SlidingWindow;

import java.util.HashMap;

public class FruitsIntoBasket {
    public int totalFruit(int[] fruits) {

        HashMap<Integer , Integer> fruitCount = new HashMap<>();
        int maxFruits = 0;
        int start=0;
        for (int end=0; end<fruits.length; end++) {
            int fruit = fruits[end];
            fruitCount.put(fruit , fruitCount.getOrDefault(fruit , 0)+1);

            while (fruitCount.size() > 2) {
                int leftFruit = fruits[start];
                fruitCount.put(leftFruit , fruitCount.get(leftFruit)-1);
                if (fruitCount.get(leftFruit) == 0) {
                    fruitCount.remove(leftFruit);
                }
                start++;
            }

            maxFruits = Math.max(maxFruits , end-start+1);
        }
        return maxFruits;
    }
    public static void main(String[] args) {
        int[] fruits = {1,2,1};
        FruitsIntoBasket f = new FruitsIntoBasket();
        System.out.println(f.totalFruit(fruits));
    }
}
