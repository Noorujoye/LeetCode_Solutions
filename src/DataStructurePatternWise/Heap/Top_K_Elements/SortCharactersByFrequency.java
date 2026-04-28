package DataStructurePatternWise.Heap.Top_K_Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {

        HashMap<Character , Integer> freq = new HashMap<>();
        char[] arr = s.toCharArray();

        for (char a : arr) freq.put(a , freq.getOrDefault(a , 0) + 1);

        // sort the character by there frequency count
        PriorityQueue<Map.Entry<Character , Integer>> maxHeap = new PriorityQueue<>( (a , b) -> b.getValue() - a.getValue());

        maxHeap.addAll(freq.entrySet());
        StringBuilder str = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character , Integer> entry = maxHeap.poll();

            char ch = entry.getKey();
            int cnt = entry.getValue();

            while (cnt-- > 0) {
                str.append(ch);
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        String s = "NoorainNoorain";
        String ans = SortCharactersByFrequency.frequencySort(s.toLowerCase());
        System.out.println(ans);
    }
}
