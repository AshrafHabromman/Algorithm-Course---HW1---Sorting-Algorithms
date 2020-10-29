
 //Ashraf Habromman
//11821493

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] array = enterArray();
        array = Solution.radixSort(array, 0, array.length - 1);
    
        System.out.print("["+array[0]);
    
        for(int i=1 ; i<array.length;i++) {
            System.out.print(","+array[i]);
        
        }
        System.out.print("]");
        
		
	}
	public static int [] radixSort(int []arr, int firstIndex, int finalIndex) {
		
		
		//int [] digitsArray = Solution.digitsArray(arr);
		//int counter=0;
		int [] sortedArray = arr;

		int maxNumber = Solution.maxNumber(arr);
		//System.out.println(maxNumber+"");
		for(int i=1, t=0; (maxNumber/i) > 0; i*=10, t++) {
			
			sortedArray = Solution.countingSort(sortedArray, firstIndex, finalIndex, t);		
		}

		return sortedArray;

	}
	
	/*public static boolean isItEnough(int []arr, int tensValue) {
		boolean flag = true ; 
		int [] copyOfArray = arr;
		for(int i=0; i< arr.length; i++) {
			int num = copyOfArray[i] /= (Math.pow(10,tensValue));
			num%= 10;
			System.out.println("hieweq");
			if(num != 0) {
				flag = false;
				System.out.println("hi");
				break;
			}
		}
		return flag;
	}
	*/
	
	public static int maxNumber(int [] arr) {
		int max = arr[0];
		for(int i=1; i< arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max ;
	}
	public static int [] countingSort(int []arr, int firstIndex, int finalIndex, int tensValue) {
		
		
		int [] countingArray = new int[10]; 
		int [] digitsArray = new int[arr.length];
		int [] copyOfArray = arr.clone();
		int digit=0;
		//Arrays.fill(countingArray, 0);
		for(int i=0; i< arr.length; i++) {
			//System.out.println(arr[i]+"");
			copyOfArray[i] /= (Math.pow(10,tensValue));
			digit = copyOfArray[i]%10;
			//System.out.println(digit+"");
			digitsArray[i] = digit;
			countingArray[digit]++;

		}
		for(int i=0 ;i<9; i++) {
			countingArray[i+1] = countingArray[i] + countingArray[i+1];
		}
		int [] sortedArr = new int[arr.length];
		for(int i= sortedArr.length -1 ; i >= 0; i--) {
			//System.out.println(sortedArr[i]+"");
			sortedArr[countingArray[digitsArray[i]] - 1] = arr[i];
			countingArray[digitsArray[i]]--;
			//System.out.println(sortedArr[i]+"");
		}
		return sortedArr;
	}
/*	public static int [] digitsArray(int []arr){
		
		int [] digitArray = new int[arr.length+1];
		int flag=0;
		for(int i=0; i<arr.length; i++) {
			
			digitArray[i] = arr[i]%10;
			arr[i] /=10;
			if(arr[i] != 0) {
				flag = 1;     		//check if all array is zeros if so flag will remains 0 
			}
		}
		digitArray[digitArray.length - 1] = flag;
		return digitArray;
	}*/
	
	
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
        input.close();
        return array;
    
    }

}
