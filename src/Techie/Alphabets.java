package Techie;

import java.util.Scanner;

public class Alphabets {

    public static void isAlphabet(char ch) {

    }
    public static void check(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            System.out.println(ch + " is a vowel...");
        } else {
            System.out.println(ch + " is a consonant...");
        }
    }
    static void main() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a character to check whether it is vowel or consonant ?");
        char ch = sc.next().charAt(0);
        check(ch);
    }
}
