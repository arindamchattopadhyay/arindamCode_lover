# -*- coding: utf-8 -*-
"""
Created on Sun Jul 29 15:39:26 2018

@author: Arindam
"""

import time
class Recursion2:
    c=0
    def TowerofHanoi(self, n ,from_rod, to_rod, other_rod):
    
        if n==1:
            print("\nMove disk 1 from  ",from_rod," to",to_rod)
            self.c=self.c+1
            return
        self.TowerofHanoi(n-1,from_rod,other_rod,to_rod)
        self.c=self.c+1
        print("\nMove disk ",n," from  ",from_rod," to",to_rod)
        self.TowerofHanoi(n-1,other_rod,to_rod,from_rod)
ob = Recursion2()
start=time.time()

ob.TowerofHanoi(15,'A','C','B')
print("Number of moves = ",ob.c)
print("Time taken is = ",time.time()-start)
now=time.gmtime()
print("\n\n",now)
        
        
    