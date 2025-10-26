package String;

public class StringToIntegerAtoi8 {
    public  int toInteger(String s) {
        s=s.trim();
        long num = 0;
        if (s.isEmpty()) {
            return 0;
        }
        int i=0;
        int sign = 1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        while (i<s.length() && Character.isDigit(s.charAt(i))) {
            num = (num * 10) + (s.charAt(i) - '0');
            if (sign == 1 && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        i++;
        }
      return (int) (sign * num);
    }
    public static void main(String[] args) {
        String str = "42";
        StringToIntegerAtoi8 s = new StringToIntegerAtoi8();
        int ans = s.toInteger(str);
        System.out.println(ans);
    }
}
