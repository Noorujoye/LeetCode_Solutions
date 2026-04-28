package HelpingMethods;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Basic {
    public static void main(String[] args) {
        String s = " Noorain ";
        String s1 = "Noorain";
        System.out.println(s.length());
        System.out.println(s.charAt(1));
        System.out.println(s.substring(1));
        System.out.println(s.substring(0 , s.length()));
        System.out.println(s.subSequence(1,4));
        System.out.println(s.isEmpty());
        System.out.println(s.isBlank());

        //String comparison

        System.out.println("is string s nd s1 equal - case sensitive ? " + s.equals(s1)); // case-sensitive
        System.out.println("is string s nd s1 equal - caseInsensitive  ? " + s.equalsIgnoreCase(s1));
        System.out.println("compare to returns int 0 , + , -  " + s.compareTo(s1));
        System.out.println("start with : " + s.startsWith("Noor"));
        System.out.println("ends with: " + s.endsWith("ain"));
        System.out.println("contains: " + s.contains("noor"));

        //String modification

        System.out.print("before trim length : " + s.length() + "\n" + "after trim : " + s.trim().length() + "\n");

        String name = "noorain";
        System.out.println("replace : " + name.replace("oo" , "aa" ));
        System.out.println("replaceALl :" + name.replaceAll("n" , "u"));

        // searching

        System.out.println("indexOf -  : " + s.indexOf("o")); // case-sensitive
        System.out.println("last index : " + s.lastIndexOf("n"));

        // regex

        String str = "Scala";

        System.out.println(str.matches("Scala"));
        System.out.println(Pattern.matches("Scala" , str));

        //splitting and joining

        String regex = ",";
        String sent = "java is,java";
        System.out.println("splitting : " + Arrays.toString(sent.split(",")));
        System.out.println("splitting with array size : " + Arrays.toString(sent.split("," , 3)));
        System.out.println("joins :" + String.join("," , s , sent));
    }
}
