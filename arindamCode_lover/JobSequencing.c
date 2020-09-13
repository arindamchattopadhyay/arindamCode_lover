#include<stdio.h>
#include<conio.h>

struct Job{
	char jobname[100];
	int deadline;
	int profit;//That's the money u get if u can finish the work within the deadline
};

int main()
{
		int i, j,n;
	struct Job jobs[100];

   //LIST ITEMS

 //Considering that nothing is free
	printf("\nEnter the no. of items   :-- ");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		printf("\n\n\n\n\nFor \t %d  item\n",i+1);
		printf("\nName of the job :---  ");
		scanf("%s",&jobs[i].jobname);
		fflush(stdin);
		printf("\nEnter the deadline :---  ");
		fflush(stdin);
		scanf("%d",&jobs[i].deadline);
		printf("\nEnter the profits :---  ");
		fflush(stdin);
		scanf("%d",&jobs[i].profit);
		
   }
		struct Job temp;
		for(i=0;i<n-1;i++)
		{
			for(j=0;j<n-i-1;j++)
			{
				if(jobs[j+1].profit>jobs[j].profit)
				{
					temp=jobs[j+1];
					jobs[j+1]=jobs[j];
					jobs[j] = temp;
				}
			}
		}
			for(i = 0; i <n; i++){
		printf("Jobs : %s\tDeadline : %d\tProfits: %d\n", jobs[i].jobname, jobs[i].deadline, jobs[i].profit);
	}	
		printf("\n\n\n");
		jobsequencing(jobs,n);
		getch();
		return 0;
}

void jobsequencing(struct Job jobs[],int n)
{
	int arr[80],i,j;
	int max=jobs[0].deadline;
	int total_profit=0;
	for(i=1;i<=n;i++)
	{
		if(jobs[i].deadline>max)
		{
			max=jobs[i].deadline;
		}
		
	}
	
	for(i=1;i<=max;i++)
			arr[i] = -1;
	
	for(j=0;j<n;j++)
	{
		if(arr[jobs[j].deadline]==-1){
				total_profit+=jobs[j].profit;
				arr[jobs[j].deadline]=jobs[j].deadline;
				printf("\nSelected job is   %s\tDeadline :---   %d\tProfit:--     %d  \n",jobs[j].jobname,jobs[j].deadline,jobs[j].profit);	
			}
			//If all the slots are filled
		else if(arr[jobs[j].deadline]!=-1){
				int c=0;
						for(i=1;i<=max;i++){
						if(arr[i]!=-1)
						   c++;
					}
					if(c==max+1)
						break;
				}
			
		else{
						i=j;
				while(jobs[i].deadline>=1){
				if(arr[--(jobs[i].deadline)]==-1){
					
					arr[jobs[i].deadline]=jobs[i].deadline;
				total_profit+=jobs[i].profit;
				printf("\nSelected job is   %s\tDeadline :---   %d\tProfit:--     %d  \n",jobs[i].jobname,jobs[i].deadline,jobs[i].profit);
		
		
				break;
		}
		}		
	}
}
	printf("\n\nMaximum profit =  %d",total_profit);

}
