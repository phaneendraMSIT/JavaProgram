import java.util.*;
import java.nio.*;
import java.io.*;


public class Fingerprinting 
{
	
	@SuppressWarnings({ "resource", "unused" })
	public float fingerprint(File text1,File text2) throws IOException
	{
		BufferedReader tex1 = new BufferedReader(new FileReader(text1));
		BufferedReader tex2 = new BufferedReader(new FileReader(text2));
		// reading the lines form the files to program 
		String s=tex1.readLine();		
		String m=tex2.readLine();
		// calling check funtion to check the sentences and replace all the sentences with valid input and remove spaces 
		   s=check(s);
			m=check(m);
			int k=5;
			int a = s.length();
			//System.out.println("a :"+a);
			int b = m.length();
			//System.out.println("b :"+b);
			int i,j;
			
			int[] shash= new int [a];
			int[] mhash= new int[b];
			int n;
			int countC=0,countS=0,countM=0;
			for(i=0;i<a-(k-1);i++)
			{
				int z=0;
				int sum=0;
				for(j=i;j<i+k;j++)
				{
					n= (int)s.charAt(j);
				
					sum=sum+ (n*(int)Math.pow(k,z));
					z=z+1;					
				}
				shash[i]=sum%10007;
				countS += 1;
			}
			
			for(i=0;i<b-(k-1);i++)
			{
				int z=0;
				int sum=0;
				for(j=i;j<i+k;j++)
				{
					n= (int)m.charAt(j);
					sum=sum+ (n*(int)Math.pow(k,z));
					z=z+1;
				}
				mhash[i]=sum%10007;
				countM += 1;
		//		System.out.println(sum +" : "+mhash[i]);				
			}
		Map<Integer,Integer> hash1= new HashMap<>();
		for(Integer ss : shash)
		{
			hash1.computeIfPresent(ss,(x,v)->v+1);
			  hash1.computeIfAbsent(ss,x->1);	
		}
		hash1.remove(0);
		Map<Integer,Integer> hash2= new HashMap<>();
		for(Integer ss : mhash)
		{
			hash2.computeIfPresent(ss,(x,v)->v+1);
			  hash2.computeIfAbsent(ss,x->1);	
		}
		hash2.remove(0);		
	//	System.out.println(hash1);
	//	System.out.println(hash2);
		for(Map.Entry<Integer, Integer>e1: hash1.entrySet())
		{
			for(Map.Entry<Integer,Integer> e2:hash2.entrySet())
			{
				if(e1.getKey().equals(e2.getKey()))
				{
					if(e1.getValue()<e2.getValue())
							{
					           countC += e1.getValue();
							}
					else
					{
						countC += e2.getValue();
					}
					
				}
			}
		}
		
	//	System.out.println(countS+":"+countM+":"+countC);
		float per;    // per is percent of fringerprinting between 2 files 
		per = ((countC*2*100))/(countS+countM);
		return per;
		}
	
	//function converting upper case charaters and special characters into lower case
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

