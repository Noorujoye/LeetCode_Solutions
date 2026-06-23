package Techie;

public class AlternateConcatenationOfTwoStrings {

    public static String alternateConcatenation(String first, String second) {
        StringBuilder result = new StringBuilder();
        int len = Math.max(first.length() , second.length());
        for (int i=0; i<len; i++) {
            if (i < first.length()) {
                result.append(first.charAt(i));
            }
            if (i < second.length()) {
                result.append((second.charAt(i)));
            }
        }
        return result.toString();
    }
    static void main() {
        String firstname = "VIRAT";
        String lastname = "KOHLI";
        System.out.println(alternateConcatenation(firstname ,lastname));
    }
}
