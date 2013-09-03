package util;

import java.util.Scanner;

public class Console {

     public static String readString(){
    	 String str;
    	 Scanner scanIn = new Scanner(System.in);
    	 str = scanIn.nextLine();
    	 scanIn.close();
    	 return str;
     }
     
     public static char readChar(){
    	 char c;
    	 String in;
    	 Scanner s = new Scanner(System.in);
    	 in = s.nextLine();
    	 s.close();
    	 c = in.charAt(0);
    	 return c;
     }
}
