package Easy;

public class Palindrome {
    public static Boolean palindrome(int x) {
        int ans = 0;
        while (x>0) {
            int rem = x%10;
            ans = ans*10 + rem;
            x = x/10;
            if (ans == x) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int x = 1441;
        Boolean res = palindrome(x);
        System.out.println(res);
    }
}
