/**
Given a binary tree, return the diff of the whole tree.

The diff of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has diff 0.

The diff of the whole tree is defined as the sum of all nodes' diff.

Example:
Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
diff of node 2 : 0
diff of node 3 : 0
diff of node 1 : |2-3| = 1
diff of binary tree : 0 + 0 + 1 = 1


*/

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */



// class Solution {
//   public static void main(String[] args) {
//     ArrayList<String> strings = new ArrayList<String>();
//     strings.add("Hello, World!");
//     strings.add("Welcome to CoderPad.");
//     strings.add("This pad is running Java " + Runtime.version().feature());

//     for (String string : strings) {
//       System.out.println(string);
//     }
//   }
  
//   class Node {
//     Node left;
//     Node right;
//     Integer data;
//   }
//   static Integer sum = 0;
//   Integer findDiffSum(Node node) {
//     Integer leftSum = 0;
//     Integer rightSum = 0;
//     if(node.left == null && node.right == null){
//       return node.data;
//     }
//     if(node.left!=null){
//        leftSum = findDiffSum(node.left);
//     }
//     if(node.right!=null){
//       rightSum = findDiffSum(node.right);
//     }
//     sum += Math.abs(leftSum - rightSum);
//     return leftSum + rightSum + node.data;
//   }
// }





// 2nd question 


/**
*
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number.

In -> [3,2,1]
Out -> 1
*/

class Heap{
    Integer[] heap;
    int size;
    int currSize;
    
    Heap(List<Integer> list){
      size = list.size();
      heap = new Integer[size];
      heap[0] = Integer.MAX_VALUE;
      currSize = 0;
      for(Integer i: list){
        insertIntoHeap(i);
      } 
    }
    
    private void insertIntoHeap(Integer i){
      heap[currSize] = i;
      int j = currSize;
      while(heap[j] > heap[j/2]){
        Integer temp = heap[j];
        heap[j] = heap[j/2];
        heap[j/2] = temp;
        j = j/2;
      }
      System.out.println(currSize + "," + i);
      currSize++;
    }
    
    private void maxHeapify(int index){
      System.out.println(index);
      if(heap[index] < heap[2*index] || heap[index] < heap[2*index + 1] )
        System.out.println("HeapifyCheck:"+heap[2*index]+ " "+ heap[2*index+1]+ " " +heap[index]);
        if(heap[2*index] > heap[2*index +1]){
          Integer temp = heap[index];
          heap[index] = heap[2*index];
          heap[2*index] = temp;
          maxHeapify(2*index);
        }
        else{
          Integer temp = heap[index];
          heap[index] = heap[2*index +1];
          heap[2*index +1] = temp;
          maxHeapify(2*index +1);
        }
    }
      
    public Integer extractMax(){
      if(currSize == 0){
        return -1;
      }
      Integer result = heap[0];
      heap[0] = heap[currSize-1];
      currSize--;
      maxHeapify(0);
      return result;
    }
  }


class Solution {

  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());
    List<Integer> li = new ArrayList<>();
    li.add(4);
    li.add(3);
    li.add(2);
    li.add(5);
    li.add(6);
    li.add(1);
    //get3rdMax(li);
    Heap maxHeap = new Heap(li);
    Integer result = -1;
    for(int i=0; i<3 ;i++){
      Integer temp = maxHeap.extractMax();
      System.out.print(temp);
      if(temp!=-1)
        result = temp;
    }
    System.out.print(result);
  }
  
  
  
  
  public int get3rdMax(List<Integer> list) {
  
    Heap maxHeap = new Heap(list);
    Integer result;
    for(int i=0; i<3 ;i++){
      Integer temp = maxHeap.extractMax();
      if(temp!=-1)
        result = temp;
    }
    return -1;
  }
  
}






