#include<stdio.h>
#include<conio.h>
int maximum(int a,int b)
{
	return (a>b)?a:b;
}
int main()
{
	int a[100];
	int n,k,i;
	printf("Enter the number of elements :---  ");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
	}
	printf("Enter the maximum sum you want ... :---   ");
	scanf("%d",&k);
	int sum=0,cnt=0,maxcnt=0;
	for(i=0;i<n;i++)
	{
		if(sum+a[i]<=k)
		{
			sum+=a[k];
			cnt++;
		}
		else if(sum!=0){
			sum+=a[i]-a[i-cnt];
		}
		maxcnt=maximum(cnt,maxcnt);
		
	}
	printf("\n%d",maxcnt);
	
	return 0;
	
}

