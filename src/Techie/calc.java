package Techie;

import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        boolean yes = true;
        boolean No = false;
        Scanner input = new Scanner(System.in);
        while (yes) {
            System.out.print("Enter the fist number: ");
            int num1 = input.nextInt();
            System.out.print("Enter the second number: ");
            int num2 = input.nextInt();
            System.out.println("choose operation: \n" +
                    "1. ADD \n " +

                    "2. Sub \n " +
                    "3. MUl \n " +
                    "4. Div \n ");
            int operation = input.nextInt();
            int result = 0;
            switch (operation) {
                case 1: result = num1 + num2;
                    break;
                case 2: result = num1 - num2;
                    break;
                case 3: result = num1 * num2;
                    break;
                case 4:
                    try {
                        result = num1 / num2;
                    } catch (ArithmeticException e) {
                        System.out.println("deno cannot be zero...");
                    }
                    break;
                default:
                    System.out.println("Invalid num");
            }
            System.out.println("result : " + result);
            System.out.println("1. continue \n 2. stop");

            int runOrNot = input.nextInt();
            if (runOrNot == 1) {
                yes = true;
            } else {
                yes = false;
            }
        }
    }
}
