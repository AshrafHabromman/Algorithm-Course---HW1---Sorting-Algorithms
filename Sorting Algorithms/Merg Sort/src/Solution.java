 //Ashraf Habromman
//11821493

import java.io.*;
import java.util.*;

    public class Solution {

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            System.out.println("hiis");
            int [] array = enterArray();
            array = Solution.mergSort(array, 0, array.length - 1);
        
            System.out.print("["+array[0]);
        
            for(int i=1 ; i<array.length;i++) {
                System.out.print(","+array[i]);
            
            }
            System.out.print("]");
            
        }
        
        public static int [] mergSort(int []arr, int firstIndex, int finalIndex){
            
            if( /*(firstIndex+1) == finalIndex || */(firstIndex == finalIndex)){
               /* if(arr[firstIndex]>arr[finalIndex])
                    Solution.swap(arr, firstIndex, finalIndex);*/
                //System.out.println(arr[firstIndex]+"hiiiiiis");
                int [] oneElementArr = new int[1];
                oneElementArr[0] = arr[firstIndex];
                return oneElementArr ;
            }
            int middle = ((finalIndex-firstIndex)/2) + 1;
            //System.out.println(middle+"");
            middle +=firstIndex;
            int [] leftArr = mergSort(arr, firstIndex, middle-1);
            //System.out.println("soso");
            int [] rightArr = mergSort(arr, middle, finalIndex);
            
            int [] leftRightMergedArr = new int[leftArr.length + rightArr.length]; 
            int leftIndex=0, rightIndex=0, t=0;
            for( ; t < leftRightMergedArr.length ;t++){
                
                if(leftArr[leftIndex] > rightArr[rightIndex]) {
                    leftRightMergedArr[t] = rightArr[rightIndex];
                    //System.out.println(rightArr[rightIndex]+"mimi");
                    rightIndex++;
                }
                else if(leftArr[leftIndex] < rightArr[rightIndex]) { //move data form left array to the new sorted array 
                    leftRightMergedArr[t] = leftArr[leftIndex];
                    //System.out.println(rightArr[rightIndex]+"lolo");
                    leftIndex++;
                }
                
                if((leftIndex == (leftArr.length)) || (rightIndex == (rightArr.length))) {
                    //System.out.println("Hi I'm here");
                    t++;
                    break;
                }
                    
            }//for loop 
            
            if((leftIndex == (leftArr.length))) {
                for(int i=0; i< (rightArr.length - rightIndex); i++, t++) {
                    leftRightMergedArr[t] = rightArr[rightIndex+i];
                    
                }
                //System.out.println("Hi I'm hereeeee");
            }
            else if((rightIndex == (rightArr.length))) {
                for(int i=0; i< (leftArr.length - leftIndex); i++, t++) {
                    leftRightMergedArr[t] = leftArr[leftIndex+i];
                    
                }
                //System.out.println("Hi I'm hereyyyy");
            }
            //System.out.println("bye");
            /*for(int elem : leftRightMergedArr ) {
                System.out.print(elem+",");
            }*/
            return leftRightMergedArr;
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