//Merge two sorted arrays in O(1) space.

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