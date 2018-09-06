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
