/**
 * Tyler W.
 * Java hw 8
 * 10/22/2021
 * recursive binary search
 */

package Liang.chpt25;// BinarySearchTest.java
// Use binary search to locate an item in an array.
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTest
{

   public static int recursiveBinarySearch(int[] input, int key) {
      return binarySearch(input, 0, input.length - 1, key);
   }

   private static int binarySearch(int[] array, int start, int end, int target) {
      //find center of array
      int middle = (start + end) / 2;

      if (end < start) {
         return -1;
      }
      if (target == array[middle]) {
         return middle;
      }
      else if (target < array[middle]) {
         return binarySearch(array, start, middle - 1, target);
      }
      else {
         return binarySearch(array, middle + 1, end, target);
      }
   }

//   private static String remainingElements(int[] data, int low, int high)
//   {
//      StringBuilder temporary = new StringBuilder();
//
//      // append spaces for alignment
//      for (int i = 0; i < low; i++)
//         temporary.append("   ");
//
//      // append elements left in array
//      for (int i = low; i <= high; i++)
//         temporary.append(data[i] + " ");
//
//      return String.format("%s%n", temporary);
//   } // end method remainingElements

   public static void main(String[] args)
   {

      Scanner input = new Scanner(System.in);
      SecureRandom generator = new SecureRandom();

      int[] data = new int[15]; // create array

      for (int i = 0; i < data.length; i++) // populate array
         data[i] = 10 + generator.nextInt(90);


      Arrays.sort(data); // binarySearch requires sorted array
      System.out.printf("%s%n%n", Arrays.toString(data)); // display array


      System.out.print("Please enter an integer value (-1 to quit): ");
      int searchInt = input.nextInt(); 

      // repeatedly input an integer; -1 terminates the program
      while (searchInt != -1)
      {

         int location = recursiveBinarySearch(data, searchInt);

         if (location == -1) // not found
            System.out.printf("%d was not found%n%n", searchInt); 
         else // found
            System.out.printf("%d was found in position %d%n%n", 
               searchInt, location);

         // get input from user
         System.out.print("Please enter an integer value (-1 to quit): ");
         searchInt = input.nextInt();
      }

   } // end main
} // end class BinarySearchTest
