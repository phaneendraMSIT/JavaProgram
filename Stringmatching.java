import java.util.*;
import java.nio.*;
import java.io.*;

public class Stringmatching
{
	

	public float Stringmatch(File text1, File text2) throws IOException
	{
		BufferedReader tex1 = new BufferedReader(new FileReader(text1));
		BufferedReader tex2 = new BufferedReader(new FileReader(text2));
		// reading the lines form the files to program 
		String s=tex1.readLine();		
		String m=tex2.readLine();
		// calling check funtion to check the sentences and replace all the sentences with valid input and remove spaces 
		s=check(s);
		m=check(m);
		int a = s.length();
		int b = m.length();
		int [][] arr = new int [a+1][b+1];
		int len =0,pos = -1;
		// check substring by comparing each character in text files 
		for(int i =1;i<a+1;i++)
		{
			for (int j=1;j<b+1;j++)
			{
				if (s.charAt(i-1)==m.charAt(j-1))
				{
					arr[i][j]=arr[i-1][j-1]+1;
					if (arr[i][j]>len)
					{
						len=arr[i][j];
						pos=i;
					}			
				}
				else
				{
					arr[i][j]=0;
				}				
			}
			
		}
		String c =s.substring(pos-len,pos);
		int d = c.length();
	//	System.out.println(c+" : "+d);
		float per;        // per is percent of stringmatching between 2 files 
		per =(d*2*100)/(a+b);
	//	System.out.println(per);
		
		return per;
	}
	
	//function converting upper case characters and special characters into lower case
	// functions also removes special characters 
	public String check(String a)
	{
		int b;
		int i;
		b=a.length();
		String c=a.toLowerCase();
		for (i=0;i<b;i++)
		{
			char e = c.charAt(i);
			int d=(int)a.charAt(i);
			if(d < 97 || d>122 ||d !=32 )
			{
			 break;	
			}
			else
			{
				c=c+e;
			}
		}	
		c=c.replace(" ","");
		return c;		
	}
}