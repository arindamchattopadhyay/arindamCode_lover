import math
class NumbertoWords:
    s=""
    def one_to_hundred(self,m):
        if m == 0:
            self.s = "Zero"
        else:
            while m != 0:
                if m == 1:
                    self.s = self.s + " One"
                    m = 0
                elif m == 2:
                   self.s = self.s + " Two "
                   m = 0
                elif m == 3:
                    self.s = self.s + " Three "
                    m = 0
                elif m == 4:
                    self.s = self.s+ " Four "
                    m= 0
                elif m== 5:
                    self.s = self.s + " Five "
                    m = 0
                elif m == 6:
                    self.s = self.s + " Six"
                    m = 0
                elif m == 7:
                    self.s = self.s + " Seven "
                    m = 0
                elif m == 8:
                    self.s = self.s + " Eight "
                    m = 0
                elif m == 9:
                    self.s = self.s + " Nine "
                    m = 0
                elif m == 10:
                    self.s = self.s + " Ten "
                    m = 0
                elif m == 11:
                    self.s = self.s + " Eleven "
                    m = 0
                elif m == 12:
                    self.s = self.s + " Twelve "
                    m = 0
                elif m == 13:
                    self.s = self.s + " Thirteen "
                    m = 0
                elif m == 14:
                    self.s = self.s + "Fourteen"
                    m = 0
                elif m == 15:
                    self.s = self.s + " Fifteen "
                    m = 0
                elif m == 16:
                    self.s = self.s + " Sixteen "
                    m = 0
                elif m == 17:
                    self.s = self.s + " Seventeen "
                    m = 0
                elif m== 18:
                    self.s = self.s + " Eighteen "
                    m = 0
                elif m == 19:
                    self.s = self.s + " Nineteen "
                    m = 0
                elif m >= 20 and m < 30:
                    self.s = self.s + " Twenty "
                    m = m - 20
                elif m >= 30 and m <= 40:
                    self.s = self.s + " Thirty "
                    m = m - 30
                elif m >= 40 and m < 50:
                    self.s = self.s + " Fourty "
                    m = m - 40
                elif m >= 50 and m < 60:
                    self.s = self.s + " Fifty "
                    m = m- 50
                elif m >= 60 and m< 70:
                    self.s = self.s + " Sixty "
                    m = m - 60
                elif m >= 70 and m < 80:
                    self.s = self.s + " Seventy "
                    m = m - 70
                elif m>= 80 and m < 90:
                    self.s = self.s + " Eighty "
                    m = m - 80
                elif m >= 90 and m < 100:
                    self.s = self.s + " Ninety "
                    m = m- 90
        return self.s
    def convert_to_words(self,b):

        while b != 0:
            if b< 100:
                self.s =self.one_to_hundred(b)
                b=0
            elif b >= 100 and b<1000:
                v=math.floor(b/100)
                self.s = self.one_to_hundred(v) + "  Hundred  "
                b = b % 100
            elif b >= 1000 and b<100000:
                v=math.floor(b/1000)
                self.s=self.one_to_hundred(v) + "  Thousand "
                b = b%1000
            elif b >= 100000 and b < 10000000:
                v = math.floor(b / 100000)
                self.s =self.one_to_hundred(v) + "  Lakhs  "
                b =b % 100000
        assert isinstance(self.s, object)
        return self.s
g = int(input("Enter the number :--    "))
a=NumbertoWords()
print(a.convert_to_words(g))