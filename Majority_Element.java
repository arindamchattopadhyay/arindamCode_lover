/*Majority Element in an array, provided there's only one such element
We can easily solve it with the help of hash map. But we will use a brute force method optimally in constant space.

*/

import java.util.*;
public class Majority_Element{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		int el=-1,cnt=0;
		for(int i=0;i<n;i++)
		{
			if(cnt==0)//Suppose we have 5 (3) times,4(1) time and 2(2) times, so, we can see that we don't have any majority.(3-3=0 cancelling out)
				el=a[i];
			if(a[i]==el)
				cnt++;
			else
				cnt--;
		}
		System.out.println("The majority element in the array is :- "+el);
	}
}
/*
Statement 1:- If the no. of elements is greater than (no.OfElements/3) then we are going to consider it as majority element.
If we want to do the same  in contant space and linear time complexity.
We need to take the similar approach but then there's a possiblilty of 2 elements having mthe majority.
For example,
if no. of elements(n)= 2
And the elements are [1,2] 
So, which is the majority element,
both 1 and 2.
SImilarly for {1,1,2,5,2,8,9,5}
Here n=8, but we don't have any element occuring more than 3 times.,
so, we'll not have any elements.


SImilarly for [1,1,5,5,1,7,5]
n=7
We have 1 and 5 occuring 3 times.
So, both can be considered as majority(From Statement 1)

SO, we 'll return 1 and 5.

Here's the code:---




class Solution {
    public static List<Integer> majorityElement(int[] a) {
        int num1=-1,num2=-1,c1=0,c2=0;
        int n=a.length;
        for(int i=0;i<n;i++)
        {
           if(num1==a[i])
               c1++;
            else if(num2==a[i])
               c2++;
            else if(c1==0)
                num1=a[i];
            else if(c2==0)
                num2=a[i];
            else{
                c1--;
                c2--;
            }
        }
        ArrayList<Integer> ob=new ArrayList<>();
        c1=0;c2=0;
        for(int i=0;i<n;i++)
        {
            if(num1==a[i])
                c1++;
            if(num2==a[i])
                c2++;
            
        }
        if(c1>n/3)
            ob.add(num1);
        if(c2>n/3)
            ob.add(num2);
        
        return ob;
    }
    public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		ArrayList<Integer> t=majorityElement(a);
		System.out.println("The majority elements in the array are :- "+t);
	}
}

https://ide.geeksforgeeks.org/jtUpZVDEwR



*/
