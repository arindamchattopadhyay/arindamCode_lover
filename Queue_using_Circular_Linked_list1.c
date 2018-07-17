#include <stdio.h>
#include <stdlib.h>
 struct node
{
    int data;
    struct node *link;
};
 
struct node *head = NULL, *x, *y, *z;
int t=1;
void ins_at_end();
void del_at_beg();
void traverse();
 
int main()
{
    int ch;
 
    printf("\n 1.Enqueue\n 2.Dequeue");
    printf("\n3.traverse ");
    printf("\n0.Press 0 to Exit\n");
    do
    {
        printf("\n Enter your choice:");
        scanf("%d", &ch);
        switch(ch)
        {
		case 0:
			printf("Exit..Bye  bye");
			exit(0);
			break;
            case 1:
            	ins_at_end();
            	break;
            	case 2:
            		del_at_beg();
            		break;
            		case 3:
            			traverse();
            			break;
            			default:
            				printf("\nWRONG CHOICE");
            			}
            		}while(ch!=0);
            		return 0;
            	}
            
            			
            	
 
struct node *create(struct node *head)
{
    int c;
 
    x = (struct node*)malloc(sizeof(struct node));
    printf("\n Enter the data:");
    scanf("%d", &x->data);
    x->link = x;
    head = x;
    return head;
}
void ins_at_end()
{
    struct node *ptr;
    struct node *temp = create(head);
    if (head == NULL)
    {
       head = temp; 
    }
    ptr = head;
    while (ptr->link != head)
    {
        ptr = ptr->link;
    }
    printf("Rear element is :- %d",temp->data);
    ptr->link = temp;
    temp->link = head;
	
}
void del_at_beg()
{    
	if (head == NULL) 
        printf("\n List is empty");
    
	else if(head->link==head){
	x=head;
	
	if(t==1){
	printf("%d has been deleted !!!",x->data);
	printf("\nList is empty .. ");
	t++;
	}
	
	else{
	printf("\nList empty");
	}
}
	

    else
    {
        x = head;
        y = head;
        while (x->link !=  head)
        {
            x = x->link;
        }
        head = y->link;
        x->link = head;
        printf("Deleted element is :--   %d ",y->data);
        free(y);

        
    }
}
void traverse()
{
    if (head == NULL)
        printf("\n List is empty");
    else
    {
        x = head;
        while (x->link !=  head)
        { 
            printf("%d->", x->data);
            x = x->link;
        }
        printf("%d", x->data);
    }
}
