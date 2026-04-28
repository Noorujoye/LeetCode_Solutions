package DataStructurePatternWise.stack.monotonic.NextGreaterElement;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] num1 , int[] num2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer , Integer> map = new HashMap<>();
        int[] result = new int[num1.length];

        for (int num : num2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.poll() , num);
            }
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            map.put(stack.poll() , -1);
        }

        for (int i=0; i<num1.length; i++) {
            result[i] = map.get(num1[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] num1 = {4 , 1 , 2};
        int[] num2 = {1,3,4,2};
        num1 = NextGreaterElement.nextGreaterElements(num1 , num2);
        for (int num : num1) {
            System.out.println( num + ",");
        }
    }
}
