//Merge two sorted arrays in O(1) space.
/*
Here we have two sorted arrays but we can have higher value elements in the 1st array and lower value elements in the 2nd array.
Aim:- We need to make sure that the 1st array should contain the lower values and the 2nd one with higher value elements.
To do that, we form two bitonic arrays. i.e (1st increasing and then decreasing)

And then the sort each array using shell sort technique of using gap and thereby making it better than insertion sort.
Input#1:- 
5
4
1 2 7 9 12
3 5 11 13
Prior sorting,
we will get two arrays:- 
arr1:- {1,2,7,5,3}
arr2:- {12,9,11,13}
So, there's no element in the 1st array greater than any element in the 2nd array.
Now it's simple.
Just a sort of each arrays and done by reducing the gap after each iteration.
@author: Arindam Chattopadhay
Date:- 30/08/2020
*/
import java.util.*;
public class Merge_Sorted_Constant_Space{
	private static int nextGap(int gap)
	{
		if(gap<=1)
			return 0;
		else
			return ((gap/2)+(gap%2));
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		//IP
		int n=sc.nextInt();
		int m=sc.nextInt();
		int arr1[]=new int[n];
		int arr2[]=new int[m];
		for(int i=0;i<n;i++)
		{
			arr1[i]=sc.nextInt();
		}
		for(int i=0;i<m;i++)
		{
			arr2[i]=sc.nextInt();
		}
 		int x = Math.min(n, m);  
      
        // Form both arrays to be bitonic  
        for (int i = 0; i < x; i++)  
        {  
            if (arr1[n - i - 1] > arr2[i])  
            { 
                // swap(arr1[n - i - 1], arr2[i]);  
                int temp = arr1[n - i - 1]; 
                arr1[n - i - 1] = arr2[i]; 
                arr2[i] = temp; 
            } 
        }  
       
       System.out.println("for arr1 :-- ");
      	for(int i=0;i<n;i++)
      		System.out.print(arr1[i]+" ");
       System.out.println();

       System.out.println("for arr2 :-- ");
      	for(int i=0;i<m;i++)
      		System.out.print(arr2[i]+" ");
      	System.out.println();

        for (int gap = nextGap(n); gap > 0; gap = nextGap(gap)) 
        {  
             
            for (int i = 0; i + gap < n; i++)  
                if (arr1[i] > arr1[i + gap]) 
                { 
                    
                    int temp = arr1[i]; 
                    arr1[i] = arr1[i + gap]; 
                    arr1[i + gap] = temp; 
                } 
        }  
      	//Test1
      	System.out.println("for arr1 :-- ");
      	for(int i=0;i<n;i++)
      		System.out.print(arr1[i]+" ");
       System.out.println();
       
        for (int gap = nextGap(m); gap > 0;gap = nextGap(gap))  
        {  
      
             
            for (int i = 0; i + gap < m; i++)  
                if (arr2[i] > arr2[i + gap]) 
                { 
                    // swap(arr2[i], arr2[i + gap]);  
                    int temp = arr2[i]; 
                    arr2[i] = arr2[i + gap]; 
                    arr2[i + gap] = temp; 
                } 
        }  
        System.out.println("for arr2 :-- ");
      	for(int i=0;i<m;i++)
      		System.out.print(arr2[i]+" ");
      	System.out.println();

        for (int i = 0; i < n; i++)  
            System.out.print(arr1[i] + " ");  
        for (int j = 0; j < m; j++)  
            System.out.print(arr2[j] + " ");  

	}
}
