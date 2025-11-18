package HashMap;

import java.util.HashMap;
import java.util.Set;

public class MajorityElement {
    public int majorityElement(int[] arr) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            hm.put(arr[i] , hm.getOrDefault(arr[i] , 0)+1);
        }
//        Set<Integer> set = hm.keySet();
        for (Integer s : hm.keySet()) {
            if (hm.get(s) > arr.length/3) {
                return s;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {5,5,5,5,7,5,1,5,5,4,5,7};
        MajorityElement m = new MajorityElement();
        System.out.println(m.majorityElement(arr));
    }
}
