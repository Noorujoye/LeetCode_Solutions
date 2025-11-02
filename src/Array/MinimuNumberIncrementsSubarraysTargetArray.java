package Array;

public class MinimuNumberIncrementsSubarraysTargetArray {
    public int minOPeration(int[] target) {
        int oper = target[0];
        for (int i=1; i<target.length; i++) {
            oper += Math.max(0, target[i] - target[i-1]);
        }
        return oper;
    }
    public static void main(String[] args) {
        int[] target = {2,3,12,5,68,0};
        MinimuNumberIncrementsSubarraysTargetArray m = new MinimuNumberIncrementsSubarraysTargetArray();
        int ans = m.minOPeration(target);
        System.out.println(ans);
    }
}
