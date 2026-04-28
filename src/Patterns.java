import java.util.Stack;

public class Patterns {
    public static void main(String[] args) {
        /*
        ****
        ****
        ****
        ****
         */
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("\n" + "\n" + "\n");



        /*
         *
         **
         ***
         ****
         */
        for (int i=0; i<4; i++) {
            for (int j=0; j<i+1; j++) { // for j<=i can also be the condition
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("\n" + "\n" + "\n");


        /*
         1
         12
         123
         1234
         */
        for (int i=0; i<10; i++) {
            for (int j=0; j<=i; j++) {
                System.out.print(j+1 + " ");
            }
            System.out.println();
        }
        System.out.println("\n" + "\n" + "\n");


        /*
         1
         22
         333
         4444
         */
        for (int i=1; i<=4; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("\n" + "\n" + "\n");


        /*
         ****
         ***
         **
         *
         */
        for (int i=4; i>0; i--) {
          for (int j=1; j<=i; j++) {
              System.out.print("* ");
          }
            System.out.println();
        }
        System.out.println("\n" + "\n" + "\n");


        /*
         12345
         1234
         123
         12
         1
         */
        for (int i=5; i>0; i--) {
           for (int j=1; j<=i; j++) {
               System.out.print(j);
           }
            System.out.println();
        }
        System.out.println("\n" + "\n" + "\n");


        /*
         *
        * *
      *  *  *
    *   *  *  *
    what we are printing is space star space
         */
        int n = 5;
        for (int i=0; i<n; i++) {
            // space n-i-1
            for (int j=0; j<n-i-1; j++) {
                System.out.print(" ");
            }
            // star
            for (int k = 0; k < 2 * i +1; k++) {
                System.out.print("*");
            }

            //space
            for (int y = 0 ; y < n-i -1; y++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("\n" + "\n" + "\n");



          /*
        *******
         *****
          ***
           *
    what we are printing is space star space
         */
        n = 5;
        for (int i=n; i>0; i--) {
            // space n-i-1
            for (int j=1; j < n-i+1; j++) {
                System.out.print(" ");
            }
            // star
            for (int k = 0; k < 2 * i -1; k++) {
                System.out.print("*");
            }
            //space
            for (int y = 0 ; y < n-i+1; y++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("\n" + "\n" + "\n");


        /*
           *
          ***
        *******
       *********
       *********
        ********
         ******
         ***
          *
         */
        n = 5;
        for (int i=0; i<n; i++) {
            // space n-i-1
            for (int j=0; j<n-i-1; j++) {
                System.out.print(" ");
            }
            // star
            for (int k = 0; k < 2 * i +1; k++) {
                System.out.print("*");
            }

            //space
            for (int y = 0 ; y < n-i -1; y++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        n = 5;
        for (int i=n; i>0; i--) {
            // space n-i-1
            for (int j=1; j < n-i+1; j++) {
                System.out.print(" ");
            }
            // star
            for (int k = 0; k < 2 * i -1; k++) {
                System.out.print("*");
            }
            //space
            for (int y = 0 ; y < n-i+1; y++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("\n" + "\n" + "\n");


        /*
        *
        **
        ***
        ****
        ***
        **
        *
         */
        n = 4;
        for (int a=0; a<n; a++) {
            for (int i=0; i<=a; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int a=0; a<=n-1; a++) {
            for (int i=0; i<n-a-1; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("\n\n\n");

//        for (int l=1; l< 2*n-1; l++) {
//            int stars = l;
//            if (l > n) {
//                stars= 2*n-l;
//
//
//            }
//
//            for (int j=0; j<)
//        }


        int len = 5;
        for (int i=0; i<len; i++) {
            // spaces
            for (int j=0; j<len-i-1; j++) {
                System.out.print(" ");
            }
            //
            for (int k=0; k< 2*i+1; k++) {
                System.out.print("*");
            }
            for (int y=0; y<len-i-1; y++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        // now just reverse this logic
        len = 3;
        for (int i=len; i>=0; i--) {
            //spacess
            for (int j=0; j<len-i+1; j++) {
                System.out.print(" ");
            }
            // now stqart , just replace it with no of spaces of first loop

            for (int k=0; k< 2*i+1; k++) {
                System.out.print("*");
            }
            for (int j=0; j<len-i+1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
