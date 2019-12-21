package unsolved;
//Minimum deletions to make 2 strings anagram
import java.util.*;
import java.io.*;
public class Anagram_Form {
	static int c=26;
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	String a=sc.next();
	String b=sc.next();
	PrintWriter pw=new PrintWriter(System.out);
	System.out.println(Anagram_Form.min_chars_deletion(a,b));
}

public static int min_chars_deletion(String a, String b)
{
	int arr[]=new int[c];
	for(int i=0;i<a.length();i++)
	{
		arr[a.charAt(i)-'a']++;
	}
	for(int i=0;i<b.length();i++)
	{
		arr[b.charAt(i)-'a']--;
	}
	int ans=0;
	for(int i=0;i<c;i++)
	{
		ans+=Math.abs(arr[i]);
	}
	return ans;
}
}
