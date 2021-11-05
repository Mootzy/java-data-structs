package Liang.chpt25;

import java.security.SecureRandom;
import java.util.Arrays;


public class AVLPerformanceTest
{
    //Data array
    private static Integer[] data;

    //Tree objects
    private static BST<Integer> BSTree;
    private static Liang.chpt25.AVLTree<Integer> AVLTree;

    //Order of data to be randomized
    private static int order = 1;

    //Secure Random object
    private static final SecureRandom rand = new SecureRandom();

    //Performance test variables
    private static long startTime;
    private static long endTime;
    private static long timeElapsed;
    private static long totalTime;


    public static void main( String[ ] args )
    {
        while (order < 7) {
            runPerformanceTest();
            order++;
        }
//        System.out.println(totalTime);
//        System.out.printf("Total time is: %,d nanoseconds\n", timeElapsed);
    }


    private static void runPerformanceTest() {
        fillTrees();
        timeToFillTrees();
        System.out.println();
        runSearchTreesTest();
        System.out.println();
    }


    private static void fillTrees() {

        //initialize new int array
        data = new Integer[(int)Math.pow(10, order)];

        //Randomize elements
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(101);
        }

        //Sort the array
        Arrays.sort(data);
    }

    /**
     * Tests the time for filling both tree types
     */
    private static void timeToFillTrees() {
        //Fill trees
        System.out.println("Tree creation through constructor(E[] objects)");

        //Create BST
        startTime = System.nanoTime();
        // ... the code being measured starts ...
        BSTree = new BST<>(data);
        // ... the code being measured ends ...
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        totalTime += timeElapsed;
        System.out.printf("BST Constructor exectution time for %,d elements is %,d nanoseconds\n", (int)Math.pow(10, order), timeElapsed);

        //Create AVLTree
        startTime = System.nanoTime();
        // ... the code being measured starts ...
        AVLTree = new AVLTree<>(data);
        // ... the code being measured ends ...
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.printf("AVLTree Constructor exectution time for %,d elements is %,d nanoseconds\n", (int)Math.pow(10, order), timeElapsed);
        totalTime += timeElapsed;
    }

    /**
     * Tests the time for searching both tree types
     */
    private static void runSearchTreesTest() {
        //Search trees
        System.out.println("Average search time comparison");

        //Search BST
        startTime = System.nanoTime();

        // ... the code being measured starts ...
        for (Integer integer : data) {
            BSTree.search(integer);
        }

        // ... the code being measured ends ...
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        totalTime += timeElapsed;
        System.out.printf("BST average search exectution time for %,d elements is %,d nanoseconds\n", (int)Math.pow(10, order), timeElapsed);

        startTime = System.nanoTime();


        for (Integer datum : data) {
            AVLTree.search(datum);
        }

        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.printf("AVLTree average search exectution time for %,d elements is %,d nanoseconds\n", (int)Math.pow(10, order), timeElapsed);
        totalTime += timeElapsed;
    }
}
//Tyler Wallace, worked With Nathan Orwick in order to find a solution.