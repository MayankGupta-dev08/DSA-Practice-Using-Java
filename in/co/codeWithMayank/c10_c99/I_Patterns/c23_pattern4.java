package in.co.codeWithMayank.c10_c99.I_Patterns;

import java.util.*;

public class c23_pattern4 {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    scn.close();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if(j < i)
            System.out.print("  ");
        else
            System.out.print("* ");
      }
      System.out.println();
    }
  }
}

/*
6

* * * * * * 
  * * * * * 
    * * * * 
      * * * 
        * * 
          * 

*/