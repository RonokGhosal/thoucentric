import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.lang.Integer;

 import java.util.*;

/*
 * This code finds the count of 
 * different numbers between 178416-676461 (exclusive) that meet the following criteria -
 * - Two adjacent digits are the same (like 22 in 122345).
 * - Going from left to right, the digits never decrease; they only ever increase or stay the same
 *  Examples:

 * - 111111 meets these criteria (double 11, never decreases).

 * - 223450 does not meet these criteria (decreasing pair of digits 50).

 * - 123789 does not meet these criteria (no double).
 *  Print statements are commented for verbose debug
 *  
 */
class DupsAndAcsNum  {


    public static List <Integer>  intToListOfDigits (int num) {
      ArrayList <Integer> digitsArr = new ArrayList<Integer>();
      int n = num;
      while( n > 0)  {
          digitsArr.add(0,n % 10);
          n = n/10;
      }
      return  digitsArr;
    }

    public static  int ListOfDigitsToInt (List <Integer> listNum) {
        double num = 0;
     for ( int i = 0; i < listNum.size(); i ++) {
         num = num + listNum.get(i) * Math.pow(10, listNum.size()- 1-i);
     }
     return (int)num;
    }
    public static int intprocessNum( List <Integer> la ) {
        int max = -1;
        boolean repeat = false;
        int num = ListOfDigitsToInt(la);
       for (int i  = 0; i  < la.size(); i ++) {
         //  System.out.println("Max : " + max);
           int cur = la.get(i);
           //System.out.println("Cur :" + cur);
           if (cur >= max) {
            //   System.out.println( cur + " >= " + max);
               max = cur;
               if ( (i < la.size() -1) && (la.get(i) == la.get(i+1)) ) {
                   repeat = true;
               }

           } else {
            //   System.out.println( cur + " NOT >= " + max);
             // System.out.println( num + " NOT OK as not increasing");
               return -1;
           }
       }

        if (repeat) {

          //  System.out.println( num + "OK");
            return num;
        }
        else {
          //  System.out.println( num + " NOT OK as no Repeat");
            return -1;
        }
   }



    public static void main (String[] args) {
    List <Integer> listInts = null;
        int count = 0;
       for ( int i =  178417 ; i < 676461; i ++ ) {
            listInts = intToListOfDigits (i);
             int num = intprocessNum(listInts);
             if ( num != -1) {
             count = count + 1;
            // System.out.println(num);

        }

        }
         System.out.println("Number of integers in the range 178416-676461 (exclusive) meeting expected criteria is ");
         System.out.println(count);

    }
    
}



