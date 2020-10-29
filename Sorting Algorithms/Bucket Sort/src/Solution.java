//Ashraf Habromman
//11821493
import java.io.*;
import java.util.*;

public class Solution {

    public static Random random = new Random();
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int [] array = enterArray();
        array = Solution.bucketSort(array, 0, array.length - 1);
    
        System.out.print("["+array[0]);
    
        for(int i=1 ; i<array.length;i++) {
            System.out.print(","+array[i]);
        
        }
        System.out.print("]");

    }
    public static double whatIsDivisor(int number) {
        
        int i = 0 ;
        while(true) {
            if((number >= Math.pow(10, i)) && (number < Math.pow(10, i+1))) {
                return Math.pow(10, i+1);
            }
            i++;
        }
    }
    
    public static int [] bucketSort(int [] arr, int firstIndex, int finalIndex) {
        
        int min = Solution.minNumber(arr);
        
        double divisor = 0;        
        
        if(min < 0) {
        	Solution.addForAllElements(arr, min * -1);
        }
        
        int max = Solution.maxNumber(arr);                //n

        divisor = Solution.whatIsDivisor(max);
        System.out.println("divisor:"+divisor+",max:"+max+",min:"+min);

        double [] arrayBetween0_1 = Solution.dividArrayby(arr, divisor);    //n
        
        /*for(int i=0; i<arrayBetween0_1.length; i++) {
            System.out.println(arrayBetween0_1[i]+"hello");
        }*/
        
        @SuppressWarnings("unchecked")
        Vector<Integer> [] digitVector = (Vector<Integer>[]) new Vector[10];
        for(int i=0; i<10; i++) {
            digitVector[i] = new Vector<Integer>();         //n
        }
        
        for(int i=0; i<arr.length; i++) {
            int index = (int) (arrayBetween0_1[i]*10);
            //System.out.println(f+"hello");
            digitVector[index].add(arr[i]);                //n
            //System.out.println(f+"hellllllo");
        }
        int [] sortedArray = new int[arr.length];
        int t=0; // index of sorted array
        for(int i=0; i<10; i++) {
            Integer [] arrFromVector = new Integer[digitVector[i].size()];        
            arrFromVector = digitVector[i].toArray(arrFromVector);
            Solution.quickSort(arrFromVector, 0, arrFromVector.length - 1);
            
            for(int j=0; j< arrFromVector.length; j++) {
                System.out.println(""+arrFromVector[j]);
                sortedArray[t++] = (int) (arrFromVector[j]);
            }
            System.out.println("-----");
        }
        
        if(min < 0) {
        	Solution.addForAllElements(sortedArray, min);
        }
        return sortedArray;
    }
    
    public static double [] dividArrayby(int [] arr, double divisor) {
        
        double []dividedArray = new double[arr.length];
        for(int i=0; i<arr.length; i++) {
            dividedArray[i] = arr[i] / divisor;
        }
        return dividedArray;
    }
    
    public static int maxNumber(int [] arr) {
        int max = arr[0];
        for(int i=1; i< arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max ;
    }
    
    public static int minNumber(int []arr){
        int min = arr[0];
        for(int i=1; i< arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min ;
    }
    
    public static void quickSort(Integer []arr, int firstIndex,int finalIndex){
        
        if(/*firstIndex == 8 ||  finalIndex == -1 || firstIndex == -1 || */(firstIndex-1 == finalIndex) || (firstIndex == finalIndex)) {
            return;
        }
        
        int pivotIndex = random.nextInt((finalIndex - firstIndex));//firstIndex;
        pivotIndex += firstIndex;
        
        Solution.swap(arr, firstIndex, pivotIndex); //firstly make a swap, then the pivot will be in the first position 
        
        Integer pivot = arr[firstIndex];
        
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
    public static void addForAllElements(int [] arr, int number) {
        for(int i=0; i<arr.length; i++) {
            arr[i] += number;
        }
    }
    
    public static int [] enterArray() {
        Scanner input = new Scanner(System.in);
        int [] array;
        array = new int[input.nextInt()];
        for(int i=0; i<array.length; i++)
            array[i] = input.nextInt();
        input.close();
        return array;
    
    }
    public static void swap(Integer [] arr, int i, int j){
        
        Integer temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /*public static void insertionSort(Double [] arr, int firstIndex, int finalIndex) {

        Double temp ;
        for (int i=1; i<arr.length; i++) {
                    
            int j = i ;
            
            while(arr[j-1] > arr[j]) {
                temp = arr[j-1]; 
                arr[j-1] = arr[j];
                arr[j] = temp ;
              
                j--;                                                    
                  if(j==0) {
                      break; 
                }            
            }

        }
        
    }*/

}
