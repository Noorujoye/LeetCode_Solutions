package String;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s.length() < numRows && s.isEmpty()) return s;
        String[] ans = new String[numRows];

        for (int i=0; i<numRows; i++) {
            ans[i] = "";

        }
        int i=0;
        while (i<s.length()) {
            for (int idx = 0; idx < numRows && i<s.length(); idx++) {
                ans[idx] += s.charAt(i++);
            }
            for (int idx = numRows-2; idx>0 && i<s.length(); idx--) {
                ans[idx] += s.charAt(i++);
            }
        }
        String res = "";
        for (String str : ans) {
            res += str;
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ZigZagConversion z = new ZigZagConversion();
        String zz = z.convert(str ,2 );
        System.out.println(zz);


    }
}
