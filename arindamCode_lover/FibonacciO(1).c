#include<stdio.h> 
#include<math.h> 
long fib(long n) { 
  double phi = (1 + sqrt(5)) / 2; 
  return round(pow(phi,(double) n) / sqrt(5)); 
} 
int main () 
{ 
  long n = 25000; 
  printf("%d", fib(n)); 
  return 0; 
} 
