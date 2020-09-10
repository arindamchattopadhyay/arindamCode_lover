/*
You are given n events and their starting and ending times. You may only attend events where you can remain there for its entirety, and you can't attend two events simultaneously. Find the maximum number of events you can attend.

Target: O(n) efficiency O(n logn) with sorting.

Type of problem: Greedy algorithms

Formatting
Input
An integer n representing the number of events, where 1 ≤ n ≤ 100,000. On each of the next n lines, two integers a and b representing the start time and end time, respectively. 1 ≤ a ≤ b ≤ 1,000,000.

Output
A single number representing the maximum number of events you can attend.

Examples
Input 1
4
1 3
2 5
3 9
6 8
Output 1
2
Input 2
7
1 3
4 8
3 5
7 10
5 7
2 8
7 9
Output 2
4
Input 3
5
4 6
5 10
10 15
9 12
1 5
Output 3
3

@author: Arindam
*/

import java.util.*;
public class Events{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int a[][]=new int[n][2];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<2;j++){
				a[i][j]=sc.nextInt();
			}
		}
		Arrays.sort(a,(x,y) -> x[1]-y[1]);

		List<Integer> ob=new ArrayList<>();
		int last_term=a[0][1],count=1;
		for(int i=1;i<n;i++)
		{
			last_term=Math.max(a[i][0],last_term);
			if(a[i][0]<last_term)
				continue;
			else if(a[i][0]>=last_term){
				count++;
				last_term=a[i][1];}
			
		}
		System.out.println(count);

	}
}