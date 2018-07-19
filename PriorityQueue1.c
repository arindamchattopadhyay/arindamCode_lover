#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
void insert(int,int);
void del();
void traversal();


struct node{
int priority;
int data;
struct node *next;
};
struct node *head;


void insert(int ele,int pri)
{
	struct node *temp, *t;
	temp = (struct node *)malloc(sizeof(struct node));
	temp->data=ele;
	temp->priority=pri;
	temp->next=NULL;
	
	if(head==NULL)
		head = temp;

	else if(head->priority>pri)//Through sorted list..This will facilitate the  higher priority node to get deleted first.. 
	{
		temp->next=head;
		head=temp;
	}
	else
	{
		t=head;
		while(t->next!=NULL && (t->next)->priority<=pri )//Here if the current priority is less than the priority of the element in the given list,the loop terminates
			t=t->next;

		temp->next=t->next;
		t->next=temp;
	}
traversal();//Easy for the user  to see the existing state of the list without pressing any other key
}

//******DELETION***
void del()
{
int t,k;
	if(head!=NULL){
	t=head->data;
	k=head->data;
	printf("\n\nMember deleted --->>  %d with  priority --->>>  %d",t,k);
	head=head->next;

//free(t);//As I have called the traversal method, the head will be automatically upgraded.. No need to explicitly free the dynamic space.

traversal();
}
else
printf("\n\nLIST IS EMPTY");

}

//****DISPLAY****
void traversal()
{
if(head==NULL)
printf("\nList is empty");
else{
printf("\nThe elements there are :--   \n");

struct node *p;
p=head;
printf("\nPriority --> Data\n");
printf("\n--------------------\n");
while(p->next!=NULL)
{
printf("\n%d -->  %d",p->priority,p->data);

p=p->next;
}
printf("\n%d -->  %d",p->priority,p->data);
}
}

int main()
{
//Driver program
printf("\n1.>ENQUEUE\n\n2.>DEQUEUE\n\n4.>PRESS 0 TO QUIT");
int c;
int e,p;
do{
printf("\n\nEnter the choice :-    ");
scanf("%d",&c);
switch(c){
case 0:
printf("Bye\nBye..Exit");
break;

case 1:
printf("\nEnter the data and set it's priority :-  ");
scanf("%d%d",&e,&p);
insert(e,p);
break;
case 2:
del();
break;
default:
printf("\nWrong choice!!");
break;

}
}while(c!=0);
}