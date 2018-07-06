import mysql.connector
import sys
class tinder:
    def __init__(self):
        #Connect to database
        self.conn=mysql.connector.connect(host='localhost',user='root',password='',database='tinder3')#When the code and database are kept in the same place.
        self.mycursor=self.conn.cursor()
        self.program_menu()
    def program_menu(self):
        program_input=input("""Hi!!! What would you like to do?
        1. Enter 1 to create account
        2. Enter 2 to login
        3. Anything else to exit""")
        if program_input=='1':
            self.register()

        elif program_input=='2':
            self.login()
        else:
                print("Bye")
    def register(self):
        name=input("Name")
        email=input("Email")
        password=input("Password")
        gender=input("Gender")
        age=input("Age")
        city=input('City')
        self.mycursor.execute("""SELECT `user_id` FROM `users` WHERE `email`='{}'""".format(email))
        checking_duplicat = self.mycursor.fetchall()
        if len(checking_duplicat) > 0:
            error = 'Email Id Already Exists !'
        # FIX validate email
        if '@' not in email:
            error = 'Invalid Email Id.'
        # FIX Password must be greater than 4 charecter
        if len(password) < 4:
            error = 'Password must be greater than or equal to 4 characters.'
        if error == 0:
            self.mycursor.execute("""INSERT INTO `users` (`user_id`,`name`,`email`,`age`,`gender`,`city`,`password`)
        	VALUES (NULL,'{}','{}','{}','{}','{}','{}')""".format(name, email, age, gender, city, password))
            self.conn.commit()
            print("Registration Successfull !")
            self.program_menu()
        else:
            print("Error : ", error)
            self.program_menu()
            #Trying to make this process better..because I am new to Dbms..!!Sorry for it!!
        #mysql.connector.errors.IntegrityError: 1062(23000): Duplicate
        #entry
        #'arindam@gmail.com'---------I need to handle this exception
        #for key 'UC_users'
    def login(self):
        email = input("Enter the email:- ")
        password = input("Enter the password:-  ")
        self.mycursor.execute("""SELECT * FROM `users` WHERE `email` LIKE '{}'AND `password` LIKE  '{}'""".format(email,password))
        #We are asking question to database, The database will answer and we will logically solve it
        user_list=self.mycursor.fetchall()#It will return a value,it will be given by database
        counter=0
        for i in user_list:
            counter=counter+1
            current_user = i
        if counter>0:
            print("Welcome")
            self.current_user_id=current_user[0]
            print(self.current_user_id)
            self.user_menu()
        else:
            print("Incorrect")
            self.program_menu()
    def user_menu(self):
        user_input=input(""""How would you like to proceed??
        1.Enter 1 to view all users
        2.Enter 2 to view proposals
        3.Enter 3 to view requests
        4.Enter 4 to view matches
        5.Enter any other key to LogOut""")
        if user_input=='1':
            self.view_users()
        elif user_input=='2':
            self.view_proposals()
        elif user_input=='3':
            self.view_requests()
        elif user_input=='4':
            self.view_matches()
        else:
            self.log_out()
    def view_users(self):
        self.mycursor.execute(
            """SELECT `user_id`,`name`,`gender`,`age`,`city` FROM `users` WHERE `user_id` NOT LIKE '{}' AND `user_id` NOT IN(SELECT `juliet_id` FROM `proposals` WHERE `romeo_id`='{}')""".format(
                self.current_user_id, self.current_user_id))
        all_users_list=self.mycursor.fetchall()
        for i in all_users_list:
            print('--------------------------------------------')
            print(i[1], i[2], i[3], i[4], sep=' | ')
            # NEW Propose or Pass style for each user
            yes_or_no = input("""Enter Choice :
        		1 - Propose
        		2 - Pass
        		3 - Menu \n""")
            if yes_or_no == '1':
                self.propose(self.current_user_id, i[0])
            elif yes_or_no == '3':
                break

        self.user_menu()
    def propose(self,romeo_id,juliet_id):
        c=0
        self.mycursor.execute("""INSERT INTO `proposals` (`proposal_id`,`romeo_id`,`juliet_id`) VALUES (NULL,'{}','{}')""".format(romeo_id,juliet_id))
        #self.mycursor.execute("""SELECT * FROM `proposals` WHERE `romeo_id` LIKE '{}'""".format(self.current_user_id))
        #one_time_propose_list=self.mycursor.fetchall()
        self.conn.commit()
    def view_proposals(self):
        #The data is distributed in multiple tables..Here the proposal_id are there in proposals tables but we need to show them the name.. For that we need to join users and proposals
        print("The users whom you have proposed are :---- ")
        self.mycursor.execute("""SELECT * FROM `proposals` p JOIN `users` u
        ON p.`juliet_id`=u.`user_id`
        WHERE p.`romeo_id` LIKE '{}'""".format(self.current_user_id))
        proposed_user_list = self.mycursor.fetchall()
        for i in proposed_user_list:
            print(i[4], '|', i[7], '|', i[8], '|', i[9])
            print("-------------------------------------------")
        self.user_menu()
    def view_requests(self):
        #The data is distributed in multiple tables..Here the proposal_id are there in proposals tables but we need to show them the name.. For that we need to join users and proposals
        print("The requests are:---- ")
        self.mycursor.execute("""SELECT * FROM `proposals` p JOIN `users` u
        ON p.`romeo_id`=u.`user_id`
        WHERE p.`juliet_id` LIKE '{}'""".format(self.current_user_id))
        requests_user_list = self.mycursor.fetchall()
        for i in requests_user_list:
            print(i[4], '|', i[7], '|', i[8], '|', i[9])
            print("-------------------------------------------")
        self.user_menu()
    def view_matches(self):
        print("The matches are :---  ")
        self.mycursor.execute(
            """SELECT `name`,`gender`,`age`,`city` FROM `users` WHERE `user_id` IN (SELECT `juliet_id` FROM `proposals` WHERE `romeo_id` LIKE '{}' AND `juliet_id` IN (SELECT `romeo_id` FROM `proposals` WHERE `juliet_id` LIKE '{}'))""".format(
                self.current_user_id, self.current_user_id))
        request_user_list = self.mycursor.fetchall()
        for match_user_data in request_user_list:
            print(match_user_data[0],match_user_data[1],match_user_data[2],match_user_data[3],sep=' | ')
            print("-----------------------------------------------------------------------")
        self.user_menu()
    def log_out(self):
        #self.current_user_id = ''#Also we can use sys.exit("Logged out").. On encountering that process,we would have to login  by running this code again...which I consider a bit hectic..!!
        self.program_menu()
user=tinder()