#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
void kadane(int arr[],int n);
int main()
{
	int no_test_cases,c=0,n,i;
	int arr[50];//{-4,-3,-2,-2,-3,-1,-2,-3,-4,-2,-6,-3,-1,-3,-1,-2};
	printf("\nEnter the no. of test cases :--  ");
	scanf("%d",&no_test_cases);
	
	while(c<no_test_cases)
	{
		printf("\nEnter the size of the array :---  ");
		scanf("%d",&n);
		for(i=0;i<n;i++)
		{
			printf("\nEnter the %dth element :---  ",(i+1));
			scanf("%d",&arr[i]);
		}
		
		kadane(arr,n);
		c++;
	}
	//kadane(arr,3);
	getch();
	return 0;
}
void kadane(int arr[],int n)
{
	int max_so_far=arr[0];
	int min_ending_here=0;
	int start=0,s=0,end=0;
	int i;
	for(i=0;i<n;i++)
	{
		min_ending_here=min_ending_here+arr[i];
		
		if(max_so_far<min_ending_here){
			
			max_so_far=min_ending_here;
			start = s;
			end=i;
		}
		if(min_ending_here<0)
			{
				min_ending_here=0;
				s = i+1;
			}
	}
	printf("\nThe largest sum of the subarray is :-- %d",max_so_far);
	printf("\nThe subarray is :--   ");
	for(i=start;i<=end;i++)
	{
		printf(" %d\t",arr[i]);
	}
}
//Kadane's Algorithm
//We are required to find the largest sum contiguous array.
import java.util.*;
public class KadaneAlgo{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		//O(n^3)
		/*
		int max=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				int sum=0;
				for(int k=i;k<j;k++)
				{
					sum+=a[k];

				}
				max=Math.max(max,sum);
			}
		}
		System.out.println(max);
		o(n^2)*/
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			int currmax=0;
			for(int j=i;j<n;j++)
			{
					currmax=Math.max(a[j],a[j]+currmax);

					max=Math.max(currmax,max);
			}
		}
		System.out.println(max);
		/*int max=0,currmax=0,sum=0,s=0,end=0,start=0;
		for(int i=1;i<n;i++){
			currmax+=a[i];
			if(max<currmax)
			{
				max=currmax;
				start=s;
				end=i;
			}
			if(currmax<0)
			{
				currmax=0;
				s=i+1;
			}


			
		}
		System.out.println(max+" Start index:- "+start+" End index:- "+(end));*/
	}
}
/*

IP:- 
5
9 -8 -1 -7 2
8
-2 -3 4 -1 -2 1 5 -3
*/
