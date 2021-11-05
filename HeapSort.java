package Liang.chpt25;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
  /** Heap sort method */
  public static <E extends Comparable> void heapSort(E[] list) {


    Heap<E> heap = new Heap<E>();

    // Add elements to the heap
    for (E e : list) heap.add(e);
    heap.printHeap();

    // Remove elements from the heap
    for (int i = list.length - 1; i >= 0; i--)
      list[i] = heap.remove();


  }
  
  /** A test method */
  public static void main(String[] args) {
    Integer[] list = new Integer[21];
    Random random = new Random();

    for (int i = 0; i < 21; i++){
      list[i] = random.nextInt(100);
    }

    System.out.println("List: " + "\n" + Arrays.toString(list));
    heapSort(list);

  }
}
