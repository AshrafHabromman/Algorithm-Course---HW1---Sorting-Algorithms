//Ashraf Habromman 
//11821493

import java.io.*;
import java.util.*;

public class Solution {

    public static Random random = new Random();
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	

        int [] array = enterArray();
        Solution.quickSort(array, 0, array.length - 1);
        
        System.out.print("["+array[0]);
        
        for(int i=1 ; i<array.length;i++) {
            System.out.print(","+array[i]);
            
        }
        System.out.print("]");
        
    }
    
    public static void quickSort(int []arr, int firstIndex,int finalIndex){
        
      if(/*firstIndex == 8 ||  finalIndex == -1 || firstIndex == -1 || */(firstIndex-1 == finalIndex) || (firstIndex == finalIndex)) {
          return;
      }
      
      int pivotIndex = random.nextInt((finalIndex - firstIndex));//firstIndex;
      pivotIndex += firstIndex;
      
      Solution.swap(arr, firstIndex, pivotIndex); //firstly make a swap, then the pivot will be in the first position 
      
      int pivot = arr[firstIndex];
      
      int j = firstIndex + 1; 
      int i = firstIndex;
      for(int l=0 ; l<(finalIndex - firstIndex); l++) {
          
          if(pivot>arr[j]) {
              i++;
              Solution.swap(arr, i, j);
              //System.out.println("Hello");
          }
          j++;
      }
      Solution.swap(arr, i, firstIndex);
      
      Solution.quickSort(arr,i+1,finalIndex);
      //System.out.println("Hi");
      Solution.quickSort(arr,firstIndex,i-1);
      //System.out.println("Hiii");
      
    }
    
    public static void swap(int [] arr, int i, int j){
        
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int [] enterArray() {
        Scanner input = new Scanner(System.in);
        int [] array;
        array = new int[input.nextInt()];
        for(int i=0; i<array.length; i++)
            array[i] = input.nextInt();
        
        return array;
        
    }
    
}