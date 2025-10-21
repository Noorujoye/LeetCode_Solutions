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




//// Base case: if only one row, no zigzag possible
//        if (numRows == 1 || s.length() <= numRows)
//        return s;
//
//// Create a StringBuilder for each row
//StringBuilder[] rows = new StringBuilder[numRows];
//        for (int i = 0; i < numRows; i++) {
//rows[i] = new StringBuilder();
//        }
//int currentRow = 0;
//boolean goingDown = false;
//
//// Loop through each character in the string
//        for (char c : s.toCharArray()) {
//rows[currentRow].append(c);
//// Change direction when reaching top or bottom
//            if (currentRow == 0 || currentRow == numRows - 1)
//goingDown = !goingDown;
//currentRow += goingDown ? 1 : -1;
//        }
//
//// Combine all rows into one final string
//StringBuilder result = new StringBuilder();
//        for (StringBuilder row : rows) {
//        result.append(row);
//        }
//                return result.toString();