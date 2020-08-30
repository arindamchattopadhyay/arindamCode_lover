//Merge two sorted arrays in O(1) space.
/*
Intution behind the approach:--
Aim:- We need to make sure that the 1st array should contain the lower values and the 2nd one with higher value elements such that there's no element in the 1st array i.e greater than any element in the 2nd array.
So, what's the benefit of it??

While sorting the arrays, we don't need to think about comparing the elements of two arrays.
We know that the 1st array can't have any element greater than any element of the second array.
When we don't require to do the same in constant space, we also think alike but instead of swapping we have the advantage of using the extra array.
Here, we have to modify both the arrays.

Input:-
5
4
1 2 7 9 12
3 5 11 13
Prior sorting,

we will get two arrays on comparing the highest element of the 1st array with the smallest element of the 2nd array:-
for(i--> 0 to min(m,n)-1) (i->0 to 3)
Iteration 1:-
arr1 (m=5) | arr2(n=4)
{1,2,7,9,12} | {3,5,11,13}

					if(arr1[4]>arr2[0])//is (12>3)?  yes
						so swap takes place.
Iteration 2:-
arr1 (m=5) | arr2(n=4)
{1,2,7,9,3} | {12,5,11,13}

					if(arr1[3]>arr2[1])//is (9>5)?  yes
						so swap takes place.
Iteration 3:-
arr1 (m=5) | arr2(n=4)
{1,2,7,5,3} | {12,9,11,13}

					if(arr1[2]>arr2[2])//is (7>11)?  no
						so swap doesn't take place.
Iteration 4:-
arr1 (m=5) | arr2(n=4)
{1,2,7,5,3} | {12,9,11,13}

					if(arr1[1]>arr2[3])//is (2>13)?  no
						so swap doesn't take place.
So, we get:-

arr1:- {1,2,7,5,3}
arr2:- {12,9,11,13}
Observation:- there's no element in the 1st array i.e greater than any element in the 2nd array.

x=min(m,n); //otherwise IndexOutofBoundException may occur
for (int i = 0; i < x; i++)
{
if (arr1[m - i - 1] > arr2[i])
{
swap(arr1[m - i - 1], arr2[i]);

        } 
    }  
now sort each array by reducing the gap after each iteration(similar to shell sort technique)
and as arr1 has m+n space.
Now, arr1:- 1,2,7,5,3
arr2=12,9,11,13
Can we sort each one of them in constant space??
Yes

For better understanding, you can read this:--
https://en.wikipedia.org/wiki/Shellsort

So , no. of elements in arr1=5,arr2=4
gap=function(5/2)=3
[Cause ceil(0.5) is 1,]

function(int gap){
if(gap<=1)return 0;
else
return (gap/2+gap%2);
}

Now the question arises why not insertion sort technique??
Suppose if elements( say 1 and 2 are at position 1 and 9), more no. of iterations are required.
**Idea:- **we start comparing elements that are far from each other rather than adjacent.

Here's my pen and paper explanation
*Check it out:-- * [https://drive.google.com/file/d/1khcjrkRnfBjf2YPPVA93skHpL4YoE15v/view]


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
       
       /*testing
       System.out.println("for arr1 :-- ");
      	for(int i=0;i<n;i++)
      		System.out.print(arr1[i]+" ");
       System.out.println();

       System.out.println("for arr2 :-- ");
      	for(int i=0;i<m;i++)
      		System.out.print(arr2[i]+" ");
      	System.out.println();*/

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
      	/*//Test1
      	System.out.println("for arr1 :-- ");
      	for(int i=0;i<n;i++)
      		System.out.print(arr1[i]+" ");
       System.out.println();*/
       
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
        /*System.out.println("for arr2 :-- ");
      	for(int i=0;i<m;i++)
      		System.out.print(arr2[i]+" ");
      	System.out.println();*/

        for (int i = 0; i < n; i++)  
            System.out.print(arr1[i] + " ");  
        for (int j = 0; j < m; j++)  
            System.out.print(arr2[j] + " ");  

	}
}
