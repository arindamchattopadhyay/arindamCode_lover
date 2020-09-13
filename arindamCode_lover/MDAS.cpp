#include<stdio.h>
int mdas_comput(int n);
int main()
{
	int n;
	scanf("%d",&n);
	
	printf("MDAS VALUE:--  %d",mdas_comput(n));
	
	return 0;
}

int mdas_comput(int n)
{
	if(n<=2)
		return n;
	else if(n==3||n==4)
		return (n+3);
	else if((n-4)%4==0)
		return (n+1);
	else if((n-4)%4<=2)
		return (n+2);
	else
		return (n-1);
}
