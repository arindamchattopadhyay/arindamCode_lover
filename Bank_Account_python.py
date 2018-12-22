# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
import random
import time

class Bank:
    balance=0
    customer_id=''
    name=''
    mobile_no=''
    pan_card=''
    deposit1=[]
    deposit_t=[]
    withdraw1=[]
    withdraw_t=[]
    def __init__(self,initial_amount):
        if initial_amount<0:
            print("Negative entry !! ")
            return
        self.name=input("Enter your name :--- ");
        self.mobile_no=input("\nEnter your mobile no.--- ")
        if len(self.mobile_no)!=10:
            print("INVALID MOBILE NUMBER ")
            return
            
        self.pan_card=input("\nEnter the pan card :---   ")
        if len(self.pan_card)!=6:
            print('LENGTH OF PAN CARD NUMBER SHOULD BE 6!! ')
            return
        self.balance=self.balance+initial_amount
            
        self.customer_id=random.randint(1000,10000)
        print("************CREDENTIALS*******")
        print("\nName :---  ",self.name)
        print("\nMobile no.---  ",self.mobile_no)
        print("\nPan Card ---  ",self.pan_card)

        print('HI your account has been created successfully!!')
        print('Your account id is:',self.customer_id)
        print('And your account balance is:',self.balance)

        self.menu()
    def menu(self):
        
        pan_no=''
        user_input=input("""How would you like to proceed?
        
            
            1.Enter 1 to deposit money
            2.Enter 2 to withdraw money
            3.Enter 3 to print balance
            4.Anything else to exit
            Your choice:""")

        if user_input=='1':
            self.deposit()
            print('Date                         DEPOSITS \n ----------------------------------------------------- \n')
            for i in range(0,len(self.deposit1)):
                print(self.deposit_t[i],self.deposit1[i],sep='        ')
        elif user_input=='2':
            self.withdraw()
            print('                             Date                     WITHDRAWL \n ----------------------------------------------------- ')
            for i in range(0,len(self.withdraw_t)):
                print("                     ",self.withdraw_t[i],self.withdraw1[i],sep='       ')
        elif user_input=='3':
            self.print_balance()
        else:
            
            print("Bye!!")
    def deposit(self):
        amount = int(input("Enter the amount you want to deposit :--    "))
            
        if amount<0:
            print("Negative amount !!! ")
            return
        elif amount<200000:
            self.balance = self.balance+amount
            print("Amount Rs. ",amount," deposited successfully")
            self.deposit1.append(amount)
           
            self.deposit_t.append(time.asctime( time.localtime(time.time()) ))
            self.print_balance();
        else:
            pan_no=input("Enter the pan card no.--- ")
            if pan_no==self.pan_card:
                print("\nYou have entered correct pan number !! ")
                amount = int(input("Enter the amount you want to deposit :--    "))
                self.balance = self.balance+amount
                print("Amount Rs. ",amount," deposited successfully")
                self.deposit1.append(amount)
               
                self.deposit_t.append(time.asctime( time.localtime(time.time()) ))
                self.print_balance();
            else:
                print("\nEntered Incorrect Pan card no.")
                self.print_balance()

                
    def withdraw(self):
        
        amount = int(input("Enter the amount you want to withdraw :---   "))
        
        if self.balance>1000 and amount<self.balance:
            self.balance = self.balance-amount
            print("Amount Rs. ",amount," withdrawn successfully")
            
            self.withdraw1.append(amount)
            self.withdraw_t.append(time.asctime( time.localtime(time.time()) ))
            self.print_balance()
        else:
            print("Insufficient amount!!!")
            self.menu()
    def print_balance(self):
        print("\nName :---  ",self.name)
        print("\nMobile no.---  ",self.mobile_no)
        print("\nPan Card ---  ",self.pan_card)
        print('Your account id is:',self.customer_id)
        print('And your account balance is:',self.balance)
        self.menu()


    #Driver Program

user=[]
ch=5
c=6
while ch!=0:
    ch=int(input("To add user ....Press 1 .. Else 0.. :--- "))
    if ch!=0:
        user.append(Bank(int(input("Enter the A/C opening amount:---  "))))
        
    else:
        print("\nDo You Want to See your record ?? ")
        c=5
        while c!=0:
            c=int(input("Press 1.. To Know your balance and further account Related Operations\n\nPress 0 to exit"))
            if c==0:
                acc_no=0
            acc_no=int(input("\nEither Enter the account number :-- \n or otherwise :- IF YOU WANT TO EXIT .. PRESS 0\n"))
            for i in range(0,len(user)):
                if user[i].customer_id==acc_no:
                    print("Account number matched!!! ")
                    print('********Display****\n\n','NAME :-- ',user[i].name,'A/C no.__--     ',user[i].customer_id,'A/C Balance :--  ',user[i].balance,sep='   ');
                    user[i].menu()
            if i==len(user):
                print(acc_no," Wrong A/C no.")
                c=0
        ch=3
