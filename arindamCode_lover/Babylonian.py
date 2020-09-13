class Square_Root_Without_function:
    def babylonian(self,n):
        x=n
        e=0.0000001
        y=0
        while x-y>e:
            x = (x+y)/2
            y=n/x
        return x
ob = Square_Root_Without_function()
x = int(input("Enter the number ----   "))
print(round(ob.babylonian(x),3))
