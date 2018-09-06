#include<stdio.h>
#include<conio.h>
#include<limits.h>
//Recursive implementation

int eggdrop(int,int);
int max(int a,int b)
{
	if(a>b)
		return a;
	else
		return b;
}
int eggdrop(int e,int n)
{
	int min,res=0,x;
	//n number of floors.. e number of eggs
	if(n==1||n==0)
		return n;
	if(e==1)
	 return n;
	min=INT_MAX;
	for(x=1;x<=n;x++)
	{
		res= max(eggdrop(e-1,x-1),eggdrop(e,n-x));
		if(res<min)
			min=res;
			
	}
	
	 return min+1;
}

int main()
{
	int n,e,min_trials;
	printf("\n\nEnter the no. of eggs and the number of floors :---   ");
	scanf("%d%d",&e,&n);
	
	printf("\nThe total no. of trials is :--    %d  ",eggdrop(e,n));
	getch();
	return 0;
}
