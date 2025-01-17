package in.co.codeWithMayank.c10_c99.I_Numbers;

import java.util.*;
public class c45_digitFrequencyInNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        scn.close();
        
        int f = getDigitFrequency(n, d);
        System.out.println(f);
      }
    
      public static int getDigitFrequency(int n, int d){
          int count=0;
          while(n>0){
              int r = n%10;
              n=n/10;
              if(r==d)
                count++;
          }
          return count;
      }
}

/* 
994543234
4  
3
*/