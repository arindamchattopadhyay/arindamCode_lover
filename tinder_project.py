# tinder_gui
import time
from tkinter import *
import mysql.connector


class Login:
    def __init__(self):
        self.conn = mysql.connector.connect(host="localhost", user="root", password="", database="tinder3")
        self.mycursor = self.conn.cursor()
        self.root = Tk()
        self.root.resizable(height=False, width=True)
        self.root.minsize(200, 200)
        self.login_form()
        self.root.mainloop()

    def dashboard(self):
        menu = Frame(self.root)
        menu.pack()
        Button(menu, text='View All User', command=lambda: self.view_all_user(),bg='wheat2',fg="violetred4").pack(side=LEFT, expand=True, fill=X)
        Button(menu, text='View Proposal', command=lambda: self.view_proposal(),bg='wheat2',fg="violetred4").pack(side=LEFT, expand=True, fill=X)
        Button(menu, text='View Requests', command=lambda: self.view_requests(),bg='wheat2',fg="violetred4").pack(side=LEFT, expand=True, fill=X)
        Button(menu, text='View Matches', width=13, command=lambda: self.view_matches(),bg='wheat2',fg="violetred4").pack(side=LEFT, expand=True,
                                                                                              fill=X)
        Button(menu, text='Logout', width=13, command=lambda: self.logout(),bg='gray9',fg='mint cream').pack(side=LEFT, expand=True, fill=X)

    def view_all_user(self, i=0):
        self.auth()
        self.mycursor.execute(
            """SELECT `user_id`,`name`,`gender`,`age`,`city` FROM `users` WHERE `user_id` NOT LIKE '{}' AND `user_id` NOT IN(SELECT `juliet_id` FROM `proposals` WHERE `romeo_id`='{}')""".format(
                self.current_user_id, self.current_user_id))
        all_users_list = self.mycursor.fetchall()

        self.clearAll()
        self.root.title('View All User')
        self.root.configure(background="midnight blue")
        self.dashboard()
        display = Frame(self.root)
        display.pack()
        if i < len(all_users_list):
            userData = all_users_list[i]
            userStr = """Name: {} \nGender: {} \nAge: {} \nCity: {}""".format(userData[1], userData[2], userData[3],
                                                                              userData[4])
            Label(display, text=userStr).pack()
            Button(display, text='Propose', width=15, command=lambda: self.propose(userData[0], i + 1),bg="red4",fg="gold").pack(side=LEFT)
            Button(display, text='Pass', width=15, command=lambda: self.view_all_user(i + 1),bg="green3",fg="lavender").pack(side=RIGHT)
        else:
            Label(display, text='No more users. Try later.').pack()

    def propose(self, juliet_id, next_user_id):
        self.auth()
        self.mycursor.execute(
            """INSERT INTO `proposals` SET `romeo_id`='{}',`juliet_id`='{}'""".format(self.current_user_id, juliet_id))
        self.conn.commit()
        self.view_all_user(next_user_id)

    def view_proposal(self):
        self.auth()
        self.mycursor.execute(
            """SELECT u.`name`,u.`gender`,u.`city`,u.`age` FROM `proposals` p JOIN `users` u ON p.`juliet_id` = u.`user_id` WHERE p.`romeo_id` LIKE '{}'""".format(
                self.current_user_id))
        proposed_user_list = self.mycursor.fetchall()

        self.clearAll()
        self.root.title('View Proposal')

        self.dashboard()
        if len(proposed_user_list)==0:
            Label(self.root, text="You haven't proposed anyone\nGo to-->  View All User tab ",bg='white',fg='black',font="Times 16").pack()
        else:
            self.root.configure(background="wheat1")
            for i in proposed_user_list:
                userData = '  ||  '
                userData = userData.join(str(x) for x in i)
                Label(self.root, text=userData,bg='white',fg='black').pack()

    def view_requests(self):
        self.auth()
        self.mycursor.execute(
            """SELECT u.`name`,u.`gender`,u.`city`,u.`age` FROM `proposals` p JOIN `users` u ON p.`romeo_id` = u.`user_id` WHERE p.`juliet_id` LIKE '{}'""".format(
                self.current_user_id))
        request_user_list = self.mycursor.fetchall()

        self.clearAll()
        self.root.title('View Requests')

        self.dashboard()
        if len(request_user_list)==0:
            self.root.configure(background='yellow')
            Label(self.root, text="\nYou have no requests,yet..\n#Keep_Calm_And_U_will_get_someone",bg='pink', fg='black',font="Times 32").pack()
        else:
            self.root.configure(background='SeaGreen1')
            for i in request_user_list:
                userData = '  ||  '
                userData = userData.join(str(x) for x in i)
                Label(self.root, text=userData).pack()

    def view_matches(self):
        self.auth()
        self.mycursor.execute(
            """SELECT `name`,`gender`,`age`,`city` FROM `users` WHERE `user_id` IN (SELECT `juliet_id` FROM `proposals` WHERE `romeo_id` LIKE '{}' AND `juliet_id` IN (SELECT `romeo_id` FROM `proposals` WHERE `juliet_id` LIKE '{}'))""".format(
                self.current_user_id, self.current_user_id))
        matched_user = self.mycursor.fetchall()

        self.clearAll()
        self.root.title('View Matches')

        self.dashboard()
        if len(matched_user)==0:
            self.root.configure(background='white')
            Label(self.root, text="NO MATCHES YET...\n #PATIENCE!!!   ",bg='pink', fg='black',font="Times 32").pack()
        else:
            self.root.configure(background='CadetBlue1')
            for i in matched_user:
                userData = '  ||  '
                userData = userData.join(str(x) for x in i)
                Label(self.root, text=userData,bg='misty rose',fg='red4').pack()

    def login_form(self):
        self.clearAll()
        self.root.title('Login')
        self.root.configure(background="dark slate gray")

        self.email_label = Label(self.root, text='Email: ', width=15).grid(row=0, column=0, padx=10, pady=10)
        self.email_input = Entry(self.root, width=30)
        self.email_input.grid(row=0, column=1, padx=10, pady=10)
        self.password_label = Label(self.root, text='Password: ', width=15).grid(row=1, column=0, padx=10, pady=10)
        self.password_input = Entry(self.root, width=30,show="*")
        self.password_input.grid(row=1, column=1, padx=10, pady=10)
        self.result = Label(self.root, text='', fg='red')
        self.result.grid(row=2, column=0, columnspan=2)
        Button(self.root, text='Login', width='15', command=lambda: self.login(),bg='bisque',fg='gray8').grid(row=3, column=0, columnspan=2,
                                                                                       padx=10, pady=10)
        Button(self.root, text='Register', width='15', command=lambda: self.registration_form(),bg='maroon1',fg='gray8').grid(row=4, column=0,
                                                                                                      columnspan=2,
                                                                                                      padx=10, pady=10)

    def registration_form(self):
        self.root1 = Tk()
        self.root1.title('Register')
        self.root1.configure(background="white")
        self.root1.minsize(500, 500)
        self.root1.maxsize(500, 500)

        name_label = Label(self.root1, text='Enter Name: ',bg='peach puff',fg='grey4')
        name_label.pack()
        self.r_name_input = Entry(self.root1)
        self.r_name_input.pack()

        email_label = Label(self.root1, text='Enter Email: ',bg='peach puff',fg='grey4')
        email_label.pack()
        self.r_email_input = Entry(self.root1)
        self.r_email_input.pack()

        password_label = Label(self.root1, text='Enter Password: ',bg='peach puff',fg='grey4')
        password_label.pack()
        self.r_password_input = Entry(self.root1,show='*')
        self.r_password_input.pack()

        age_label = Label(self.root1, text='Enter Age: ',bg='peach puff',fg='grey4')
        age_label.pack()
        self.r_age_input = Entry(self.root1)
        self.r_age_input.pack()

        gender_label = Label(self.root1, text='Enter Gender: ',bg='peach puff',fg='grey4')
        gender_label.pack()
        self.r_gender_input = Entry(self.root1)
        self.r_gender_input.pack()

        city_label = Label(self.root1, text='Enter City: ',bg='peach puff',fg='grey4')
        city_label.pack()
        self.r_city_input = Entry(self.root1)
        self.r_city_input.pack()

        self.r_button_register = Button(self.root1, text='Register', command=lambda: self.register(),bg='deep pink',fg='grey1')
        self.r_button_register.pack()

        self.r_result = Label(self.root1, text='', fg='red')
        self.r_result.pack()

        self.root1.mainloop()

    def login(self):
        email = self.email_input.get()
        password = self.password_input.get()

        self.mycursor.execute(
            """SELECT * FROM `users` WHERE `email` LIKE '{}' AND `password` LIKE '{}'""".format(email, password))

        user_list = self.mycursor.fetchall()

        if len(user_list) > 0:
            #self.result.configure(text=)
            #Label(self.root, text="Welcome\nEntered at :---   ", bg="black",fg="yellow").pack()
            self.current_user_id = user_list[0][0]
            self.view_all_user()
        else:
            self.result.configure(text='Incorrect Credentials')

    def register(self):
        name = self.r_name_input.get()
        email = self.r_email_input.get()
        password = self.r_password_input.get()
        age = self.r_age_input.get()
        gender = self.r_gender_input.get()
        city = self.r_city_input.get()
        error = 0;
        # FIX issue 1. Duplicate Registration
        self.mycursor.execute("""SELECT `user_id` FROM `users` WHERE `email`='{}'""".format(email))
        checking_duplicat = self.mycursor.fetchall();
        if len(checking_duplicat) > 0:
            error = 'Email Id Already Exists !'
        # FIX validate email
        if '@' not in email:
            error = 'Invalid Email Id.'
        # FIX Password must be greater than 4 charecter
        if len(password) < 4:
            error = 'Password must be greater than 4 characters.'

        if error == 0:
            self.mycursor.execute("""INSERT INTO `users` (`user_id`,`name`,`email`,`age`,`gender`,`city`,`password`)
			VALUES (NULL,'{}','{}','{}','{}','{}','{}')""".format(name, email, age, gender, city, password))
            self.conn.commit()
            self.r_result.configure(text='Registration Successfull ! Please Login.')
        else:
            self.r_result.configure(text='Error : ' + error)

    def clearAll(self):
        for child in self.root.winfo_children():
            child.destroy()

    def auth(self):
        # FIX ISSUE 3. Authentication
        if self.current_user_id == '':
            self.login_form()

    def logout(self):
        # FIX ISSUE 4. Logout
        self.current_user_id = ''
       # Label(self.root, text="Logged Out", bg="white", fg="red", font=" Times 16")
        self.clearAll()
        self.login_form()


ob = Login()

