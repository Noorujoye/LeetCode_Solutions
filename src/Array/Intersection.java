package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Intersection {
    public int[] intersection(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int value : arr1) {
            map.put(value, map.getOrDefault(value , 0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int value : arr2) {
            if (map.containsKey(value) && map.get(value) > 0) {
                list.add(value);
                map.put(value , map.get(value)-1);
            }
        }

        int[] intersect = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            intersect[i] = list.get(i);
        }
        return intersect;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,4,5,6};
        int[] arr2 = {1,2,4,5,7};
        Intersection in = new Intersection();
        int[] ans = in.intersection(arr1,arr2);
        System.out.println(Arrays.toString(ans));
    }
}
