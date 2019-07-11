#include<stdio.h>
#include<limits.h>
void second_greatest(int a[],int n);
int main()
{
	int n,i;
	int a[1000];
	scanf("%d",&n);
	
	for(i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
		
	}
	for(i=0;i<n;i++){
	
	printf("%d ",a[i]);
	}
	second_greatest(a,n);
	
	return 0;
}
void second_greatest(int a[],int n)
{
	int f_greatest=INT_MIN;
	int s_greatest=INT_MIN;
	int i;
	if(n>=2){
	
	for(i=0;i<n;i++)
	{
		if (a[i] > f_greatest) {
				s_greatest = f_greatest;
				f_greatest = a[i];
 
			}
			 else if (a[i] > s_greatest&&a[i]!=f_greatest) {
				s_greatest = a[i];
 
			}
	}
	if(s_greatest!=INT_MIN)
	printf("\n %d",s_greatest);
	else
	printf("\nNo second Greatest is here.. !!");
}
else
printf("\n%d is the only integer present ... ",a[0]);
}
