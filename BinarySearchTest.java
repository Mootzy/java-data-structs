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
//   static int binarySearch(int[] arr, int l, int r, int x)
//   {
//      if (r >= l) {
//         //int mid = l + (r - l) / 2;
//         int mid = (l + r + 1) / 2;
//         // If the element is present at the
//         // middle itself
//         if (arr[mid] == x)
//            return mid;
//
//         // If element is smaller than mid, then
//         // it can only be present in left subarray
//         if (arr[mid] > x)
//            return binarySearch(arr, l, mid - 1, x);
//
//         // Else the element can only be present
//         // in right subarray
//         return binarySearch(arr, mid + 1, r, x);
//      }
//
//      // We reach here when element is not present
//      // in array
//      return -1;
//   }
   // perform a binary search on the data      
//   public static int binarySearch(int[] data, int key)
//   {
//      int low = 0; // low end of the search area
//      int high = data.length - 1; // high end of the search area
//      int middle = (low + high + 1) / 2; // middle element
//      int location = -1; // return value; -1 if not found
//
//      do // loop to search for element
//      {
//         // print remaining elements of array
//         System.out.print(remainingElements(data, low, high));
//
//         // output spaces for alignment
//         for (int i = 0; i < middle; i++)
//            System.out.print("   ");
//         System.out.println(" * "); // indicate current middle
//
//         // if the element is found at the middle
//         if (key == data[middle])
//            location = middle; // location is the current middle
//         else if (key < data[middle]) // middle element is too high
//            high = middle - 1; // eliminate the higher half
//         else  // middle element is too low
//            low = middle + 1; // eliminate the lower half
//
//         middle = (low + high + 1) / 2; // recalculate the middle
//      } while ((low <= high) && (location == -1));
//
//      return location; // return location of search key
//   } // end method binarySearch

   // method to output certain values in array
   private static String remainingElements(int[] data, int low, int high)
   {
      StringBuilder temporary = new StringBuilder();

      // append spaces for alignment
      for (int i = 0; i < low; i++)
         temporary.append("   ");

      // append elements left in array 
      for (int i = low; i <= high; i++)
         temporary.append(data[i] + " ");

      return String.format("%s%n", temporary);
   } // end method remainingElements

   public static void main(String[] args)
   {

      Scanner input = new Scanner(System.in);
      SecureRandom generator = new SecureRandom();

      int[] data = new int[15]; // create array

      for (int i = 0; i < data.length; i++) // populate array
         data[i] = 10 + generator.nextInt(90);


      Arrays.sort(data); // binarySearch requires sorted array
      System.out.printf("%s%n%n", Arrays.toString(data)); // display array
      //System.out.println(data[0]);
      //System.out.println(data[14]);
      // get input from user
      System.out.print("Please enter an integer value (-1 to quit): ");
      int searchInt = input.nextInt(); 

      // repeatedly input an integer; -1 terminates the program
      while (searchInt != -1)
      {
         // perform search
         //int location = binarySearch(data, data[0],data[14], searchInt);
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
